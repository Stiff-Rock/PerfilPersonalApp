package com.stiffrock.perfilpersonal;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResumenActivity extends AppCompatActivity {
    private TextView name;
    private TextView age;
    private TextView email;
    private ImageView pfpImageView;
    private int imageResource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resumen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        View mainLayout = findViewById(R.id.main);
        mainLayout.setBackgroundColor(AppConfig.selectedColor);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        name = findViewById(R.id.nameTextView);
        age = findViewById(R.id.ageTextView);
        email = findViewById(R.id.emailTextView);
        pfpImageView = findViewById(R.id.imageView);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            name.setText(bundle.getString("name"));
            age.setText(bundle.getString("age"));
            email.setText(bundle.getString("email"));

            imageResource = bundle.getInt("pfpImage");
            pfpImageView.setImageResource(imageResource);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.resumen_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_reset) {
            name.setText("");
            age.setText("");
            email.setText("");
            pfpImageView.setImageResource(R.drawable.fnaf);
            Toast.makeText(this, "Contenido reseteado",
                    Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_change_design) {
            Intent intent = new Intent(ResumenActivity.this, DisenoActivity.class);

            Bundle bundle = new Bundle();
            bundle.putString("name", name.getText().toString());
            bundle.putString("age", age.getText().toString());
            bundle.putString("email", email.getText().toString());
            bundle.putInt("pfpImage", imageResource);

            intent.putExtras(bundle);
            startActivity(intent);
            Log.d(AppConfig.TAG, "DisenoActivity activada");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}