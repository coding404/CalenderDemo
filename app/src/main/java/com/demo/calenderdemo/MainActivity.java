package com.demo.calenderdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.andexert.calendarlistview.library.DatePickerController;
import com.andexert.calendarlistview.library.DayPickerView;
import com.andexert.calendarlistview.library.SimpleMonthAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements DatePickerController {

    @Bind(R.id.tv_about_me)
    TextView mTvAboutMe;
    @Bind(R.id.day_pick)
    DayPickerView mDayPick;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mDayPick.setController(this);
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

    @OnClick(R.id.tv_about_me)
    public void onClick() {
        Intent intent = new Intent(this, AboutMeActivity.class);
        startActivity(intent);
    }
}
