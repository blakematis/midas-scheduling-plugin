package midas.util;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TimeFormat {

    public static int month(String timeStamp){
        String[] date = timeStamp.split("/");
        int month = Integer.valueOf(date[0]);
        return month;
    }

    public static int month(GregorianCalendar calendar){
        return calendar.get(Calendar.MONTH);
    }

    public static GregorianCalendar calendar(String timeStamp){

        int month, day, year, hour, minute;

        String[] dateTime = timeStamp.split(" @ ");
        String[] date = dateTime[0].split("/");
        String[] time = dateTime[1].split(":");

        day = Integer.valueOf(date[0]);
        month = Integer.valueOf(date[1]);
        year = Integer.valueOf(date[2]);

        hour = Integer.valueOf(time[0]);
        minute = Integer.valueOf(time[1]);

        return new GregorianCalendar(year, month, day, hour, minute);
    }

    public static String toTimeStamp(String timeStamp){
        String month, day, year, hour, minute;

        String[] dateTime = timeStamp.split(" @ ");
        String[] date = dateTime[0].split("/");
        String[] time = dateTime[1].split(":");

        day = date[1];

        if(day.length() == 1){
            day = "0" + day;
        }
        month = date[0];
        if(month.length() == 1){
            month = "0" + month;
        }
        year = date[2];


        hour = time[0];
        if(timeStamp.contains("PM") && !hour.equals("12") ) {
            hour = String.valueOf(Integer.parseInt(hour) + 12);
        }
        if(hour.length() == 1){
            hour = 0 + hour;
        }

        minute = time[1];
        minute = minute.substring(0, 2);
        //System.out.println("year: " + year +" month: " + month + " day: " + day + " hour: " + hour +" minute: "+ minute);
        return year + month + day + hour + minute;
    }
}
