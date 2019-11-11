package com.pavlekuzevski.moviediscovery.utils;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;
import java.util.Locale;

public class CalendarUtils {

    public static void selectDate(Context context, EditText editText) {
        final Calendar calendar = Calendar.getInstance();
        DatePickerDialog picker = new DatePickerDialog(context,
                (DatePicker view, int year, int monthOfYear, int dayOfMonth) ->
                        editText.setText(String.format(Locale.US,"%4d-%02d-%02d",year, monthOfYear+1, dayOfMonth)),
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));

        picker.show();
    }
}
