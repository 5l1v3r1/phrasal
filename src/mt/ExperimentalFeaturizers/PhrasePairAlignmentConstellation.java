package mt.ExperimentalFeaturizers;

import java.util.List;

import mt.*;

public class PhrasePairAlignmentConstellation implements IncrementalFeaturizer<IString, String>,  IsolatedPhraseFeaturizer<IString,String>  {

	public final String FEATURE_PREFIX = "ACst:";
	
	@Override
	public FeatureValue<String> featurize(Featurizable<IString, String> f) {
		return new FeatureValue<String>(FEATURE_PREFIX+f.option.abstractOption.constilation, 1.0);
	}

	@Override
	public void initialize(List<ConcreteTranslationOption<IString>> options,
			Sequence<IString> foreign) { }

	@Override
	public List<FeatureValue<String>> listFeaturize(
			Featurizable<IString, String> f) { return null; }

	@Override
	public void reset() { }

	@Override
	public FeatureValue<String> phraseFeaturize(Featurizable<IString, String> f) {
		return featurize(f);
	}

	@Override
	public List<FeatureValue<String>> phraseListFeaturize(
			Featurizable<IString, String> f) {
		return listFeaturize(f);
	}

}
