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
        Button button = findViewById(R.id.button);

        final Intent intent = new Intent(this, SubActivity.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, editText.getText(), Toast.LENGTH_LONG).show();
                intent.putExtra("key", editText.getText());
                startActivity(intent);
            }
        });

//        textView.setText(getString(R.string.error));
//        textView.setTextColor(Color.RED);
    }
}
