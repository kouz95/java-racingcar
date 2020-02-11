package tdd.racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RoundTest {
	private static final String NOT_NUMBER_INPUT = "A";
	private static final String ZERO_INPUT = "0";

	@Test
	void canValidateRoundForNotNumber() {
		assertThatIllegalArgumentException().isThrownBy(() ->
			new Round(NOT_NUMBER_INPUT))
			.withMessage("횟수는 숫자이어야 합니다.");
	}

	@Test
	void canValidateRoundForZero() {
		assertThatIllegalArgumentException().isThrownBy(() ->
			new Round(ZERO_INPUT))
			.withMessage("횟수는 1이상 이어야 합니다.");
	}
}
