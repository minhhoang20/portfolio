package ground;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestArithmetic {

	@Test(expected = IllegalArgumentException.class)
	public void testNotEnoughItemsArray() {
		int[] notEnoughItemsArray = { 1, 2 };
		Solution solution = new Solution();
		solution.solution(notEnoughItemsArray);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testExceedingSizeArray() {
		int size = 1000001;
		int[] exceedingSize = new int[size];
		for (int i = 0; i < size; i++) {
			exceedingSize[i] = i;
		}
		Solution solution = new Solution();
		solution.solution(exceedingSize);
	}

	@Test
	public void testExceedingResult() {
		int size = 100000;
		int[] exceedingSize = new int[size];
		for (int i = 0; i < size; i++) {
			exceedingSize[i] = i;
		}
		Solution solution = new Solution();
		int actualResponse = solution.solution(exceedingSize);
		assertEquals("The response is not what is expected.", -1,
				actualResponse);
	}

	@Test
	public void testCornerCase() {
		int[] validArray = { 1, 2, 3 };
		int expectedResponse = 1;
		Solution solution = new Solution();
		int actualResponse = solution.solution(validArray);
		assertEquals("The response is not what is expected.", expectedResponse,
				actualResponse);

		int[] invalidArray = { 1, 2, 5 };
		expectedResponse = 0;
		solution = new Solution();
		actualResponse = solution.solution(invalidArray);
		assertEquals("The response is not what is expected.", expectedResponse,
				actualResponse);
	}

	@Test
	public void testSuccessPath() {
		int[] validArray = { -1, 1, 3, 3, 3, 2, 1, 0 };
		int expectedResponse = 5;
		Solution solution = new Solution();
		int actualResponse = solution.solution(validArray);
		assertEquals("The response is not what is expected.", expectedResponse,
				actualResponse);
	}

	@Test
	public void testFailPath() {
		int[] notArithmeticArray = { 1, 1, 4, 5, 7 };
		int expectedResponse = 0;
		Solution solution = new Solution();
		int actualResponse = solution.solution(notArithmeticArray);
		assertEquals("The response is not what is expected.", expectedResponse,
				actualResponse);
	}
}