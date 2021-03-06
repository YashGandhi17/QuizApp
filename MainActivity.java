package io.github.vrajgohil.quizapp;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity{
    EditText editTextName;
    Intent playIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkConnection();

        editTextName=(EditText)findViewById(R.id.editTextName);

        Button score=(Button)findViewById(R.id.button2);
        score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scoreIntent=new Intent(MainActivity.this,ScoreView.class);
                startActivity(scoreIntent);
            }
        });
        Button play=(Button)findViewById(R.id.button);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playIntent=new Intent(MainActivity.this,PlayActivity.class);
                addName();
            }
        });

    }

    protected boolean isOnline(){
        ConnectivityManager connectivityManager= (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if(networkInfo!=null && networkInfo.isConnectedOrConnecting()){
            return true;
        }
        else {
            return false;
        }
    }

    private void checkConnection() {
        if(isOnline()){
            Toast.makeText(this,"Connected to Internet",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this,"Please connect to Internet",Toast.LENGTH_LONG).show();
        }
    }

    private void addName(){
        String name=editTextName.getText().toString().trim();
        if(!TextUtils.isEmpty(name) && validName(name)){
            playIntent.putExtra("name",name);
            Toast.makeText(this,"Name Added Successfully!",Toast.LENGTH_SHORT).show();
            startActivity(playIntent);
        }
        else{
            Toast.makeText(this,"Enter name to play!",Toast.LENGTH_LONG).show();
        }
    }

    private boolean validName(String name){
        for(int i=0;i<name.length();i++){
            if(!(name.charAt(i)>='A' && name.charAt(i)<='Z') || !(name.charAt(i)>='a' && name.charAt(i)>='z'))
                return false;
        }
        return true;

    }


}
