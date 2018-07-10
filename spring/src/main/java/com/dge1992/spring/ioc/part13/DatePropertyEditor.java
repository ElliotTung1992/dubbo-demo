package com.dge1992.spring.ioc.part13;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePropertyEditor extends PropertyEditorSupport{

    private String dateStr;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy=MM=dd");
        try {
            Date date = format.parse(dateStr);
            setValue(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }
}
