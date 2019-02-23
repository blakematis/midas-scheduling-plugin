package midas;

import midas.requests.GetBookingsRequest;
import midas.responses.GetBookingsResponse;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @Author: Blake Matis
 * @version 1.0
 * @since 1.0
 * GetBookings Test class
 * <p>
 *     Test the get_bookings action on the MIDAS api.
 * </p>
 */
public class GetBookingsTest {

    private static final String MIDAS_BASE_URL = "https://demo.mid.as/api.pl";
    private static final String MIDAS_API_KEY = "?key=797769685251f9i80MWOhwOC";

    private GetBookingsResponse getBookingsResponse = null;

    @Before
    public void getBooking(){
        MidasRequestClient midasRequestClient = new MidasRequestClient(MIDAS_BASE_URL, MIDAS_API_KEY);
        try {
            getBookingsResponse = (GetBookingsResponse) midasRequestClient.getMidasArrayResponse(new GetBookingsRequest("201902010000", "201902220000"));
        } catch (NullPointerException e){
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testBookings(){
        assertTrue("testBookings", getBookingsResponse != null);
    }

    @Test
    public void testBookingsSize(){
        assertTrue("booking size is not zero", getBookingsResponse.getBookingsList().size() > 0);
    }

    @Test
    public void getBookingByID(){
        assertTrue("booking by id", getBookingsResponse.findByID("3591") != null);
    }

    @Test
    public void getBookingByStart(){
        assertTrue("booking by start", getBookingsResponse.findByStart("5/2/2019 @ 12:30")!= null);
    }

    @Test
    public void getBookingByVenueAndStart(){
        assertTrue("booking by venue and start", getBookingsResponse.findByVenueAndStartTime("Room 1", "5/2/2019 @ 12:30") != null);
    }

}
