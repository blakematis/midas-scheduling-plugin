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
public class GetBookingRequests implements IRequest {

    public final String action = Actions.GET_BOOKINGS;

    private final String start;
    private final String end;

    /**
     *
     * @param start Valid date and time (Format: YYYYMMDDHHMM)
     *              <p>Sets the start of the window for which
     *              bookings should be returned.</p>
     * @param end Valid date and time (Format: YYYYMMDDHHMM)
     *            <p>Sets the end of the window for which
     *            bookings should be returned.</p>
     */
    public GetBookingRequests(String start, String end){
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
        return "&action=" + action + "&start=" + start + "&end=" + end;
    }
}
