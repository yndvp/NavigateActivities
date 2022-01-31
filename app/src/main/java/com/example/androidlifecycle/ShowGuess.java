package com.example.androidlifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ShowGuess extends AppCompatActivity {
    private TextView showGuessTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_guess);

        showGuessTextView = findViewById(R.id.received_textview);

        // Make a bundle of passed data
        Bundle extra = getIntent().getExtras();

        if(extra != null) {
            showGuessTextView.setText(extra.getString("guess"));
            // If we want to get int
//            showGuessTextView.setText(extra.getInt("age"));

        }

//        if(getIntent().getStringExtra("guess") != null) {
//            showGuessTextView.setText(getIntent().getStringExtra("guess"));
//        }

        showGuessTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                intent.putExtra("message_back", "From Second Activity");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}