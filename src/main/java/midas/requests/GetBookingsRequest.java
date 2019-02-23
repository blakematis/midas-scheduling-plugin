package midas.requests;

import midas.constants.Actions;

/**
 *
 * @Author Blake Matis
 * @version 1.0
 * @since 1.0
 * @see <a href="https://mid.as/api/get_bookings">Midas get_bookings api reference</a>
 *
 */
public class GetBookingsRequest implements IRequest {

    public final String action = Actions.GET_BOOKINGS;


    //Required Parameters
    private final String start;
    private final String end;

    //Optional Parameters
    private String venue = "";
    private String type = "";
    private String status = "";

    /**
     *
     * @param start Valid date and time (Format: YYYYMMDDHHMM)
     *              <p>Sets the start of the window for which
     *              bookings should be returned.</p>
     * @param end Valid date and time (Format: YYYYMMDDHHMM)
     *            <p>Sets the end of the window for which
     *            bookings should be returned.</p>
     */
    public GetBookingsRequest(String start, String end){
        this.start = start;
        this.end = end;
    }

    /**
     * @return The type of command to be sent.
     */
    @Override
    public String requestType() {
        return action;
    }

    /**
     * @return The command reference with all of its required and/or optional parameters.
     */
    @Override
    public String requestUrl() {
        String requestUrl = "&action=" + this.action + "&start=" + this.start + "&end=" + this.end;
        if(!this.venue.isEmpty()) {
            requestUrl += "&venue=" + this.venue;
        }
        if (!this.type.isEmpty()) {
            requestUrl += "&type=" + this.type;
        }
        if(!this.status.isEmpty()){
            requestUrl += "&status=" + this.status;
        }
        return requestUrl;
    }

    public void setVenue(String venue){
        this.venue = venue;
    }

    public void setType(String type){
        this.type = type;
    }

    public void setStatus(String status){
        this.status = status;
    }
}
