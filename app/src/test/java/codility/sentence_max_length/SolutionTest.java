package codility.sentence_max_length;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {

	Solution s = new Solution();

	@Test
	void shouldReturn0_whenEmpty() {
		int solution = s.solution("");
		assertEquals(0, solution);
	}

	@Test
	void shouldReturn0_whenSpaces() {
		int solution = s.solution("    ");
		assertEquals(0, solution);
	}

	@Test
	void shouldReturn0_whenNull() {
		int solution = s.solution(null);
		assertEquals(0, solution);
	}

	@Test
	void shouldReturn4_withFirstExample() {
		String S = "We test coders. Give us a try?";
		int solution = s.solution(S);
		assertEquals(4, solution);
	}

	@Test
	void shouldReturn2_withSecondExample() {
		String S = "Forget  CVs..Save time . x x";
		int solution = s.solution(S);
		assertEquals(2, solution);
	}

	@Test
	void shouldReturn0_whenOnlySentenceDelimiters() {
		String S = ".!!!??.?.!!";
		int solution = s.solution(S);
		assertEquals(0, solution);
	}
}
