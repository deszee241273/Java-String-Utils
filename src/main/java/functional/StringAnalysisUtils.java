package functional;

import static java.util.function.Function.identity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class StringAnalysisUtils {

	/**
	 * 
	 * @param a the first string.
	 * @param b the second string.
	 * @return anagrammatic result.
	 */
	static boolean isAnagram(String a, String b) {

		Objects.requireNonNull(a);
		Objects.requireNonNull(b);

		if (a.equals(b))
			return true;

		// compare length.
		if (a.length() != b.length())
			return false;
		// compare Map equalities.
		return freqMapFactory(a).entrySet().equals(freqMapFactory(b).entrySet());

	}

	static int maxNonRepeatSequence(String str) {

		Objects.requireNonNull(str);

		if (str.length() == freqMapFactory(str).size())
			return str.length();

		var charSet = new HashSet<String>();
		var countMax = new AtomicInteger();

		str.chars().mapToObj(c -> "" + (char) c).forEachOrdered(o -> {

			if (!charSet.add(o)) {

				countMax.set(Math.max(countMax.get(), charSet.size()));
				charSet.clear();
			}

		});

		var sz = charSet.size();
		return countMax.get() > sz ? countMax.get() : sz;

	}

	static boolean isPalindrome(String text) {

		return text.replaceAll("\\s+", "").chars().boxed()
				.collect(Collectors.groupingBy(identity(), Collectors.counting())).values().stream()
				.filter(count -> count % 2 != 0).count() <= 1;

	}

	private static Map<Integer, Long> freqMapFactory(String str) {

		return str.chars().boxed().collect(Collectors.groupingBy(identity(), HashMap::new, Collectors.counting()));

	}

	private StringAnalysisUtils() {
	}

}
