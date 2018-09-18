package com.example.exercise1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MessageActivity extends AppCompatActivity {

    private TextView message;
    private Button emailButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        message = findViewById(R.id.message);
        final Intent messageIntent = getIntent();
        message.setText(messageIntent.getStringExtra("message"));
        emailButton = findViewById(R.id.email_button);
        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEmailActivity(messageIntent.getStringExtra("message"));
            }
        });
    }

    public void openEmailActivity(String emailMessage){
        Intent openEmailIntent = new Intent(Intent.ACTION_SENDTO);
        openEmailIntent.setType("message");
        openEmailIntent.setData(Uri.parse("mailto:andr.academy.msk@gmail.com"));
        openEmailIntent.putExtra(Intent.EXTRA_SUBJECT, "Hello, Android Academy MSK!");
        openEmailIntent.putExtra(Intent.EXTRA_TEXT,emailMessage);
        if(openEmailIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(openEmailIntent);
        }
        else {
            Toast.makeText(this, "No Email app found", Toast.LENGTH_LONG).show();
        }
    }

}
