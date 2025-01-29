package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;

public class TopicListActivity extends AppCompatActivity {
    private RecyclerView topicListView;
    private TopicAdapter topicAdapter;
    private HashMap<String, ArrayList<String>> topics = new HashMap<>();
    private HashMap<String, ArrayList<String>> topicLinks = new HashMap<>();
    public static final String EXTRA_YEAR = "year";
    public static final String EXTRA_SUBTOPICS = "subtopics";
    public static final String EXTRA_URLS = "urls";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_list);

        topicListView = findViewById(R.id.topicListView);
        topicListView.setLayoutManager(new LinearLayoutManager(this));

        String year = getIntent().getStringExtra(EXTRA_YEAR);
        if (year != null) {
            setupTopics(year);
        }

        ArrayList<String> topicList = new ArrayList<>(topics.keySet());
        topicAdapter = new TopicAdapter(this, topicList);
        topicListView.setAdapter(topicAdapter);

        topicAdapter.setOnItemClickListener(position -> {
            String topic = topicList.get(position);
            ArrayList<String> subtopics = topics.get(topic);
            ArrayList<String> urls = topicLinks.get(topic);

            Intent intent = new Intent(this, SubtopicListActivity.class);
            intent.putStringArrayListExtra(EXTRA_SUBTOPICS, subtopics);
            intent.putStringArrayListExtra(EXTRA_URLS, urls);
            startActivity(intent);
        });
    }

    private void setupTopics(String year) {
        switch (year) {
            case "1st Semester":
                addTopic("Topic 1", new String[]{"Introduction to Topic 1", "Detailed Analysis of Topic 1", "Advanced Concepts in Topic 1", "Case Studies in Topic 1", "Practical Applications of Topic 1"},
                        new String[]{"http://www.google.com", "https://link-to-lecture-1.com", "https://link-to-lecture-2.com", "https://link-to-lecture-3.com", "https://link-to-lecture-4.com"});
                break;
            case "2nd Semester":
                addTopic("Topic 2", new String[]{"Overview of Topic 2"}, new String[]{"http://www.google.com"});
                break;
            case "3rd Semester":
                addTopic("Topic 3", new String[]{"Introduction to Topic 3", "Concepts of Topic 3"}, new String[]{"http://www.example.com/topic3", "http://www.example.com/topic3/advanced"});
                break;
            case "4th Semester":
                addTopic("Topic 4", new String[]{"Introduction to Topic 4", "Methods in Topic 4"}, new String[]{"http://www.example.com/topic4", "http://www.example.com/topic4/methods"});
                break;
            case "5th Semester":
                addTopic("Data Mining", new String[]{"Clustering", "Data Mining note-1", "Data Mining note-2"},
                        new String[]{"https://drive.google.com/file/d/1HcVVl_50STITmpLSGqaBJOo_XPCPobcr/view?usp=drive_link",
                                "https://drive.google.com/file/d/1wMDvSt1ZPNA1lyoT16IcUrZ6MjediYFa/view?usp=sharing",
                                "https://drive.google.com/file/d/1VQCdO0S0CGJmqwTYyfwEyjvV1ttbpE4X/view?usp=drive_link"});
                addTopic("MAL", new String[]{"Viva question","Microprocessor lab report"}, new String[]{"https://drive.google.com/file/d/1g1TW0-b1FNnWvJLad_vrs_mwdUg9hOra/view?usp=drive_link","https://drive.google.com/file/d/1yK8-ToO1e9FbGOn7sWJhuG4BHWto0xa7/view?usp=sharing"});
                addTopic("Theory of Computation", new String[]{"Presentation", "Regular Expression","Presentation Table Filling Method","PDA"},
                        new String[]{"https://docs.google.com/presentation/d/1mc8_X-lQ3uvRL3ZDApAUze50j2J6eICR/edit?usp=drive_link",
                                "https://docs.google.com/presentation/d/1mc8_X-lQ3uvRL3ZDApAUze50j2J6eICR/edit?usp=drive_link"
                ,"https://docs.google.com/presentation/d/1Tj5i8kOX_ijXKjVrO1e1Rc4i0pI6aF68/edit?usp=sharing&ouid=108992089561609957214&rtpof=true&sd=true"
                ,"https://drive.google.com/file/d/1IoqQjPHDLmZUBO8kV5Fb10me_o04G71V/view?usp=sharing"});
                addTopic("Operating System", new String[]{"Operating System Lab Work","Operating System note-1","Operating System Note-2","Operating System note-3"}, new String[]{"https://drive.google.com/file/d/1KDXeT2mwDf3N9rFt6kC0Ek4BLircQi5N/view?usp=drive_link","https://drive.google.com/file/d/1KjwOEMZ797GoeasdHjjgDMcx6SQC0auX/view?usp=drive_link","https://drive.google.com/file/d/1KjwOEMZ797GoeasdHjjgDMcx6SQC0auX/view?usp=drive_link"
                ,"https://drive.google.com/file/d/1a9rTJf3X_sgpjjyStglzKc9bfapAv4B-/view?usp=drive_link"});
                addTopic("ADC", new String[]{"ADC-pdf"}, new String[]{"https://drive.google.com/file/d/1KDXeT2mwDf3N9rFt6kC0Ek4BLircQi5N/view?usp=drive_link"});
                break;
            case "6th Semester":
                addTopic("Topic 6", new String[]{"Overview of Topic 6", "Applications of Topic 6"},
                        new String[]{"http://www.example.com/topic6/overview", "http://www.example.com/topic6/applications"});
                break;
            case "7th Semester":
                addTopic("Topic 7", new String[]{"Introduction to Topic 7", "Techniques in Topic 7"},
                        new String[]{"http://www.example.com/topic7/introduction", "http://www.example.com/topic7/techniques"});
                break;
            case "8th Semester":
                addTopic("Topic 8", new String[]{"Advanced Concepts in Topic 8", "Future Trends in Topic 8"},
                        new String[]{"http://www.example.com/topic8/advanced", "http://www.example.com/topic8/future-trends"});
                break;
            default:
                // Handle unknown semester if needed
                break;
        }
    }

    private void addTopic(String topicName, String[] subtopics, String[] links) {
        ArrayList<String> subtopicList = new ArrayList<>();
        ArrayList<String> linkList = new ArrayList<>();
        for (String subtopic : subtopics) {
            subtopicList.add(subtopic);
        }
        for (String link : links) {
            linkList.add(link);
        }
        topics.put(topicName, subtopicList);
        topicLinks.put(topicName, linkList);
    }
}
