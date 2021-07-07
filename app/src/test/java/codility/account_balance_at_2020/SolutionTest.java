package codility.account_balance_at_2020;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class SolutionTest {

	Solution s = new Solution();

	@Test
	void shouldReturnMinus60_whenEmpty() {
		int[] A = new int[0];
		String[] D = new String[0];
		int solution = s.solution(A, D);
		assertEquals(-60, solution);
	}

	@Test
	void shouldFail_whenArraysSizeDoesNotMatch() {
		int[] A = new int[0];
		String[] D = new String[] { "1" };
		assertThrows(IllegalArgumentException.class, () -> s.solution(A, D));
	}

	@Test
	void shouldFulfillTest1() {
		int[] A = new int[] { 100, 100, 100 };
		String[] D = new String[] { "2020-12-31", "2020-12-22", "2020-12-03" };
		int solution = s.solution(A, D);

		assertEquals(240, solution);
	}

	@Test
	void shouldFulfillTest2() {
		int[] A = new int[] { 180, -50, -25, -25 };
		String[] D = new String[] { "2020-01-01", "2020-01-01", "2020-01-01", "2020-01-31" };
		int solution = s.solution(A, D);

		assertEquals(25, solution);
	}

	@Test
	void shouldFulfillTest3() {
		int[] A = new int[] { 1, -1, 0, -105, 1 };
		String[] D = new String[] { "2020-12-31", "2020-04-04", "2020-04-04", "2020-04-14", "2020-07-12" };
		int solution = s.solution(A, D);

		assertEquals(-164, solution);
	}

	@Test
	void shouldFulfillTest4() {
		int[] A = new int[] { 100, 100, -10, -20, -30 };
		String[] D = new String[] { "2020-01-01", "2020-02-01", "2020-02-11", "2020-02-05", "2020-02-08" };
		int solution = s.solution(A, D);

		assertEquals(80, solution);
	}

}
