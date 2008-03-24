package mt;

import java.util.*;

/**
 * 
 * @author danielcer
 *
 * @param <TK>
 * @param <FV>
 */
public class ListTopMultiTranslationMetricMax<TK, FV> implements MultiTranslationMetricMax<TK, FV> {
	@Override
	public List<ScoredFeaturizedTranslation<TK, FV>> maximize(
			NBestListContainer<TK, FV> nbest) {
		List<ScoredFeaturizedTranslation<TK,FV>> selected = new LinkedList<ScoredFeaturizedTranslation<TK,FV>>();
		List<List<? extends ScoredFeaturizedTranslation<TK,FV>>> nbestLists = nbest.nbestLists();
		
		for (List<? extends ScoredFeaturizedTranslation<TK,FV>> nbestList : nbestLists) {
			selected.add(nbestList.get(0));
		}	
		return selected;
	}
}