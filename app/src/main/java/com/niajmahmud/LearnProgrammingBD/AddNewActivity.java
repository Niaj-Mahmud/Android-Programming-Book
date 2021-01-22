package com.niajmahmud.LearnProgrammingBD;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddNewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);
        EditText editTextName = findViewById(R.id.editTextTextName);
        EditText editTextURL = findViewById(R.id.editTextURL);
        Button buttonSave = findViewById(R.id.buttonSave);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                intent.putExtra("name", editTextName.getText().toString());
                intent.putExtra("url", editTextURL.getText().toString());
                setResult(200, intent);
                finish();
            }
        });

    }
}