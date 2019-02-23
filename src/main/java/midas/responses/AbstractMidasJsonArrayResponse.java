package midas.responses;

import json.AbstractJsonArray;

import javax.json.JsonArray;

public class AbstractMidasJsonArrayResponse extends AbstractJsonArray{
    public AbstractMidasJsonArrayResponse(JsonArray jsonArray) {
        super(jsonArray);
    }
}
