package com.guitarshack.date;

import java.util.Calendar;
import java.util.Date;

public class CurrentDate implements Today {
    @Override
    public Date date() {
        return Calendar.getInstance().getTime();
    }
}
