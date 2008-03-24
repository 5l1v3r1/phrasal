package mt;

class MetricBasedRecombinationFilter<TK,FV> implements RecombinationFilter<MultiTranslationState<TK, FV>> {
	RecombinationFilter<IncrementalEvaluationMetric<TK,FV>> metricFilter;
	
	public MetricBasedRecombinationFilter(EvaluationMetric<TK,FV> metric) {
		metricFilter = metric.getIncrementalMetricRecombinationFilter();
	}
	
	@Override
	public boolean combinable(MultiTranslationState<TK, FV> hypA,
			MultiTranslationState<TK, FV> hypB) {
		return metricFilter.combinable(hypA.incMetric, hypB.incMetric);
	}

	@Override
	public long recombinationHashCode(MultiTranslationState<TK, FV> hyp) {
		return metricFilter.recombinationHashCode(hyp.incMetric);
	}
	
}
