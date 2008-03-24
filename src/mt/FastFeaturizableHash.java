package mt;

import java.util.ArrayList;

/**
 * 
 * @author danielcer
 *
 * @param <V>
 */
public class FastFeaturizableHash<V> {
	final long offset;
	final ArrayList<V> values; 

	/**
	 * 
	 * @param baseHyp
	 */
	public FastFeaturizableHash() {
		offset = Hypothesis.nextId;
		values = new ArrayList<V>(500000);
	}
	
	/**
	 * 
	 * @param hyp
	 * @param value
	 */
	public void put(Featurizable f, V value) {
		int idx = (int)(f.hyp.id-offset);
		values.ensureCapacity(idx+1);
		while (values.size() <= idx) values.add(null);
		values.set(idx, value);
	}
	
	/**
	 * 
	 * @param hyp
	 * @return
	 */
	public V get(Featurizable f) {
		if (f == null) return null;
		int idx = (int)(f.hyp.id-offset);
		if (idx >= values.size()) return null;
		return values.get(idx);
	}
}
