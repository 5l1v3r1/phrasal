package mt;

import java.util.Properties;
import java.util.List;
import java.util.ArrayList;

import edu.stanford.nlp.util.Index;

import it.unimi.dsi.fastutil.ints.Int2IntLinkedOpenHashMap;

/**
 * Class that associates one sparse vector to each alignment template.
 * 
 * @author Michel Galley
 */
public abstract class SparseVectorFeatureExtractor extends AbstractFeatureExtractor {

  private List<Int2IntLinkedOpenHashMap> featureMaps
     = new ArrayList<Int2IntLinkedOpenHashMap>();
  Int2IntLinkedOpenHashMap currentFeatureMap;

  abstract void addFeatureCountsToSparseVector(AlignmentTemplateInstance alTemp, AlignmentGrid alGrid);

  @SuppressWarnings("unchecked")
  void addFeatureCountToSparseVector(String name, int count) {
    int idx = featureIndex.indexOf(name,true);
    currentFeatureMap.put(idx, currentFeatureMap.get(idx)+count);
  }

  public void extract(AlignmentTemplateInstance alTemp, AlignmentGrid alGrid) {
    int idx = alTemp.getKey();
    if(idx < 0)
      return;
    while(idx >= featureMaps.size())
      featureMaps.add(new Int2IntLinkedOpenHashMap());
    currentFeatureMap = featureMaps.get(idx);
    addFeatureCountsToSparseVector(alTemp, alGrid);
  }

  public Object score(AlignmentTemplate alTemp) {
    int idx = alTemp.getKey();
    assert(idx >= 0);
    assert(idx < featureMaps.size());
    return featureMaps.get(idx);
  }
}
