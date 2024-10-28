package com.stiffrock.perfilpersonal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FotoActivity extends AppCompatActivity {
    private ImageView pfpImageView;
    private final ImageView[] pictures = new ImageView[8];
    private final int[] pictureResources = {R.drawable.fnaf, R.drawable.godot, R.drawable.cookie, R.drawable.play, R.drawable.terr, R.drawable.wii, R.drawable.pollo, R.drawable.persona};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_foto);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        pfpImageView = findViewById(R.id.pfpImageView);


        pictures[0] = findViewById(R.id.imageView1);
        pictures[1] = findViewById(R.id.imageView2);
        pictures[2] = findViewById(R.id.imageView3);
        pictures[3] = findViewById(R.id.imageView4);
        pictures[4] = findViewById(R.id.imageView5);
        pictures[5] = findViewById(R.id.imageView6);
        pictures[6] = findViewById(R.id.imageView7);
        pictures[7] = findViewById(R.id.imageView8);

        for (int i = 0; i < pictures.length; i++) {
            int index = i;
            pictures[i].setOnClickListener(e -> changePfp(index));
        }

        Button confirmDataBtn = findViewById(R.id.confirmDataBtn);
        confirmDataBtn.setOnClickListener(e -> backToDatosActivity());
    }

    private void changePfp(int index) {
        pfpImageView.setImageResource(pictureResources[index]);
    }

    private void backToDatosActivity() {
        Intent intent = new Intent(FotoActivity.this, DatosActivity.class);
        startActivity(intent);
    }
}