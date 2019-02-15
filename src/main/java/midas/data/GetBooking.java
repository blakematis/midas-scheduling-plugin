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

    private final String id;
    private final String start;
    private final String end;
    private final String venue;
    private final String client;
    private final String type;
    private final String attendees;
    private final String notes;
    private final ResourcesArray resources;
    private final String invoice;
    private final String status;

    public GetBooking(JsonObject jsonObject) {
        super(jsonObject);
        this.id = getJsonObject().getJsonString(ID).getString();
        this.start = getJsonObject().getJsonString(START).getString();
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
