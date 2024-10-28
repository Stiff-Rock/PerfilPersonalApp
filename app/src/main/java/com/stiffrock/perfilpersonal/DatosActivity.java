package com.stiffrock.perfilpersonal;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DatosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_datos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button choosePfp = findViewById(R.id.choosePfp);
        choosePfp.setOnClickListener(e -> {
            openFotoActivity();
        });

        Button confirmDataBtn = findViewById(R.id.confirmDataBtn);
        confirmDataBtn.setOnClickListener(e -> {
            openResumenActivity();
        });
    }


    private void openFotoActivity() {
        Intent intent = new Intent(DatosActivity.this, FotoActivity.class);
        startActivity(intent);
    }

    private void openResumenActivity() {
        String name = ((EditText) findViewById(R.id.nameText)).getText().toString();
        String age = ((EditText) findViewById(R.id.ageText)).getText().toString();
        String email = ((EditText) findViewById(R.id.emailText)).getText().toString();

        System.out.println(name);
        System.out.println(age);
        System.out.println(email);
    }
}