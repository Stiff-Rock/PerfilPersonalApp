package com.stiffrock.perfilpersonal;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private ViewGroup mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mainLayout = findViewById(R.id.main);
        mainLayout.setBackgroundColor(AppConfig.selectedColor);
        AppConfig.setDefaultButtonDimensions(mainLayout);

        Button welcomeButton = findViewById(R.id.startBtn);
        welcomeButton.setOnClickListener(e -> loadDatosActivity());
    }

    @Override
    protected void onResume() {
        super.onResume();
        AppConfig.setDefaultButtonDimensions(mainLayout);
    }

    private void loadDatosActivity() {
        Intent intent = new Intent(MainActivity.this, DatosActivity.class);
        startActivity(intent);
        Log.d(AppConfig.TAG, "DatosActivity activada");
    }
}