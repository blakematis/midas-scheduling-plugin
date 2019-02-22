package midas;

import midas.requests.GetBookingRequest;
import midas.responses.GetBookingResponse;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static junit.framework.TestCase.assertTrue;

/**
 * @Author: Blake Matis
 * @version 1.0
 * @since 1.0
 * GetBooking Test class
 * <p>
 *     Tests the get_booking action on the MIDAS api.
 * </p>
 */
public class GetBookingTest {

    private static final String MIDAS_BASE_URL = "https://demo.mid.as/api.pl";
    private static final String MIDAS_API_KEY = "?key=797769685251f9i80MWOhwOC";

    private GetBookingResponse getBookingResponse = null;
    private GregorianCalendar startTime = null;


    @Before
    public void bookingRequest(){
        try {
            MidasRequestClient midasRequestClient = new MidasRequestClient(MIDAS_BASE_URL, MIDAS_API_KEY);
            GetBookingRequest bookingRequest = new GetBookingRequest(1);
            getBookingResponse = (GetBookingResponse)midasRequestClient.getMidasResponse(bookingRequest);
            startTime = getBookingResponse.getBooking().getStartCalendar();
        }catch (Exception e){
            e.printStackTrace();
        }
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
