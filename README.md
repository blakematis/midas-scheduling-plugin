# midas-scheduling-plugin
Java plugin for Midas booking and scheduling system.

# Supported API Features


## get_booking

Variables Returned | Description
-- | --
id | Internal Booking ID
start | Start date/time of booking
end | End date/time of booking
venue_id | Internal ID of the venue
venue | Name of the venue
client | Client the booking is for
type | Booking Type
attendees | Estimated number of people attending booking
notes | Booking Notes
resources | Resources assigned to booking
resource | The name of the resource
qty | The quantity of the resource
invoice | Invoice in which the booking appears
history | Booking history
action | The action performed. This will be one of the following:"Booking Request Received", "Added", "Modified", "Deleted", "Restored", or "Invoice Created"
date | The date/time the action occurred
user | The user who performed the action
custom fields | Any custom booking fields setup in your MIDAS will also be returned
status | Denotes whether the booking is a "request", a "confirmed" booking, or whether it has been "deleted"

### Example use

```  
String MIDAS_BASE_URL = "https://demo.mid.as/api.pl";

String MIDAS_API_KEY = "?key=797769685251f9i80MWOhwOC"; 
  
MidasRequestClient midasRequestClient = new MidasRequestClient(MIDAS_BASE_URL, MIDAS_API_KEY);

GetBookingRequest bookingRequest = new GetBookingRequest(1);

GetBookingResponse bookingResponse = (GetBookingResponse)midasRequestClient.getMidasObjResponse(bookingRequest);
```
