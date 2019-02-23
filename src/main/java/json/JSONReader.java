package json;

import midas.responses.GetBookingsResponse;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

/**
 * @Author Blake Matis
 * @version 1.0
 * @since 1.0
 *
 * Utility for creating an HTTP connection specifically get requests.
 *
 * <p>
 *     Currently only supports get requests no post requests yet. Can take
 *     a String URL and convert it to URL or directly a pre-built URL.
 * </p>
 */
public class JSONReader {
    private static final Logger logger = Logger.getLogger("JSONReader");

    public JSONReader(){

    }

    public static JsonReader getJsonReader(String API_URL) throws MalformedURLException {
        return getJsonReader(new URL(API_URL));
    }

    public static JsonReader getJsonReader(URL API_URL){
        try{
            HttpURLConnection conn = (HttpURLConnection) API_URL.openConnection();
            conn.setRequestMethod("GET");

            return Json.createReader(conn.getInputStream());
        } catch (IOException e) {
            logger.warning(e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static JsonObject getJsonObjReply(String API_URL) throws MalformedURLException {
        return JSONReader.getJsonReader(API_URL).read().asJsonObject();
    }

    public static JsonArray getJsonArrayReply(String API_URL) throws MalformedURLException{
        return JSONReader.getJsonReader(API_URL).read().asJsonArray();
    }

    public static void main(String[] args) throws Exception{
        GetBookingsResponse bookingsResponse = new GetBookingsResponse(getJsonArrayReply("https://demo.mid.as/api.pl?key=797769685251f9i80MWOhwOC&action=get_bookings&start=201902010000&end=201902220000"));
    }
}