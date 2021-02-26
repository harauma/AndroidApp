package com.example.mywebapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.text);
        final Context context = this;
        final EditText editText = findViewById(R.id.edit);

        Button myWebButton = findViewById(R.id.myWebButton);
        Button searchButton = findViewById(R.id.searchButton);

        final Intent intent = new Intent(this, SubActivity.class);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, editText.getText() + "を開きます", Toast.LENGTH_LONG).show();
                intent.putExtra("url", editText.getText().toString());
                startActivity(intent);
            }
        });

        myWebButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Googleを開きます", Toast.LENGTH_LONG).show();
                intent.putExtra("url", "https://google.com");
                startActivity(intent);
            }
        });

//        textView.setText(getString(R.string.error));
//        textView.setTextColor(Color.RED);
    }
}
