package functional;

import static java.util.Comparator.comparingInt;
import static java.util.function.Function.identity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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

		// check lengths.
		if (a.length() != b.length())
			return false;

		// string a
		var mapA = a.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(identity(), HashMap::new, Collectors.counting()));

		// string b.

		var mapB = b.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(identity(), HashMap::new, Collectors.counting()));

		return mapA.entrySet().equals(mapB.entrySet());

	}

	static int maxNonRepeatCharSequence(String str) {

		Objects.requireNonNull(str);
		var frequencyMap = str.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(identity(), LinkedHashMap::new, Collectors.counting()));

		if (str.length() == frequencyMap.size())
			return str.length();

		var set = new HashSet<String>();
		var max = new HashSet<String>();
		var sb = new StringBuilder();

		str.chars().mapToObj(c -> "" + (char) c).forEachOrdered(c -> {

			if (set.add(c)) {
				sb.append(c);
			} else {
				set.clear();
				max.add(sb.toString());
				sb.setLength(0);
			}

		});
		if (!sb.isEmpty())
			max.add(sb.toString());

		var longest = max.stream().max(comparingInt(String::length)).orElseThrow().length();
		log.info("Max length non-repeat:" + longest);

		return longest;

	}

	private StringProcessingUtils() {
	}

}
