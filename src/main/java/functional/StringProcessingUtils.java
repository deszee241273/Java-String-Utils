package functional;

import static java.util.function.Function.identity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class StringProcessingUtils {

	/**
	 * 
	 * @param a the first string.
	 * @param b the second string.
	 * @return anagrammatic result.
	 */
	static boolean isAnagram(String a, String b) {

		Objects.requireNonNull(a);
		Objects.requireNonNull(b);

		// compare length.
		if (a.length() != b.length())
			return false;
		// compare Map equalities.
		return freqMapFactory(a).entrySet().equals(freqMapFactory(b).entrySet());

	}

	private static Map<Character, Long> freqMapFactory(String str) {

		return str.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(identity(), HashMap::new, Collectors.counting()));

	}

	static int maxNonRepeatCharSequence(String str) {

		Objects.requireNonNull(str);

		if (str.length() == freqMapFactory(str).size())
			return str.length();

		var set = new HashSet<String>();
		var countMax = new AtomicInteger();

		str.chars().mapToObj(c -> "" + (char) c).forEachOrdered(o -> {

			if (!set.add(o)) {

				countMax.set(Math.max(countMax.get(), set.size()));
				set.clear();
			}

		});

		return countMax.get() > set.size() ? countMax.get() : set.size();

	}

	private StringProcessingUtils() {
	}

}
