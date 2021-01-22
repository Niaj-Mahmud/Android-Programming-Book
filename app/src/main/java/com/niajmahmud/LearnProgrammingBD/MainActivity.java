package com.niajmahmud.LearnProgrammingBD;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toast.makeText(this, "ON Create", Toast.LENGTH_LONG).show();
        LinearLayout linearLayout = findViewById(R.id.linearLayoutEducation);
        LinearLayout linearLayout1 = findViewById(R.id.linearLayoutDream);
        LinearLayout linearEdu2 =findViewById(R.id.linearLayoutEducation1);
        LinearLayout linearDream2 = findViewById(R.id.linearLayoutDream1);

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });

        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ListActivity.class);
                startActivity(intent);
            }
        });

        linearEdu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ListActivity.class);
                startActivity(intent);
            }
        });

        linearDream2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ListActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        //Toast.makeText(this, "ON Start", Toast.LENGTH_LONG).show();
        super.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "ON Resume", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "ON Pause", Toast.LENGTH_LONG).show();
    }
}