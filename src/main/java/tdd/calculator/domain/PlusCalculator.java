package tdd.calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import tdd.calculator.util.InputUtils;

public class PlusCalculator {
	private static final int DEFAULT_VALUE = 0;

	public static int calculate(final String value) {
		if (isBlank(value)) {
			return DEFAULT_VALUE;
		}
		final List<UnsignedNumber> unsignedNumbers = toUnsignedNumbers(InputUtils.splitValues(value));
		return sum(unsignedNumbers);
	}

	private static boolean isBlank(final String value) {
		return value == null || value.isBlank();
	}

	private static List<UnsignedNumber> toUnsignedNumbers(final String[] values) {
		return Arrays.stream(values)
			.map(UnsignedNumber::new)
			.collect(Collectors.toList());
	}

	private static int sum(final List<UnsignedNumber> unsignedNumbers) {
		return unsignedNumbers.stream()
			.mapToInt(UnsignedNumber::getValue)
			.sum();
	}
}
