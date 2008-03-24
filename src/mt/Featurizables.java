package mt;


/**
 * Utilities for Featurizables
 * 
 * @author danielcer
 *
 */
public class Featurizables {
	/**
	 * 
	 * @param <TK>
	 * @param <FV>
	 * @param f
	 * @return
	 */
	public static <TK, FV> int locationOfSwappedPhrase(Featurizable<TK,FV> f) {
		return f.hyp.foreignCoverage.nextSetBit(f.foreignPosition+f.foreignPhrase.size());
	}

	public static <TK, FV> int endLocationOfSwappedPhrase(Featurizable<TK,FV> f) {
          int startloc = locationOfSwappedPhrase(f);
          if (startloc == -1) return -1;
          
          return f.hyp.foreignCoverage.nextClearBit(startloc)-1;
	}

	public static <TK, FV> int firstUntranslatedForeignWord(Featurizable<TK,FV> f) {
          return f.hyp.foreignCoverage.nextClearBit(0);
	}
}
