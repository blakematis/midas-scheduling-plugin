package midas.data;

import json.AbstractJsonObj;

import javax.json.JsonObject;

/**
 * @Author Blake Matis
 * @version 1.0
 * @since 1.0
 *
 *
 */
public class GetBooking extends AbstractJsonObj {

    private static final String ID = "id";
    private static final String START = "start";
    private static final String END = "end";
    private static final String VENUE = "venue";
    private static final String CLIENT = "client";
    private static final String TYPE = "type";
    private static final String ATTENDEES = "attendees";
    private static final String NOTES = "nots";
    private static final String RESOURCES = "resources";
    private static final String INVOICE = "invoice";
    private static final String HISTORY = "history";
    private static final String STATUS = "status";

    private String id;
    private String start;
    private String end;
    private String venue;
    private String client;
    private String type;
    private String attendees;
    private String notes;
    private ResourcesArray resources;
    private String invoice;
    private String status;

    public GetBooking(JsonObject jsonObject) {
        super(jsonObject);
        setId();
        setStart();
        this.end = getJsonObject().getJsonString(END).getString();
        this.venue = getJsonObject().getJsonString(VENUE).getString();
        this.client = getJsonObject().getJsonString(CLIENT).getString();
        this.type = getJsonObject().getJsonString(TYPE).getString();
        this.attendees = getJsonObject().getJsonString(ATTENDEES).getString();
        this.notes = getJsonObject().getJsonString(NOTES).getString();
        this.resources = new ResourcesArray(getJsonObject().getJsonArray(RESOURCES));
        this.invoice = getJsonObject().getJsonString(INVOICE).getString();
        this.status = getJsonObject().getJsonString(STATUS).getString();
    }

    private void setId(){
        try{
            this.id = getJsonObject().getJsonString(ID).getString();
        }catch (Exception e){
            e.printStackTrace();
            this.id = "error";
        }
    }

    private void setStart(){
        try{
            this.start = getJsonObject().getJsonString(START).getString();
        }catch (Exception e){
            e.printStackTrace();
            this.start = "error";
        }
    }

    public String getId() {
        return id;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public String getVenue() {
        return venue;
    }

    public String getClient() {
        return client;
    }

    public String getType() {
        return type;
    }

    public String getAttendees() {
        return attendees;
    }

    public String getNotes() {
        return notes;
    }

    public ResourcesArray getResources() {
        return resources;
    }

    public String getInvoice() {
        return invoice;
    }

    public String getStatus(){
        return status;
    }
}
