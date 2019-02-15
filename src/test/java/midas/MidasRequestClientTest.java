package midas;

import midas.requests.GetBookingRequest;

import javax.json.JsonObject;
import java.net.MalformedURLException;

import static midas.MidasRequestClient.getMidasResponse;

public class MidasRequestClientTest {
    //TODO

    public static void main(String[] args) throws MalformedURLException {
        GetBookingRequest bookingRequest = new GetBookingRequest(0);
        JsonObject bookingResponse = getMidasResponse(bookingRequest);
        System.out.println(bookingResponse.toString());
    }
}
