package io.github.vrajgohil.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.ArrayList;

public class PlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        ArrayList<Questions> question = new ArrayList<Questions>();
        TextView questionView = (TextView) findViewById(R.id.questionView);
        questionView.setText("Hello");
    }
}
