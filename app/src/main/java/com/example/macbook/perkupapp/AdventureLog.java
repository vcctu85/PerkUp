package com.example.macbook.perkupapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.macbook.perkupapp.Model.Log;
import java.util.ArrayList;
import java.util.List;
import android.widget.ListView;


public class AdventureLog extends AppCompatActivity {

    private List<Log> logList = new ArrayList<Log>();
    private ListView listView;
    private CustomListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adventure_log);

        listView = (ListView) findViewById(R.id.list);
        adapter = new CustomListAdapter(this, logList);
        listView.setAdapter(adapter);

        //Example Gift; if generating would input generating code here
        Log exampleLog = new Log();
        exampleLog.setTitle("Blue Gift Box");
        exampleLog.setImage(R.drawable.blue_gift);
        exampleLog.setDate("January 1st, 2019");
        exampleLog.setRating("Cafe Strada");
        logList.add(exampleLog);

    }


}
