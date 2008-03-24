package mt;

/**
 * 
 * @author danielcer
 *
 * @param <TK>
 * @param <FV>
 */
public interface InfererBuilder<TK,FV> {
	/**
	 * 
	 * @param phraseGenerator
	 * @return
	 */
	InfererBuilder<TK,FV> setPhraseGenerator(PhraseGenerator<TK> phraseGenerator);
	
	/**
	 * 
	 * @param featurizer
	 * @return
	 */
	InfererBuilder<TK,FV> setIncrementalFeaturizer(IncrementalFeaturizer<TK,FV> featurizer);
	
	/**
	 * 
	 * @param scorer
	 * @return
	 */
	InfererBuilder<TK,FV> setScorer(Scorer<FV> scorer);
	
	/**
	 * 
	 * @param heuristic
	 * @return
	 */
	InfererBuilder<TK,FV> setSearchHeuristic(SearchHeuristic<TK,FV> heuristic);
	
	/**
	 * 
	 * @param recombinationFilter
	 * @return
	 */
	InfererBuilder<TK,FV> setRecombinationFilter(RecombinationFilter<Hypothesis<TK,FV>> recombinationFilter);
	
	/**
	 * 
	 * @return
	 */
	Inferer<TK,FV> build();
}
