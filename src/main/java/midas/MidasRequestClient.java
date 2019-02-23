package midas;

import json.JSONReader;
import midas.constants.Actions;
import midas.requests.IRequest;
import midas.responses.AbstractMidasJsonArrayResponse;
import midas.responses.AbstractMidasJsonObjResponse;
import midas.responses.GetBookingResponse;
import midas.responses.GetBookingsResponse;

import javax.json.JsonArray;
import javax.json.JsonObject;
import java.net.MalformedURLException;

/**
 * @author Blake Matis
 * @version 1.0
 * @since 1.0
 *
 * MidasConnection sends an HTTP GET request to the midas api
 * and is used to create a JsonObject.
 *
 * <@see <a href="https://mid.as/api/troubleshooting"></a>
 */
public class MidasRequestClient {

    private final String MIDAS_URL;
    private final String MIDAS_API_KEY;

    /**
     *
     * @param MIDAS_URL The base midas url for their API.
     * @param MIDAS_API_KEY The key used to access the API.
     */
    public MidasRequestClient(String MIDAS_URL, String MIDAS_API_KEY){
        this.MIDAS_URL = MIDAS_URL;
        this.MIDAS_API_KEY = MIDAS_API_KEY;
    }

    /**
     *
     * @param request The type of action request to make.
     * @return The corresponding MidasResponse based on the type of request.
     * @throws MalformedURLException
     */
    public AbstractMidasJsonObjResponse getMidasObjResponse(IRequest request) throws MalformedURLException{
        if(request.requestType().equals(Actions.GET_BOOKING)){
            return new GetBookingResponse(getJsonObj(request));
        }else{
            throw new MalformedURLException("Invalid Url or request not handled");
        }
    }

    public AbstractMidasJsonArrayResponse getMidasArrayResponse(IRequest request) throws MalformedURLException{
        if(request.requestType().equals(Actions.GET_BOOKINGS)){
            return new GetBookingsResponse(getJsonArray(request));
        }else{
            throw new MalformedURLException("Invalid Url or request not handled");
        }
    }

    /**
     *
     * @param request
     * @return
     * @throws MalformedURLException
     */
    public JsonObject getJsonObj(IRequest request) throws MalformedURLException{
        String URL_REQUEST = this.MIDAS_URL + this.MIDAS_API_KEY + request.requestUrl();
        return JSONReader.getJsonObjReply(URL_REQUEST);
    }

    public JsonArray getJsonArray(IRequest request) throws MalformedURLException{
        String URL_REQUEST = this.MIDAS_URL + this.MIDAS_API_KEY + request.requestUrl();
        return JSONReader.getJsonArrayReply(URL_REQUEST);
    }


}
