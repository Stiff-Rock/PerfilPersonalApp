package com.stiffrock.perfilpersonal;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DatosActivity extends AppCompatActivity {
    private EditText nameET;
    private EditText ageET;
    private EditText emailET;
    private int pfpImageResource = R.drawable.fnaf;
    private ViewGroup mainLayout;

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

        mainLayout = findViewById(R.id.main);
        mainLayout.setBackgroundColor(AppConfig.selectedColor);
        AppConfig.setDefaultButtonDimensions(mainLayout);

        nameET = findViewById(R.id.nameText);
        ageET = findViewById(R.id.ageText);
        emailET = findViewById(R.id.emailText);

        Button choosePfp = findViewById(R.id.choosePfp);
        choosePfp.setOnClickListener(e -> openFotoActivity());

        Button confirmDataBtn = findViewById(R.id.confirmDataBtn);
        confirmDataBtn.setOnClickListener(e -> openResumenActivity());

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            nameET.setText(bundle.getString("name"));
            ageET.setText(bundle.getString("age"));
            emailET.setText(bundle.getString("email"));
            pfpImageResource = bundle.getInt("pfpImage");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        AppConfig.setDefaultButtonDimensions(mainLayout);
    }

    private void openFotoActivity() {
        String name = nameET.getText().toString();
        String age = ageET.getText().toString();
        String email = emailET.getText().toString();

        Intent intent = new Intent(DatosActivity.this, FotoActivity.class);

        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        bundle.putString("age", age);
        bundle.putString("email", email);
        bundle.putInt("pfpImage", pfpImageResource);

        intent.putExtras(bundle);
        startActivity(intent);

        Log.d(AppConfig.TAG, "FotoActivity activada");
    }

    private void openResumenActivity() {
        String name = nameET.getText().toString();
        String age = ageET.getText().toString();
        String email = emailET.getText().toString();

        if (name.isBlank() || age.isBlank() || email.isBlank()) {
            Toast.makeText(this, "Porfavor rellena todos los datos",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(DatosActivity.this, ResumenActivity.class);

        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        bundle.putString("age", age);
        bundle.putString("email", email);
        bundle.putInt("pfpImage", pfpImageResource);

        intent.putExtras(bundle);
        startActivity(intent);

        Log.d(AppConfig.TAG, "ResumenActivity activada");
    }
}