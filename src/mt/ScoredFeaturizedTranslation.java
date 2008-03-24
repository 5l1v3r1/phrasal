package mt;

import java.util.List;

/**
 * 
 * @author danielcer
 *
 * @param <TK>
 * @param <FV>
 */
public class ScoredFeaturizedTranslation<TK, FV> extends
		FeaturizedTranslation<TK, FV> implements Comparable<ScoredFeaturizedTranslation<TK,FV>>{
	public final long latticeSourceId;
	public double score;
	
	/**
	 * 
	 * @param translation
	 * @param features
	 */
	public ScoredFeaturizedTranslation(Sequence<TK> translation,
			List<FeatureValue<FV>> features, double score) {
		super(translation, features);
		this.score = score;
		this.latticeSourceId = -1;
	}
	
	/**
	 * 
	 * @param translation
	 * @param features
	 * @param score
	 * @param latticeSourceId
	 */
	public ScoredFeaturizedTranslation(Sequence<TK> translation,
			List<FeatureValue<FV>> features, double score, long latticeSourceId) {
		super(translation, features);
		this.score = score;
		this.latticeSourceId = latticeSourceId;
	}

	/**
	 * Have sort place things in descending order
	 */
	@Override
	public int compareTo(ScoredFeaturizedTranslation<TK, FV> o) {
		return (int)Math.signum(o.score - score);
	}

}
