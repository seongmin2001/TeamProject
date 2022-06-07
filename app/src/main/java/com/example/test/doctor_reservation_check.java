package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.icu.text.UFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Locale;

public class doctor_reservation_check extends AppCompatActivity

{
    Button button9;

    int Hour,Minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_reservation_check);
        button9 = findViewById(R.id.button9);




    }
    public void popTimePicker(View view)
    {
        TimePickerDialog.OnTimeSetListener onTimeSetListener= new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectHour, int selectMinute)
            {
                Hour = selectHour;
                Minute = selectMinute;
                button9.setText(String.format(Locale.getDefault(), "%02d 시 %02d 분 으로 선택",Hour,Minute));

            }
        };
        int style = AlertDialog.THEME_HOLO_DARK;
        TimePickerDialog timePickerDialog= new TimePickerDialog(this,style, onTimeSetListener, Hour , Minute , true);
        timePickerDialog.setTitle("select time");
        timePickerDialog.show();
    }
}
