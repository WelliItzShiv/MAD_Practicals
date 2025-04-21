package com.example.mad_practicals;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PlayAudioFile extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private Button playButton;
    private TextView statusTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_audio_file);

        playButton = findViewById(R.id.playButton);
        statusTextView = findViewById(R.id.statusTextView);

        // Initialize MediaPlayer with the audio file located in res/raw folder
        mediaPlayer = MediaPlayer.create(this, R.raw.my_audio);  // "my_audio.mp3" should be in res/raw

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.start(); // Start playing the audio
                    statusTextView.setText("Status: Playing Audio");
                    playButton.setEnabled(false);  // Disable the button after audio starts
                }
            }
        });

        // Release the media player when the activity is destroyed
        mediaPlayer.setOnCompletionListener(mp -> {
            statusTextView.setText("Status: Audio Finished");
            playButton.setEnabled(true);  // Re-enable the button when audio finishes
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();  // Release the media player to free resources
        }
    }
}
