package com.example.myapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SubtopicListActivity extends AppCompatActivity {
    private LinearLayout subtopicListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subtopic_list);

        subtopicListView = findViewById(R.id.subtopicListView);

        // Get the list of subtopics and URLs passed from the previous activity
        ArrayList<String> subtopics = getIntent().getStringArrayListExtra(TopicListActivity.EXTRA_SUBTOPICS);
        ArrayList<String> urls = getIntent().getStringArrayListExtra(TopicListActivity.EXTRA_URLS);

        // Check if subtopics and URLs are valid
        if (subtopics != null && urls != null) {
            // Loop through each subtopic and create a TextView for it
            for (int i = 0; i < subtopics.size(); i++) {
                String subtopic = subtopics.get(i);
                String url = urls.get(i);

                // Create a new TextView for each subtopic
                TextView textView = new TextView(this);
                textView.setText(subtopic);
                textView.setPadding(16, 16, 16, 16);  // Add some padding for readability
                textView.setTextSize(18);  // Set font size
                textView.setOnClickListener(v -> {
                    // When a subtopic is clicked, open the corresponding URL in a browser
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(browserIntent);
                });

                // Add the TextView to the LinearLayout
                subtopicListView.addView(textView);
            }
        }
    }
}
