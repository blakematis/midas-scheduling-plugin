package midas;

import midas.util.TimeFormat;
import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;

import static org.junit.Assert.assertTrue;

public class TimeFormatTest {

    private GregorianCalendar calendar;
    @Before
    public void CalendarTest(){
        String timeStamp = "4/1/2016 @ 12:00";
        calendar = TimeFormat.calendar(timeStamp);
    }

    @Test
    public void NullTest(){
        assertTrue("Calendar null test", calendar != null);
    }
}
