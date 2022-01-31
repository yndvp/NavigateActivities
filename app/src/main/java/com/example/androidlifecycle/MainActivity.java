package com.example.androidlifecycle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button showGuess;
    private EditText enterGuess;
    private final int REQUEST_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Toast.makeText(MainActivity.this, "OnCreate() Called",
//                Toast.LENGTH_SHORT)
//                .show();
//        Log.d("OnCreate()", "go");

        showGuess = findViewById(R.id.button_guess);
        enterGuess = findViewById(R.id.guess_field);

        showGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String guess = enterGuess.getText().toString().trim();

                if(!guess.isEmpty()) {
                    // Navigate to another activity
                    Intent intent = new Intent(MainActivity.this, ShowGuess.class);
                    // Pass the data
                    intent.putExtra("guess", guess);
                    intent.putExtra("name", "Yunna");
                    intent.putExtra("age", 23);
                    startActivityForResult(intent, REQUEST_CODE);
//                startActivity(new Intent(MainActivity.this, ShowGuess.class));
                } else {
                    Toast.makeText(MainActivity.this, "Enter guess",
                            Toast.LENGTH_SHORT)
                            .show();
                }

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE){
            if(resultCode == RESULT_OK) {
                String message = data.getStringExtra("message_back");
                Toast.makeText(MainActivity.this, message,
                        Toast.LENGTH_SHORT)
                        .show();
            }
        }
    }

    //
//    @Override
//    protected void onStart() {
//        super.onStart();
//        Toast.makeText(MainActivity.this, "onStart() Called",
//                Toast.LENGTH_SHORT)
//                .show();
//        Log.d("onStart()", "go");
//
//    }
//
//    @Override
//    protected void onPostResume() {
//        super.onPostResume();
//        Toast.makeText(MainActivity.this, "onPostResume() Called",
//                Toast.LENGTH_SHORT)
//                .show();
//        Log.d("onPostResume()", "go");
//
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Toast.makeText(MainActivity.this, "onPause() Called",
//                Toast.LENGTH_SHORT)
//                .show();
//        Log.d("onPause()", "go");
//
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Toast.makeText(MainActivity.this, "onStop() Called",
//                Toast.LENGTH_SHORT)
//                .show();
//        Log.d("onStop()", "go");
//
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Toast.makeText(MainActivity.this, "onDestroy() Called",
//                Toast.LENGTH_SHORT)
//                .show();
//        Log.d("onDestroy()", "go");
//
//    }
//
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        Toast.makeText(MainActivity.this, "onDestroy() Called",
//                Toast.LENGTH_SHORT)
//                .show();
//        Log.d("onRestart()", "go");
//    }
}