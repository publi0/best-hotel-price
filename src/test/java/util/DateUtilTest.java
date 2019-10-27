package util;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilTest {

    @Test
    void isWeekend() {
        assertTrue(DateUtil.IsWeekend(LocalDate.of(2019, 10, 27)), "Saturday, must return true");
        assertTrue(DateUtil.IsWeekend(LocalDate.of(2019, 10, 26)), "Sunday, must return true");
        assertFalse(DateUtil.IsWeekend(LocalDate.of(2019, 10, 28)), "Monday, must return false");
        assertFalse(DateUtil.IsWeekend(LocalDate.of(2019, 10, 29)), "Tuesday, must return false");
    }
}