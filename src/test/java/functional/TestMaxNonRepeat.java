package functional;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestMaxNonRepeat {

	@Test
	@DisplayName("input test string has no duplicates.")
	void test_without_repeats() {
		assertEquals(14, StringAnalysisUtils.maxNonRepeatCharSequence("abcdefghijklmn"));
	}

	@ParameterizedTest
	@MethodSource("inputsAndResults")
	@DisplayName("input test string contains duplicates.")
	void test_with_repeats(String input, int expectedResult) {

		assertEquals(expectedResult, StringAnalysisUtils.maxNonRepeatCharSequence(input));
	}

	private static Stream<Arguments> inputsAndResults() {

		return Stream.of(

				Arguments.of("abcdd", 4), Arguments.of("abcccdefg", 5), Arguments.of("abbccd", 2));
	}

}
