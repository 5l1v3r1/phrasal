package mt;

/**
 *
 * @author danielcer
 *
 * @param <TK>
 * @param <FV>
 */
abstract public class AbstractBeamInfererBuilder<TK, FV> extends
		AbstractInfererBuilder<TK, FV> {


	int beamCapacity;
	HypothesisBeamFactory.BeamType beamType;

	/**
	 *
	 * @param defaultBeamCapacity
	 */
	public AbstractBeamInfererBuilder(int defaultBeamCapacity, HypothesisBeamFactory.BeamType defaultBeamType) {
		beamCapacity = defaultBeamCapacity;
		beamType = defaultBeamType;
	}


	/**
	 *
	 * @param beamType
	 */
	public void setBeamType(HypothesisBeamFactory.BeamType beamType) {
		this.beamType = beamType;
	}

	/**
	 *
	 * @param beamCapacity
	 * @return
	 */
	public AbstractBeamInfererBuilder<TK,FV> setBeamCapacity(int beamCapacity) {
		if (beamCapacity <= 0) {
			throw new RuntimeException(String.format(
					"Invalid beam capacity, %d. Beam capacity must be > 0", beamCapacity));
		}
		this.beamCapacity = beamCapacity;
		return this;
	}

	@Override
	abstract public Inferer<TK, FV> build();
}
