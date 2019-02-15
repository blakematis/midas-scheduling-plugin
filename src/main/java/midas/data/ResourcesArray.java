package midas.data;

import json.AbstractJsonArray;

import javax.json.JsonArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ResourcesArray extends AbstractJsonArray {

    private final List<Resource> resources;

    public ResourcesArray(JsonArray jsonArray) {
        super(jsonArray);
        if(getJsonArray().size() > 0){
            resources = new ArrayList<>();
            Iterator itr = getJsonArray().iterator();
            int index = 0;
            while(itr.hasNext()){
                Resource resource = new Resource(getJsonArray().getJsonObject(index));
                this.resources.add(resource);
                index++;
            }
        }else{
            resources = null;
        }
    }

    public List<Resource> getResources() {
        return resources;
    }
}
