package com.niajmahmud.LearnProgrammingBD;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.CaseMap;
import android.os.Bundle;
import android.webkit.WebView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        String title = getIntent().getExtras().getString("TITLE");
        setTitle(title);
        WebView webView = findViewById(R.id.webView);
        String url = getIntent().getExtras().getString("URL");
        webView.loadUrl(url);


    }
}