package midas.data;

import json.AbstractJsonObj;

import javax.json.JsonObject;

public class Resource extends AbstractJsonObj {

    private static final String RESOURCE = "resource";
    private static final String QUANTITY = "qty";

    private final String resource;
    private final String quantity;

    public Resource(JsonObject jsonObject) {
        super(jsonObject);
        this.resource = getJsonObject().getJsonString(RESOURCE).getString();
        this.quantity = getJsonObject().getJsonString(QUANTITY).getString();
    }

    public String getResource() {
        return resource;
    }

    public String getQauntity(){
        return quantity;
    }
}
