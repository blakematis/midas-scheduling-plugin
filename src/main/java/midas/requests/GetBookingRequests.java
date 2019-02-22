package midas.requests;

import midas.constants.Actions;

public class GetBookingRequests implements IRequest {

    public final String Action = Actions.GET_BOOKINGS;

    /**
     * @return The type of command to be sent.
     */
    @Override
    public String requestType() {
        return Action;
    }

    /**
     * @return The command reference with all of its required and/or optional parameters.
     */
    @Override
    public String requestUrl() {
        return null;
    }
}
