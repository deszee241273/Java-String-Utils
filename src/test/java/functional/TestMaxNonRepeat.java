package functional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestMaxNonRepeat {

	@ParameterizedTest
	@MethodSource("inputsAndResults")
	@DisplayName("input test string contains repeats.")
	void test_with_repeats(String input, int expectedResult) {

		assertEquals(expectedResult, StringAnalysisUtils.findLengthMaxSequence(input));
	}

	private static Stream<Arguments> inputsAndResults() {

		return Stream.of(

				Arguments.of("abcdd", 4), Arguments.of("abcccdefg", 5), Arguments.of("abbccd", 2),
				Arguments.of("11", 1), Arguments.of("abcdefghijklmn", 14));
	}

}
