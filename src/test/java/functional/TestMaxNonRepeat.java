package functional;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestMaxNonRepeat {

	@Test
	@DisplayName("input test string has no duplicates.")
	void test_without_repeats() {
		assertEquals(14, StringProcessingUtils.maxNonRepeatCharSequence("abcdefghijklmn"));
	}

	@Test
	@DisplayName("input test string contains duplicates.")
	void test_with_repeats() {
		assertEquals(4, StringProcessingUtils.maxNonRepeatCharSequence("abcdd"));
		assertEquals(5, StringProcessingUtils.maxNonRepeatCharSequence("abcccdefg"));
		assertEquals(2, StringProcessingUtils.maxNonRepeatCharSequence("abbccd"));
	}

}
