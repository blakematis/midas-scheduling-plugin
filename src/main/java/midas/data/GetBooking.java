package midas.data;

import json.AbstractJsonObj;
import midas.util.TimeFormat;

import javax.json.JsonObject;
import java.util.GregorianCalendar;

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
        setEnd();
        setVenue();
        setClient();
        setType();
        setAttendees();
        setNotes();
        setResources();
        setInvoice();
        setStatus();
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

    private void setEnd(){
        try{
            this.end = getJsonObject().getJsonString(END).getString();
        }catch (Exception e){
            e.printStackTrace();
            this.end = "error";
        }
    }

    private void setVenue(){
        try{
            this.venue = getJsonObject().getJsonString(VENUE).getString();
        }catch (Exception e){
            e.printStackTrace();
            this.venue = "error";
        }
    }

    private void setClient(){
        try{
            this.client = getJsonObject().getJsonString(VENUE).getString();
        }catch (Exception e){
            e.printStackTrace();
            this.client = "error";
        }
    }

    private void setType(){
        try{
            this.type = getJsonObject().getJsonString(TYPE).getString();
        } catch (Exception e){
            e.printStackTrace();
            this.type = "error";
        }
    }

    private void setAttendees(){
        try{
            this.attendees = getJsonObject().getJsonString(ATTENDEES).getString();
        }catch (Exception e){
            e.printStackTrace();
            this.attendees = "error";
        }
    }

    private void setNotes(){
        try{
            this.notes = getJsonObject().getJsonString(NOTES).getString();
        }catch (NullPointerException e){
            this.notes = "error";
        }
    }

    private void setResources(){
        try{
            this.resources = new ResourcesArray(getJsonObject().getJsonArray(RESOURCES));
        }catch (Exception e){
            e.printStackTrace();
            this.resources = null;
        }
    }

    private void setInvoice(){
        try{
            this.invoice = getJsonObject().getJsonString(INVOICE).getString();
        }catch (Exception e){
            e.printStackTrace();
            this.invoice = "error";
        }
    }

    private void setStatus(){
        try{
            this.status = getJsonObject().getJsonString(STATUS).getString();
        }catch (Exception e){
            e.printStackTrace();
            this.status = "error";
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

    public GregorianCalendar getStartCalendar(){
        return getCalender(start);
    }

    public GregorianCalendar getEndCalendar(){
        return getCalender(end);
    }

    private GregorianCalendar getCalender(String timeStamp){
        return TimeFormat.calendar(timeStamp);
    }
}
