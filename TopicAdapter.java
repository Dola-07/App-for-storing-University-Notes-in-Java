package com.example.myapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.ViewHolder> {

    private ArrayList<String> topicList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public TopicAdapter(TopicListActivity topicListActivity, ArrayList<String> topicList) {
        this.topicList = topicList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String topic = topicList.get(position);
        holder.bind(topic);

        // Set the click listener on the ViewHolder's item view
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(position); // Pass the position to the listener
            }
        });
    }

    @Override
    public int getItemCount() {
        return topicList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(android.R.id.text1);
        }

        public void bind(String topic) {
            textView.setText(topic);
        }
    }
}
