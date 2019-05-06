package json;


import javax.json.JsonArray;

/**
 * Abstract class for JSONArray object.
 */
public class AbstractJsonArray {

    private final JsonArray jsonArray;

    public AbstractJsonArray(JsonArray jsonArray){
        this.jsonArray = jsonArray;
    }

    public JsonArray getJsonArray(){
        return jsonArray;
    }
}