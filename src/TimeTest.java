import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimeTest {

	@ParameterizedTest
	@ValueSource(strings = {"05:05:05", "00:00:00", "99:99:99"})
	void testGetTotalSecondsGoodAndBoundary(String candidate) {
		int seconds = Time.getTotalSeconds(candidate);
		assertTrue("The seconds were not calculated properly", seconds == 18305 || seconds == 0 || seconds == 362439);
	}
	
	@Test
	void testGetTotalSecondsBad() {
		assertThrows(StringIndexOutOfBoundsException.class, () -> {Time.getTotalSeconds("10:00");});
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"05:05:05", "00:00:00", "99:99:99"})
	void testGetSecondsGoodAndBoundary(String candidate) {
		int seconds = Time.getSeconds(candidate);
		assertTrue("The seconds were not inputted properly", seconds >= 0 && seconds <=99);
	}
	
	@Test
	void testGetSecondsBad() {
		assertThrows(NumberFormatException.class, () -> {Time.getSeconds("-10:00:1");});
		assertThrows(StringIndexOutOfBoundsException.class, () -> {Time.getSeconds("10:00:1");});
	}

	@ParameterizedTest
	@ValueSource(strings = {"05:05:05", "00:00:00", "99:99:99"})
	void testGetTotalMinutesGoodAndBoundary(String candidate) {
		int minutes = Time.getTotalMinutes(candidate);
		assertTrue("The seconds were not inputted properly", minutes >= 0 && minutes <=99);
	}
	
	@Test
	void testGetTotalMinutesBad() {
		assertThrows(NumberFormatException.class, () -> {Time.getTotalMinutes("10:000:12");});
	}

	@ParameterizedTest
	@ValueSource(strings = {"05:05:05", "00:00:00", "99:99:99"})
	void testGetTotalHoursGoodAndBoundary(String candidate) {
		int hours = Time.getTotalHours(candidate);
		assertTrue("The hours were not calculated properly", hours == 5 || hours == 0 || hours == 99);
	}
	
	@Test
	void testGetTotalHoursBad() {
		assertThrows(NumberFormatException.class, () -> {Time.getTotalHours("1:00");});
		assertThrows(StringIndexOutOfBoundsException.class, () -> {Time.getTotalHours("-");});
	}

}
