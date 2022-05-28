package com.example.widget_controls;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.CalendarView;

import com.google.android.material.snackbar.Snackbar;

public class calender_view extends AppCompatActivity {
    CalendarView calendarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender_view);
        calendarView=findViewById(R.id.calendarView);
        calendarView.setFocusedMonthDateColor(Color.RED);
        calendarView.setUnfocusedMonthDateColor(Color.BLUE);
        calendarView.setSelectedWeekBackgroundColor(Color.RED);
        calendarView.setWeekSeparatorLineColor(Color.GREEN);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                Snackbar.make(calendarView,i2+'-'+i1+"-"+i,Snackbar.LENGTH_LONG).show();
            }
        });
    }
}