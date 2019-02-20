package midas;

import midas.requests.GetBookingRequest;
import midas.responses.GetBookingResponse;
import org.junit.Before;
import org.junit.Test;

import javax.json.JsonObject;
import java.net.MalformedURLException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class GetBookingTest {
    JsonObject bookingResponse = null;
    GetBookingResponse getBookingResponse = null;

    @Before
    public void bookingRequest(){
        GetBookingRequest bookingRequest = new GetBookingRequest(1);
        try {
            bookingResponse = MidasRequestClient.getMidasResponse(bookingRequest);
            getBookingResponse = new GetBookingResponse(bookingResponse);
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

    



}
