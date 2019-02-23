package midas.data;

import json.AbstractJsonArray;

import javax.json.JsonArray;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Blake Matis
 * @version 1.0
 * @since 1.0
 */
public class ResourcesArray extends AbstractJsonArray {

    private List<Resource> resources;

    public ResourcesArray(JsonArray jsonArray) {
        super(jsonArray);
        this.resources = new ArrayList<>();
        for(int index = 0; index < getJsonArray().size(); index ++) {
            Resource resource = new Resource(getJsonArray().getJsonObject(index));
            this.resources.add(resource);
        }
    }

    public List<Resource> getResources() {
        return resources;
    }
}
