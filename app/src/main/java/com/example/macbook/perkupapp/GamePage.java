package com.example.macbook.perkupapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
//import com.example.macbook.perkupapp.UnityPlayerActivity;
public class GamePage extends Activity {
    private GameAdapter gameAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_gifts);

        ListView newsListView = findViewById(R.id.list_view);

        Game one = new Game(100, "Cafe Strada");
        Game two = new Game(50, "Shattuck Cinemas");
        Game three = new Game(150, "Toss");
        List<Game> games = new ArrayList<>();
        games.add(one);
        games.add(two);
        games.add(three);
        gameAdapter = new GameAdapter(this, games);
//        Button button = findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent myIntent = new Intent(view.getContext(), com.example.macbook.perkupapp.UnityPlayerActivity.class);
//                startActivity(myIntent);
//            }
//        });
        newsListView.setAdapter(gameAdapter);
    }
}
