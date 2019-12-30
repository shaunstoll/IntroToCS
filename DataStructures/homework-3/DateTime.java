/**
 * Represent a timestamp consisting of a date (day/month/year) and time 
 * in hours and minutes (24h format.
 */

import java.util.Objects;

public class DateTime implements Comparable<DateTime> {
    
    public int year;
    public int month;
    public int day; 
    public int hours;
    public int minutes;    
    public int seconds;
    public boolean pm; 

    
    public DateTime(int year, int day, int month, int h, int m) {        
        this.year = year; 
        this.month = month; 
        this.day = day;     
        this.hours = h; 
        this.minutes = m;                
    }
    
    public DateTime(String datetime) {
        String[] fields = datetime.split(" ");
        String[] dateFields = fields[0].split("/");
        month = Integer.parseInt(dateFields[0]);
        day = Integer.parseInt(dateFields[1]);
        year = Integer.parseInt(dateFields[2]);
        
        String[] timeFields = fields[1].split(":"); 
        hours = Integer.parseInt(timeFields[0]);
        minutes = Integer.parseInt(timeFields[1]);;
    }
    
    public String toString() {
        return Integer.toString(month)+"/"+Integer.toString(day)+"/"+Integer.toString(year)+"  "+
            String.format("%02d" , hours)+":"+String.format("%02d", minutes);
    }
    
    public int compareTo(DateTime other) {
        int comp = year - other.year;
        if (comp == 0)
            comp = month - other.month;
        if (comp == 0)
            comp = day - other.day;
        if (comp == 0)
            comp = hours - other.hours;
        if (comp == 0)
            comp = minutes - other.minutes;
        if (comp == 0)
            comp = seconds - other.seconds;
        
        return comp;
    }
    @Override
    public int hashCode() {
        return Objects.hash(year, month, day, hours, minutes, seconds);
    }
    
    @Override
    public boolean equals(Object that) {
        if (this == that) {return true;}
        if (that == null) {return false;}
        if (getClass() != that.getClass()) {return false;}
        
        DateTime other = (DateTime)that;
        
        return (year == other.year && month == other.month 
                && day == other.day && hours == other.hours
                && minutes == other.minutes && seconds == other.seconds);
    }
    
}