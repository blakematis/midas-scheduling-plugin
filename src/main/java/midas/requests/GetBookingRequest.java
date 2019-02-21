package midas.requests;

import midas.constants.Actions;

/**
 *
 * @Author Blake Matis
 * @version 1.0
 * @since 1.0
 * @see <a href="https://mid.as/api/get_booking">Midas get_booking api reference</a>
 *
 */
public class GetBookingRequest implements IRequest {

    /** Action **/
    private final String action = Actions.GET_BOOKING;

    /** Required Parameters **/
    private final int id;

    /**
     * Returns details of a specific booking
     * @param id The Unique numerical reference of the booking
     */
    public GetBookingRequest(int id){
        this.id = id;
    }

    public static GetBookingRequest withId(int id){
        return new GetBookingRequest(id);
    }

    public int getId() {
        return id;
    }

    public String getAction(){
        return action;
    }

    @Override
    public String requestUrl() {
        return "&action=" + action + "&id=" + id;
    }
}
