package com.stiffrock.perfilpersonal;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class AppConfig {
    public static int selectedColor = Color.rgb(43, 43, 43);
    public static int buttonTextSize = 14;
    public static final String TAG = "MyApp";

    public static void setDefaultButtonDimensions(ViewGroup parentLayout) {
        for (int i = 0; i < parentLayout.getChildCount(); i++) {
            View child = parentLayout.getChildAt(i);

            if (child instanceof ViewGroup) {
                setDefaultButtonDimensions((ViewGroup) child);
            } else if (child instanceof Button) {
                Button button = (Button) child;
                button.setTextSize(buttonTextSize);
            }
        }
    }
}
