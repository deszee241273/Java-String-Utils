package functional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestAnagram {

	@ParameterizedTest
	@MethodSource("inputsAndResults")
	@DisplayName("test for anagrammatic char sequence.")
	void test_assert_not_anagram(String[] input, boolean exp) {
		assertEquals(exp, StringAnalysisUtils.isAnagram(input[0], input[1]));
	}

	private static Stream<Arguments> inputsAndResults() {

		return Stream.of(Arguments.of(new String[] { "representationism", "misrepresentation" }, true),
				Arguments.of(new String[] { "pacecar", "carrace" }, false)

		);
	}

}
