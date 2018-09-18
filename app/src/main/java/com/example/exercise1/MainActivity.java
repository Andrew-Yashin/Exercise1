package com.example.exercise1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button previewButton;
    private EditText editingMessage;
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editingMessage = findViewById(R.id.editing_message);
        previewButton = findViewById(R.id.preview_button);
        previewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message = editingMessage.getText().toString();
                openMessageActivity(message);
            }
        });


    }
    public void openMessageActivity(String message){
        Intent messageActivityIntent = new Intent(this,MessageActivity.class);
        messageActivityIntent.putExtra("message",message);
        startActivity(messageActivityIntent);
    }
}
