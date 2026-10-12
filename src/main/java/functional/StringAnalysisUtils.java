package functional;

import static java.util.function.Function.identity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringAnalysisUtils {

	/**
	 * 
	 * @param a the first string.
	 * @param b the second string.
	 * @return true if a and b are anagrams.
	 */
	static boolean isAnagramOf(String a, String b) {

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

	static int findLengthMaxSequence(String str) {

		Objects.requireNonNull(str);

		if (str.length() == freqMapFactory(str).size()) {
			log.info("tested String," + str + ", has no duplicate character");
			return str.length();
		}

		var stringSet = new HashSet<String>();
		var countMax = new AtomicInteger();

		str.replaceAll("\\s+", "").chars().mapToObj(c -> "" + (char) c).forEachOrdered(o -> {
			// algorithm
			// - add string to stringSet,
			// - if not added set countMax and clear
			// charSet.
			if (!stringSet.add(o)) {

				countMax.set(Math.max(countMax.get(), stringSet.size()));
				stringSet.clear();
			}

		});

		return Math.max(countMax.get(), stringSet.size());

	}

	static boolean isPalindrome(String str) {

		return freqMapFactory(str.replaceAll("\\s+", "")).values().stream().filter(count -> count % 2 != 0)
				.count() <= 1;

	}

	private static Map<Integer, Long> freqMapFactory(String str) {

		return str.chars().boxed().collect(Collectors.groupingBy(identity(), HashMap::new, Collectors.counting()));

	}

	private StringAnalysisUtils() {
	}

}
