package com.example.myapp;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class YearSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_year_selection);

        findViewById(R.id.firstYearButton).setOnClickListener(v -> openTopicList("1st Semester"));
        findViewById(R.id.secondYearButton).setOnClickListener(v -> openTopicList("2nd Semester"));
        findViewById(R.id.thirdYearButton).setOnClickListener(v -> openTopicList("3rd Semester"));
        findViewById(R.id.fourthYearButton).setOnClickListener(v -> openTopicList("4th Semester"));
        findViewById(R.id.fifthYearButton).setOnClickListener(v -> openTopicList("5th Semester"));
        findViewById(R.id.sixthYearButton).setOnClickListener(v -> openTopicList("6th Semester"));
        findViewById(R.id.seventhYearButton).setOnClickListener(v -> openTopicList("7th Semester"));
        findViewById(R.id.eighthYearButton).setOnClickListener(v -> openTopicList("8th Semester"));
    }

    private void openTopicList(String year) {
        Intent intent = new Intent(YearSelectionActivity.this, TopicListActivity.class);
        intent.putExtra("year", year);
        startActivity(intent);
    }
}
