package com.example.macbook.perkupapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.macbook.perkupapp.Adapter.LogAdapter;
import com.example.macbook.perkupapp.Model.Log;
import java.util.ArrayList;
import java.util.List;
import android.widget.ListView;


public class AdventureLog extends AppCompatActivity {

    private List<Log> logList = new ArrayList<Log>();
    private ListView listView;
    private LogAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adventure_log);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Adventures");

        listView = (ListView) findViewById(R.id.list);
        adapter = new LogAdapter(this, logList, this);
        listView.setAdapter(adapter);

        //Example Gift; if generating would input generating code here
        Log exampleLog = new Log();
        exampleLog.setTitle("Adventure #1");
        exampleLog.setImage(R.drawable.cute_cat);
        exampleLog.setDate("December 4th, 2018");
        exampleLog.setLocation("V & A Cafe");


        logList.add(exampleLog);

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
//        return super.onSupportNavigateUp();
    }

}
