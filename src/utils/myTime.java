package utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class myTime {
    public static String getCurrentTime()
    {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String t= df.format(new Date());
        return t;
    }
    public static String getCurrentDay()
    {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String t= df.format(new Date());
        return t;
    }
    public static String dateToString(Date d){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String t= df.format(d);
        return t;
    }
    public static String datetimeToString(Timestamp t){
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(t.getTime());
        return timeStamp;
    }
}
