package mt;

import java.util.*;

/**
 * 
 * @author danielcer
 *
 */
public class Featurizers {
	private Featurizers() { }
	
	/**
	 * 
	 * @param <TK>
	 * @param <FV>
	 * @param featurizers
	 * @return
	 */
	@SuppressWarnings("unchecked")
	static public <TK, FV> List<LanguageModel<TK>> extractNGramLanguageModels(List<IncrementalFeaturizer<TK,FV>> featurizers) {
		int highestOrder = 0;
		List<LanguageModel<TK>> lgModels = new ArrayList(featurizers.size());
		
		for (IncrementalFeaturizer<TK,FV> featurizer : featurizers) {
			if (!(featurizer instanceof NGramLanguageModelFeaturizer)) continue;
			NGramLanguageModelFeaturizer<TK> lmFeaturizer = (NGramLanguageModelFeaturizer<TK>) featurizer;
			lgModels.add(lmFeaturizer.lm);
			int order = lmFeaturizer.order();
			if (order > highestOrder) { 
				highestOrder = order; 
			}
		}
		
		return lgModels;
	}
}
