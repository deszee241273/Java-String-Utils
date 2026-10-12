package functional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestPalindrome {

	@ParameterizedTest
	@MethodSource("assertions")
	@DisplayName("test for palindromic char sequence.")
	void test(String input, boolean exp) {

		assertEquals(exp, StringAnalysisUtils.isPalindrome(input));
	}

	private static Stream<Arguments> assertions() {

		return Stream.of(Arguments.of("kayak", true), Arguments.of("pacecar", false),
				Arguments.of("detartrated", true)

		);
	}

}
