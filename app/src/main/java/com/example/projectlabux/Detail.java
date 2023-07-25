package com.example.projectlabux;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class Detail extends AppCompatActivity {

    private Button button;
    EditText email, username;
    private int currentRemainder = 0;
    private ProgressBar remainder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        button = findViewById(R.id.buyBtn);
        email = findViewById(R.id.email);
        username = findViewById(R.id.username);
        remainder = findViewById(R.id.remainder);
        remainder.setMax(10000);
        remainder.setProgress(7777);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_check = email.getText().toString();
                String username_check = username.getText().toString();
                if(email_check.isEmpty()){
                    openDialog("Please enter your email");
                } else if (username_check.isEmpty()) {
                    openDialog("Please enter your username");
                } else if (!email_check.contains("@")) {
                    openDialog("Email must contain '@'");
                } else if (!email_check.contains(".com")) {
                    openDialog("Email must contain '.com'");
                }
            }
        });
    }
    public void openDialog(String message){
        AlertDialog dialog = new AlertDialog.Builder(Detail.this)
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                }).create();
        dialog.show();
    }
}