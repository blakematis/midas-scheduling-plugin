package json;

import javax.json.JsonObject;

/**
 * Abstract class for JSON obj.
 */
public abstract class AbstractJsonObj {

    private final JsonObject jsonObject;

    public AbstractJsonObj(JsonObject jsonObject){
        this.jsonObject = jsonObject;
    }

    public JsonObject getJsonObject() {
        return jsonObject;
    }

}