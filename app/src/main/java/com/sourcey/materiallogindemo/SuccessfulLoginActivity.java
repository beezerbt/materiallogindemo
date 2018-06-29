package com.sourcey.materiallogindemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SuccessfulLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oklogin);
        Intent intent = getIntent();
        Log.i("SuccessfulLoginActivity", intent.getStringExtra("LoginResult"));
        TextView textView = findViewById(R.id.okLoginTextView);
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.append(intent.getStringExtra("LoginResult"));
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        // Do something in response to button
    }
}