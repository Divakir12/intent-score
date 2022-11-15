package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private TextView poin, team;
    private String homescore, awayscore, hometeam, awayteam;
    private Integer homepoint, awaypoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        poin = findViewById(R.id.poin);
        team = findViewById(R.id.team);

        Bundle bundle = getIntent().getExtras();
        homescore = bundle.getString("homepoin");
        awayscore = bundle.getString("awaypoin");
        hometeam = bundle.getString("hometeam");
        awayteam = bundle.getString("awayteam");
        homepoint = Integer.parseInt(homescore);
        awaypoint = Integer.parseInt(awayscore);

        if (homepoint>awaypoint){
            team.setText(hometeam);
            poin.setText(String.valueOf(homepoint));
        }else if(homepoint<awaypoint){
            team.setText(awayteam);
            poin.setText(String.valueOf(awaypoint));
        }
    }
}
