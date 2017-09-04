package com.demo.calenderdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.andexert.calendarlistview.library.DatePickerController;
import com.andexert.calendarlistview.library.DayPickerView;
import com.andexert.calendarlistview.library.SimpleMonthAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements DatePickerController {

    private DayPickerView mPickerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPickerView = (DayPickerView) findViewById(R.id.day_pick);
        mPickerView.setController(this);
    }

    @Override
    public int getMaxYear() {
        return 2020;
    }

    @Override
    public void onDayOfMonthSelected(int year, int month, int day) {

    }

    @Override
    public void onHourSelected(String ourString) {

    }

    @Override
    public void onDateRangeSelected(SimpleMonthAdapter.SelectedDays<SimpleMonthAdapter.CalendarDay> selectedDays) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = selectedDays.getFirst().getDate();
        Date date1 = selectedDays.getLast().getDate();
        String format1 = dateFormat.format(date);
        String format2 = dateFormat.format(date1);
        Toast.makeText(this, format1 + "--->" + format2, Toast.LENGTH_SHORT).show();
    }
}
