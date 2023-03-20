package com.example.hw2;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private List<ActivityManager.RunningTaskInfo> taskList;

    public CustomAdapter(Context context, List<ActivityManager.RunningTaskInfo> taskList) {
        this.context = context;
        this.taskList = taskList;
    }

    @Override
    public int getCount() {
        return taskList.size();
    }

    @Override
    public Object getItem(int position) {
        return taskList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.task_item, parent, false);
        }

        TextView taskName = convertView.findViewById(R.id.taskName);
        TextView packageName = convertView.findViewById(R.id.packageName);
        TextView topActivity = convertView.findViewById(R.id.topActivity);
        ActivityManager.RunningTaskInfo taskInfo = taskList.get(position);
        taskName.setText("Task #" + taskInfo.id);
        packageName.setText(taskInfo.baseActivity.getPackageName());
        topActivity.setText(taskInfo.topActivity.getClassName());

        return convertView;
    }
}