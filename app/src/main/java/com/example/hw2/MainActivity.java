package com.example.hw2;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private CustomAdapter adapter;
    private List<ActivityManager.RunningTaskInfo> taskList;
    private ActivityManager activityManager;
    private int currentActivity = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        taskList = activityManager.getRunningTasks(Integer.MAX_VALUE);

        listView = findViewById(R.id.listView);
        adapter = new CustomAdapter(this, taskList);
        listView.setAdapter(adapter);
        if (savedInstanceState != null) {
            currentActivity = savedInstanceState.getInt("currentActivity");
            switchActivity(currentActivity);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() != 0) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            currentActivity = 2;
            switchActivity(currentActivity);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("currentActivity", currentActivity);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        currentActivity = savedInstanceState.getInt("currentActivity");
        switchActivity(currentActivity);
    }

    public void switchActivity(int activity) {
        Intent intent;
        if (activity == 1) {
            intent = new Intent(this, MainActivity.class);
        } else {
            intent = new Intent(this, SecondActivity.class);
        }
        startActivity(intent);
    }

}