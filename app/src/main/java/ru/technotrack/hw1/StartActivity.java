package ru.technotrack.hw1;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class StartActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_layout);
        Log.d("HW1.logs", "onCreate start activity finished");
    }

    @Override
    public void onStart() {
        super.onStart();
        Thread thread = new Thread(new Timer(2000, this));
        thread.start();

    }

    public void onMessage() {
        Log.d("HW1.logs", "start activity notified from timer");
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);

        Log.d("HW1.logs", "Finishing start activity.");
        finish();
    }

}
