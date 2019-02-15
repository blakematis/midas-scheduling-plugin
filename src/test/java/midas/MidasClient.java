package midas;

import json.JSONReader;
import javax.json.JsonObject;
import java.net.MalformedURLException;

/**
 * MidasConnection sends an HTTP get request to the midas api
 * and is used to create a JsonObject.
 */
public class MidasClient {

    private static final String MIDAS_BASE_URL = "https://demo.mid.as/api.pl";
    private static final String MIDAS_API_KEY = "&key=797769685251f9i80MWOhwOC";

    public static JsonObject getMidasResponse(String request) throws MalformedURLException{
        String URL_REQUEST = MIDAS_BASE_URL + MIDAS_API_KEY;
        return JSONReader.getJsonReply(URL_REQUEST);
    }

}
