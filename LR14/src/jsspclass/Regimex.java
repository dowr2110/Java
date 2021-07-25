package jsspclass;

import java.util.*;
import java.text.SimpleDateFormat;

public class Regimex {
    protected String R = null;
    Calendar C;
    protected Date d = new Date();
    protected SimpleDateFormat simpledateformat = new SimpleDateFormat("dd.MM.yyyy");
    public Regimex(Calendar c) {
        this.C = c;
    }
    public Regimex() {
        this.C = Calendar.getInstance();
    }
    public Integer GetHOUR() {
        return ((Integer)C.get(Calendar.HOUR_OF_DAY)+1);
    }
    public Integer GetDayOfWeek() {
        Integer day = ((Integer)(C.get(Calendar.DAY_OF_WEEK)-1));
        if(day==0)
            return 7;
        else
            return ((Integer)(C.get(Calendar.DAY_OF_WEEK)-1));
    }
    public String AddDays(Integer i) {
        C.add(Calendar.DAY_OF_YEAR, i);
        return simpledateformat.format(C.getTime());
    }
    public String GetCurrentDate() {
        return simpledateformat.format(C.getTime());
    }
}
