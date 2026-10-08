package functional;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestDuplicates {

	@Test
	@DisplayName("input test string has no duplicates.")
	void test_base_case() {
		assertEquals(14, StringProcessingUtils.maxNonRepeatCharSequence("abcdefghijklmn"));
	}

	@Test
	@DisplayName("input test string contains duplicates.")
	void testMax() {
		assertEquals(4, StringProcessingUtils.maxNonRepeatCharSequence("abcdd"));
		assertEquals(2, StringProcessingUtils.maxNonRepeatCharSequence("abbccd"));
	}

	@Test
	@DisplayName("input test string contains duplicates.")
	void testMax5() {
		assertEquals(5, StringProcessingUtils.maxNonRepeatCharSequence("abcccdefg"));
	}
}
