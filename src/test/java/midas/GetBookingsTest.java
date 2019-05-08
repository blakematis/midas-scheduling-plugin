package midas;

import midas.data.GetBooking;
import midas.requests.GetBookingsRequest;
import midas.responses.GetBookingsResponse;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static java.lang.String.valueOf;
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

    private static final String MIDAS_BASE_URL = "https://demo.mid.as//api.pl";
    private static final String MIDAS_API_KEY = "?key=797769685251f9i80MWOhwOC";

    private GetBookingsResponse getBookingsResponse = null;

    @Before
    public void getBooking(){
        MidasRequestClient midasRequestClient = new MidasRequestClient("https://jessup.mid.as//api.pl", "?key=564950505150yHcr7OCcwml8");
        try {
            getBookingsResponse = (GetBookingsResponse) midasRequestClient.getMidasArrayResponse(new GetBookingsRequest("201905050000", "201905130000"));
            //getBookingsResponse = (GetBookingsResponse) midasRequestClient.getMidasArrayResponse(new GetBookingsRequest("201901120000", "201905130000"));
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

    @Test
    public void getBookingMap(){
        System.out.println(getBookingsResponse.getBookingsList().size());
        //HashMap<String, List<GetBooking>> map = getBookingsResponse.findBookingsVenueMapTime("201904200000", "201904280000");
        HashMap<String, List<GetBooking>> map = getBookingsResponse.findBookingsVenueMapTime("201905050000", "201905130000");
        System.out.println(map.size());
        Iterator itr = map.keySet().iterator();
        int size = 0;
        while(itr.hasNext()){
            String key = valueOf(itr.next());
            size += map.get(key.toString()).size();
            List<GetBooking> bookings =map.get(key.toString().toLowerCase());
            Iterator bookingItr = bookings.iterator();
            while (bookingItr.hasNext()){
                GetBooking booking = (GetBooking) bookingItr.next();
                System.out.println(booking.getVenue() + " start: " + booking.getStart() + " end: " + booking.getEnd());
                System.out.println(booking.getVenue() + " start: " + booking.getStartFormatted() + " end: " + booking.getEndFormatted());
            }
        }
        System.out.println(size);

    }

}
