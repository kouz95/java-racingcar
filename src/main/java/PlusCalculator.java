import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlusCalculator {
	private static final String DELIMITER = ",|:";
	private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");

	public static int calculate(final String value) {
		if (isBlank(value)) {
			return 0;
		}
		return sum(splitValues(value));
	}

	private static boolean isBlank(String value) {
		return value == null || value.isBlank();
	}

	private static int sum(final String[] values) {
		int sum = 0;
		for (final String value : values) {
			final int positive = new Positive(value).getPositive();
			sum += positive;
		}
		return sum;
	}

	private static String[] splitValues(final String value) {
		final Matcher matcher = PATTERN.matcher(value);
		if (hasCustomDelimiter(matcher)) {
			final String customValue = matcher.group(2);
			final String customDelimiter = customDelimiter(matcher);
			return customValue.split(customDelimiter);
		}
		return value.split(DELIMITER);
	}

	private static boolean hasCustomDelimiter(final Matcher matcher) {
		return matcher.find();
	}

	private static String customDelimiter(final Matcher matcher) {
		return DELIMITER + "|" + matcher.group(1);
	}
}
