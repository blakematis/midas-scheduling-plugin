package midas;

import json.JSONReader;
import midas.requests.GetBookingRequest;
import midas.requests.IRequest;
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

    private static final String MIDAS_BASE_URL = "https://demo.mid.as/api.pl";
    private static final String MIDAS_API_KEY = "?key=797769685251f9i80MWOhwOC";


    /**
     *
     * @param baseUrl
     * @param apiKey
     * @param request
     * @return
     * @throws MalformedURLException
     */
    public static JsonObject getMidasResponse(String baseUrl, String apiKey, IRequest request) throws MalformedURLException{
        String URL_REQUEST = baseUrl + apiKey + request.requestUrl();
        return JSONReader.getJsonReply(URL_REQUEST);
    }

    /**
     *
     * @param request
     * @return
     * @throws MalformedURLException
     */
    public static JsonObject getMidasResponse(IRequest request) throws MalformedURLException{
        String URL_REQUEST = MIDAS_BASE_URL + MIDAS_API_KEY + request.requestUrl();
        return JSONReader.getJsonReply(URL_REQUEST);
    }

    public static void main(String[] args) throws MalformedURLException{
        GetBookingRequest bookingRequest = new GetBookingRequest(0);
        JsonObject bookingResponse = getMidasResponse(bookingRequest);
        System.out.println(bookingResponse.toString());
    }

}
