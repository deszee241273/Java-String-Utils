package functional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestAnagram {

	@Test
	@DisplayName("input strings are anagrammatic.")
	void test_assert_anagram() {
		assertTrue(StringProcessingUtils.isAnagram("racecar", "carrace"));
	}

	@Test
	@DisplayName("input strings are not anagrammatic.")
	void test_assert_not_anagram() {
		assertFalse(StringProcessingUtils.isAnagram("pacecar", "carrace"));
	}

}
