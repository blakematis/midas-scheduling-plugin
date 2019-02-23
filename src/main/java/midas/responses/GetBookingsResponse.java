package midas.responses;

import midas.data.GetBooking;

import javax.json.JsonArray;
import java.util.ArrayList;
import java.util.List;

public class GetBookingsResponse extends AbstractMidasJsonArrayResponse {

    private List<GetBooking> bookings;

    public GetBookingsResponse(JsonArray jsonArray) {
        super(jsonArray);
        bookings = new ArrayList<>();
        for(int index = 0; index < jsonArray.size(); index++){
            try {
                GetBooking booking = new GetBooking(jsonArray.getJsonObject(index));
                bookings.add(booking);
            }catch (NullPointerException e){

            }
        }
    }

    public GetBooking findByID(String id){
        for(GetBooking booking: this.bookings){
            if(booking.getId().equals(id)){
                return booking;
            }
        }
        throw new NullPointerException("Booking not found with that ID");
    }

    public GetBooking findByVenueAndStartTime(String venue, String startTime) {
        for (GetBooking booking : this.bookings) {
            if (booking.getVenue().equals(venue) && booking.getStart().equals(startTime)) {
                return booking;
            }
        }
        throw new NullPointerException("Could not find booking by venue or start time");
    }

    public GetBooking findByStart(String startTime){
        for(GetBooking booking: this.bookings){
            if(booking.getStart().equals(startTime)){
                return booking;
            }
        }
        throw new NullPointerException("Booking not found with that start time");
    }

    public List<GetBooking> getBookingsList(){
        return this.bookings;
    }
}
