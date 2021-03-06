package midas.responses;

import midas.data.GetBooking;

import javax.json.JsonArray;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Handles all bookings between two dates/times
 * @Author Blake Matis
 * @version 1.0
 * @since 1.0
 */
public class GetBookingsResponse extends AbstractMidasJsonArrayResponse {

    private List<GetBooking> bookings;

    /**
     * Builds a bookings list.
     * @param jsonArray the array of get_bookings jsonObjects.
     */
    public GetBookingsResponse(JsonArray jsonArray) {
        super(jsonArray);
        bookings = new ArrayList<>();
        for(int index = 0; index < jsonArray.size(); index++){
            try {
                GetBooking booking = new GetBooking(jsonArray.getJsonObject(index));
                bookings.add(booking);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
     * Finds a booking by its ID
     * @param id the Internal Booking ID.
     * @return GetBooking the details to a specific booking.
     */
    public GetBooking findByID(String id){
        for(GetBooking booking: this.bookings){
            if(booking.getId().equals(id)){
                return booking;
            }
        }
        throw new NullPointerException("Booking not found with that ID");
    }

    /**
     * Finds a booking by Venue and StartTime
     * @param venue Venue
     * @param startTime Start date/time of booking
     * @return GetBooking the details to a specific booking.
     */
    public GetBooking findByVenueAndStartTime(String venue, String startTime) {
        for (GetBooking booking : this.bookings) {
            if (booking.getVenue().toLowerCase().equals(venue.toLowerCase()) && booking.getStart().equals(startTime)) {
                return booking;
            }
        }
        throw new NullPointerException("Could not find booking by venue or start time");
    }

    /**
     * Finds a booking by Venue, StartTime, and Status
     * @param venue Venue
     * @param startTime Start date/time of booking.
     * @param status Denotes whether the booking is a "request", a "confirmed"
     *               booking, or whether it has been "deleted".
     * @return GetBooking the details to a specific booking.
     */
    public GetBooking findByVenueAndStartTimeAndStatus(String venue, String startTime, String status) {
        for (GetBooking booking : this.bookings) {
            if (booking.getVenue().toLowerCase().equals(venue.toLowerCase()) && booking.getStart().equals(startTime)
                    && booking.getStatus().equals(status)) {
                return booking;
            }
        }
        throw new NullPointerException("Could not find booking by venue,start time, and status");
    }

    /**
     * Finds a booking by StartTime
     * @param startTime Start date/time of booking.
     * @return GetBooking the details to a specific booking.
     */
    public GetBooking findByStart(String startTime){
        for(GetBooking booking: this.bookings){
            if(booking.getStart().equals(startTime)){
                return booking;
            }
        }
        throw new NullPointerException("Booking not found with that start time");
    }

    /**
     * Finds all of the bookings in a given range for a specific venue.
     * @param venue Venue
     * @param startTime Start date/time of booking.
     * @param endTime End date/time of booking.
     * @return List<GetBooking> the bookings that were found.
     */
    public List<GetBooking> findBookingsByVenueAndStartTimeAndStopTime(String venue, String startTime, String endTime){
        List<GetBooking> bookings = new ArrayList<>();
        for(GetBooking booking: this.bookings){
            if(booking.getVenue().equals(venue)){
                if(Long.parseLong(booking.getStartFormatted()) >=  Long.parseLong(startTime)
                        && Long.parseLong(booking.getEndFormatted()) <= Long.parseLong(endTime)
                        && booking.getVenue().toLowerCase().equals(venue.toLowerCase())){
                    bookings.add(booking);
                }
            }
        }
        return bookings;
    }

    /**
     * Finds all of the bookings in a given range and adds them to a hashmap by venue name.
     * @param startTime Start date/time of booking.
     * @param endTime End date/time of booking.
     * @return HastMap<Venue names, List<GetBooking>
     */
    public HashMap<String, List<GetBooking>> findBookingsVenueMapTime(String startTime, String endTime){
        HashMap<String, List<GetBooking>> map = new HashMap<>();
        for(GetBooking booking: this.bookings) {
            try {
                if(Long.parseLong(booking.getStartFormatted()) >= Long.parseLong(startTime)
                        && Long.parseLong(booking.getEndFormatted()) <= Long.parseLong(endTime)) {
                    if (map.containsKey(booking.getVenue().toLowerCase())) {
                        List<GetBooking> bookingsForVenue = map.get(booking.getVenue().toLowerCase());
                        bookingsForVenue.add(booking);
                        map.replace(booking.getVenue().toLowerCase(), bookingsForVenue);
                    } else {
                        List<GetBooking> bookingsForVenue = new ArrayList<>();
                        bookingsForVenue.add(booking);
                        map.put(booking.getVenue().toLowerCase(), bookingsForVenue);
                    }
                }
            } catch (NullPointerException e){
                e.printStackTrace();
            }
        }
        return map;

    }

    public List<GetBooking> getBookingsList(){
        return this.bookings;
    }
}
