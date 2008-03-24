package mt;

import java.util.*;

/**
 * 
 * @author danielcer
 *
 * @param <T>
 */
public interface PhraseTable<T> {
	
	/**
	 * 
	 * @param sequence
	 * @return
	 */
	List<TranslationOption<T>> getTranslationOptions(Sequence<T> sequence);
	
	/**
	 * 
	 * @return
	 */
	int longestForeignPhrase();
	
	/**
	 * 
	 * @return
	 */
	String[] getPhrasalScoreNames();
	
	/**
	 * 
	 * @return
	 */
	String getName();
}
