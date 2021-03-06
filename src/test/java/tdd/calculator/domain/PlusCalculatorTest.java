package tdd.calculator.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PlusCalculatorTest {
	@Test
	void plusTwoNumberSplitByComma() {
		final String value = "1,2";
		final int actual = PlusCalculator.calculate(value);
		final int expected = 3;
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void plusNumbersSplitByComma() {
		final String threeValues = "1,2,3";
		final int actualForThreeValues = PlusCalculator.calculate(threeValues);
		final int expectedForThreeValues = 6;
		assertThat(actualForThreeValues).isEqualTo(expectedForThreeValues);

		final String fourValues = "1,2,3,4";
		final int actualForFourValues = PlusCalculator.calculate(fourValues);
		final int expectedForFourValues = 10;
		assertThat(actualForFourValues).isEqualTo(expectedForFourValues);
	}

	@Test
	void plusTwoNumberSplitByColon() {
		final String value = "1:2";
		final int actual = PlusCalculator.calculate(value);
		final int expected = 3;
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void plusNumbersSplitByColon() {
		final String threeValues = "1:2:3";
		final int actualForThreeValues = PlusCalculator.calculate(threeValues);
		final int expectedForThreeValues = 6;
		assertThat(actualForThreeValues).isEqualTo(expectedForThreeValues);

		final String fourValues = "1:2:3:4";
		final int actualForFourValues = PlusCalculator.calculate(fourValues);
		final int expectedForFourValues = 10;
		assertThat(actualForFourValues).isEqualTo(expectedForFourValues);
	}

	@Test
	void plusNumbersSplitByCommaAndColon() {
		final String threeValues = "1,2:3";
		final int actualForThreeValues = PlusCalculator.calculate(threeValues);
		final int expectedForThreeValues = 6;
		assertThat(actualForThreeValues).isEqualTo(expectedForThreeValues);

		final String fourValues = "1:2,3:4";
		final int actualForFourValues = PlusCalculator.calculate(fourValues);
		final int expectedForFourValues = 10;
		assertThat(actualForFourValues).isEqualTo(expectedForFourValues);
	}

	@Test
	void plusNumbersSplitByCustomDelimiter() {
		final String customValue = "//;\n1;2;3";
		final int expected = 6;
		final int actual = PlusCalculator.calculate(customValue);
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void plusNumbersSplitByMixedDelimiter() {
		final String customValue = "//;\n1;2,3:4";
		final int expected = 10;
		final int actual = PlusCalculator.calculate(customValue);
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void plusForNegativeNumber() {
		final String customValue = "//;\n1;2,-3:4";
		assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> PlusCalculator.calculate(customValue));
	}

	@Test
	void plusForNotNumber() {
		final String customValue = "//;\n1;2,a,3,4";
		assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> PlusCalculator.calculate(customValue));
	}

	@Test
	public void plusForNullOrEmpty() {
		int result = PlusCalculator.calculate(null);
		assertThat(result).isEqualTo(0);

		result = PlusCalculator.calculate("");
		assertThat(result).isEqualTo(0);
	}

	@Test
	public void plusNegative() {
		assertThatThrownBy(() -> PlusCalculator.calculate("-1,2,3"))
			.isInstanceOf(RuntimeException.class);
	}
}
