package midas;

import json.JSONReader;
import midas.constants.Actions;
import midas.requests.IRequest;
import midas.responses.AbstractMidasJsonResponse;
import midas.responses.GetBookingResponse;

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
    public AbstractMidasJsonResponse getMidasResponse(IRequest request) throws MalformedURLException{
        if(request.requestType().equals(Actions.GET_BOOKING)){
            return new GetBookingResponse(getJsonObject(request));
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
    private JsonObject getJsonObject(IRequest request) throws MalformedURLException{
        String URL_REQUEST = MIDAS_URL + MIDAS_API_KEY + request.requestUrl();
        return JSONReader.getJsonReply(URL_REQUEST);
    }


}
