package com.example.macbook.perkupapp;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ChatPage extends AppCompatActivity {




    private ListView msgListView;
    private EditText inputText;
    private Button send;
    private MsgAdapter adapter;

    private List<Msg> msgList = new ArrayList<Msg>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_page);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        initMsgs();
        adapter = new MsgAdapter(ChatPage.this, R.layout.message_item, msgList);
        inputText = (EditText)findViewById(R.id.input_text);
        send = (Button)findViewById(R.id.send);
        msgListView = (ListView)findViewById(R.id.msg_list_view);
        msgListView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = inputText.getText().toString();
                if(!"".equals(content)) {
                    Msg msg = new Msg(content, Msg.TYPE_SEND);
                    msgList.add(msg);
                    adapter.notifyDataSetChanged();
                    msgListView.setSelection(msgList.size());
                    inputText.setText("");
                }
            }
        });
    }

    private void initMsgs() {
        Msg msg1 = new Msg("Hello, how are you?", Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2 = new Msg("I feel bad.?", Msg.TYPE_SEND);
        msgList.add(msg2);
        Msg msg3 = new Msg("Let's get start.", Msg.TYPE_RECEIVED);
        msgList.add(msg3);
    }


}
