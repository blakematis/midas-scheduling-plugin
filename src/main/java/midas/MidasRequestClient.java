package midas;

import json.JSONReader;
import midas.constants.Actions;
import midas.requests.GetBookingRequest;
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





    public static AbstractMidasJsonResponse getMidasResponse(String baseUrl, String apiKey, IRequest request) throws MalformedURLException{
        if(request.requestType().equals(Actions.GET_BOOKING)){
            return new GetBookingResponse(getJsonObject(baseUrl, apiKey, request));
        }else{
            throw new MalformedURLException("Invalid Url or request not handled");
        }
    }

    /**
     *
     * @param baseUrl
     * @param apiKey
     * @param request
     * @return
     * @throws MalformedURLException
     */
    public static JsonObject getJsonObject(String baseUrl, String apiKey, IRequest request) throws MalformedURLException{
        String URL_REQUEST = baseUrl + apiKey + request.requestUrl();
        return JSONReader.getJsonReply(URL_REQUEST);
    }


}
