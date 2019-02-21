package midas;

import midas.data.GetBooking;
import midas.requests.GetBookingRequest;
import midas.responses.GetBookingResponse;
import org.junit.Before;
import org.junit.Test;

import javax.json.JsonObject;
import java.net.MalformedURLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class GetBookingTest {
    private JsonObject bookingResponse = null;
    private GetBookingResponse getBookingResponse = null;
    private GregorianCalendar startTime = null;

    @Before
    public void bookingRequest(){
        try {
            bookingResponse = MidasRequestClient.getMidasResponse(GetBookingRequest.withId(1));
            getBookingResponse = new GetBookingResponse(bookingResponse);
            startTime = getBookingResponse.getBooking().getStartCalendar();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Test
    public void midasResponse(){
        assertTrue("midas response is not null", bookingResponse != null);
    }

    @Test
    public void bookingResponse(){
       assertTrue("testing booking Response", getBookingResponse != null);
    }

    @Test
    public void getBookingId(){
        assertTrue("Booking id test", getBookingResponse.getBooking().getId().equals("1"));
    }

    @Test
    public void getStartTime(){
        assertTrue("Start Time", startTime != null);
    }

    @Test
    public void getStartMonth(){
        assertTrue("Start Month", startTime.get(Calendar.MONTH) == 4);
    }

}
