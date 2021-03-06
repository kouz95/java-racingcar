package tdd.racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class CarsFactoryTest {
	@Test
	void createCar() {
		final List<String> names = new ArrayList<>();
		names.add("a");
		names.add("b");
		names.add("c");
		names.add("d");

		final Cars cars = CarsFactory.create("a,b,c,d");
		assertEquals(names.size(), cars.stream().count());
	}
}
