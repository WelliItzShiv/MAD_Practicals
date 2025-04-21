package com.example.mad_practicals;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ImageTranslations extends AppCompatActivity {

    private ImageView imageView;
    private Button rotateClockwiseBtn, rotateAnticlockwiseBtn, zoomInBtn, zoomOutBtn, fadeInBtn, fadeOutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_translations);

        imageView = findViewById(R.id.imageView);
        rotateClockwiseBtn = findViewById(R.id.rotateClockwiseBtn);
        rotateAnticlockwiseBtn = findViewById(R.id.rotateAnticlockwiseBtn);
        zoomInBtn = findViewById(R.id.zoomInBtn);
        zoomOutBtn = findViewById(R.id.zoomOutBtn);
        fadeInBtn = findViewById(R.id.fadeInBtn);
        fadeOutBtn = findViewById(R.id.fadeOutBtn);

        // Rotate Clockwise
        rotateClockwiseBtn.setOnClickListener(v -> rotateImage(0f, 360f));

        // Rotate Anticlockwise
        rotateAnticlockwiseBtn.setOnClickListener(v -> rotateImage(360f, 0f));

        // Zoom In
        zoomInBtn.setOnClickListener(v -> zoomImage(1f, 1.5f));

        // Zoom Out
        zoomOutBtn.setOnClickListener(v -> zoomImage(1.5f, 1f));

        // Fade In
        fadeInBtn.setOnClickListener(v -> fadeImage(0f, 1f));

        // Fade Out
        fadeOutBtn.setOnClickListener(v -> fadeImage(1f, 0f));
    }

    // Function to rotate image
    private void rotateImage(float fromDegrees, float toDegrees) {
        RotateAnimation rotateAnimation = new RotateAnimation(fromDegrees, toDegrees,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(500);  // Set duration of rotation
        rotateAnimation.setFillAfter(true);  // Retain the final state
        imageView.startAnimation(rotateAnimation);
    }

    // Function to zoom image
    private void zoomImage(float fromScale, float toScale) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(fromScale, toScale, fromScale, toScale,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(500);  // Set duration of zoom
        scaleAnimation.setFillAfter(true);  // Retain the final state
        imageView.startAnimation(scaleAnimation);
    }

    // Function to fade image
    private void fadeImage(float fromAlpha, float toAlpha) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(fromAlpha, toAlpha);
        alphaAnimation.setDuration(500);  // Set duration of fade
        alphaAnimation.setFillAfter(true);  // Retain the final state
        imageView.startAnimation(alphaAnimation);
    }
}

