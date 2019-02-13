package json;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

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
        }
        return null;
    }

    public static JsonObject getJsonReply(String API_URL) throws MalformedURLException {
        return JSONReader.getJsonReader(API_URL).read().asJsonObject();
    }
}