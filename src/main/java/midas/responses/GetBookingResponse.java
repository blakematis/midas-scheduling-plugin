package midas.responses;

import midas.data.GetBooking;

import javax.json.JsonObject;

/**
 * @Author Blake Matis
 * @version 1.0
 * @since 1.0
 *
 * Maps the get_booking response from midas api into java objects.
 *
 */
public class GetBookingResponse extends AbstractMidasJsonResponse {

    private final GetBooking booking;

    public GetBookingResponse(JsonObject jsonObject) {
        super(jsonObject);
        booking = new GetBooking(jsonObject);
    }

    public GetBooking getBooking() {
        return booking;
    }
}
