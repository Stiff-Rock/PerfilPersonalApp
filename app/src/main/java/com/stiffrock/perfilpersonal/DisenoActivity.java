package com.stiffrock.perfilpersonal;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.SeekBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DisenoActivity extends AppCompatActivity {
    private ViewGroup mainLayout;
    private SeekBar redSeekBar;
    private SeekBar greenSeekBar;
    private SeekBar blueSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_diseno);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mainLayout = findViewById(R.id.main);
        mainLayout.setBackgroundColor(AppConfig.selectedColor);
        AppConfig.setDefaultButtonDimensions(mainLayout);

        redSeekBar = findViewById(R.id.seekBarRed);
        greenSeekBar = findViewById(R.id.seekBarGreen);
        blueSeekBar = findViewById(R.id.seekBarBlue);

        initializeSeekBarListeners();

        Button confirmBtn = findViewById(R.id.confirmBtn);
        confirmBtn.setOnClickListener(e -> backToResumenActivity());

        NumberPicker numberPicker = findViewById(R.id.numberPicker);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(100);
        numberPicker.setValue(AppConfig.buttonTextSize);
        numberPicker.setOnValueChangedListener((picker, oldVal, newVal) -> {
            AppConfig.buttonTextSize = newVal;
            AppConfig.setDefaultButtonDimensions(mainLayout);
        });
    }

    private void initializeSeekBarListeners() {
        redSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                changeBackgroundColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                changeBackgroundColor();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                changeBackgroundColor();
            }
        });

        greenSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                changeBackgroundColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                changeBackgroundColor();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                changeBackgroundColor();
            }
        });

        blueSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                changeBackgroundColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                changeBackgroundColor();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                changeBackgroundColor();
            }
        });
    }

    private void changeBackgroundColor() {
        int red = redSeekBar.getProgress();
        int green = greenSeekBar.getProgress();
        int blue = blueSeekBar.getProgress();

        AppConfig.selectedColor = Color.rgb(red, green, blue);
        mainLayout.setBackgroundColor(AppConfig.selectedColor);
    }

    private void backToResumenActivity() {
        Intent intent = new Intent(DisenoActivity.this, ResumenActivity.class);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            intent.putExtras(bundle);
        }

        startActivity(intent);
        Log.d(AppConfig.TAG, "ResumenActivity activada");
    }
}