package com.niajmahmud.LearnProgrammingBD;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.niajmahmud.LearnProgrammingBD.model.ProgrammingLanguage;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    private static String TAG = "ListActivity";
    ArrayList<ProgrammingLanguage> list = new ArrayList<>();
    public static final int REQUEST_CODE = 1;
    MyListAdapter myListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        setTitle("Language List");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        list.add(getProgrammingLanguange("python", "https://www.tutorialspoint.com/python/index.htm"));
        list.add(getProgrammingLanguange("Java", "https://www.tutorialspoint.com/java/index.htm"));
        list.add(getProgrammingLanguange("C Programming", "https://www.tutorialspoint.com/cprogramming/index.htm"));
        list.add(getProgrammingLanguange("C++", "https://www.tutorialspoint.com/cplusplus/index.htm"));

        ProgrammingLanguage html = new ProgrammingLanguage();
        html.setLanguageTitle("HTML");
        html.setTutorialURL("https://www.tutorialspoint.com/html/index.htm");
        list.add(html);

        ProgrammingLanguage flutter = new ProgrammingLanguage();
        flutter.setLanguageTitle("Flutter");
        flutter.setTutorialURL("https://www.tutorialspoint.com/flutter/index.htm");
        list.add(flutter);


        /*list.add("C");
        list.add("C++");
        list.add("HTML");
        list.add("CSS");
        list.add("Javascript");
        list.add("php");
        list.add("Kotlin");
        list.add("Flutter");
        list.add("C#");
        list.add("Android");
        list.add("Pycharm");
        list.add("Operating System");
        list.add("Computer Graphics ");*/

        ArrayList<ProgrammingLanguage> searchResult = new ArrayList<>();

        Button buttonAddNew = findViewById(R.id.buttonAddNew);
        buttonAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this, AddNewActivity.class);
                startActivityForResult(intent , 100);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this ));

        myListAdapter = new MyListAdapter(this, list);
        recyclerView.setAdapter(myListAdapter);

       /* EditText editTextSearch = findViewById(R.id.editTextSearch);
        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //Toast.makeText(ListActivity.this, "" + s + start + " " + before + " " + count, Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onTextChanged: " + s.toString());
                searchResult.clear();
                for (ProgrammingLanguage pl : list) {
                    if (pl.getLanguageTitle().toUpperCase().contains(s.toString().toUpperCase())) {
                        searchResult.add(pl);
                    }
                }

                MyListAdapter myListAdapter = new MyListAdapter(ListActivity.this, searchResult);
                recyclerView.setAdapter(myListAdapter);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });*/

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == 100  && resultCode  == 200) {

                String title = data.getStringExtra("name");
                String url = data.getStringExtra("url");

                Log.d(TAG, "onActivityResult: " + title);
                Log.d(TAG, "onActivityResult: " + url);

                list.add(getProgrammingLanguange(title, url));
                myListAdapter.notifyDataSetChanged();

            }
        } catch (Exception ex) {
            Log.e(TAG, "onActivityResult: " + ex.getMessage() );
        }
    }


    private ProgrammingLanguage getProgrammingLanguange(String title, String url) {
        ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
        programmingLanguage.setLanguageTitle(title);
        programmingLanguage.setTutorialURL(url);
        return programmingLanguage;
    }
}