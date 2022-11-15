package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MatchActivity extends AppCompatActivity {
    private TextView tvhome, tvaway, tvscorehome, tvscoreaway;
    private ImageView iv1, iv2;
    private Button tambah1_1, tambah2_1, tambah3_1, reset_home;
    private Button tambah1_2, tambah2_2, tambah3_2, reset_away;
    private Bitmap bitmap_home, bitmap_away;
    private String group1Uri, group2Uri, group1_home, group2_away;
    private Integer homepoint, awaypoint;
    private Button btn_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        btn_result = findViewById(R.id.btn_result);
        tvaway = findViewById(R.id.txt_away);
        tvhome = findViewById(R.id.txt_home);
        tvscorehome = findViewById(R.id.score_home);
        tvscoreaway = findViewById(R.id.score_away);
        iv1 = findViewById(R.id.home_logo);
        iv2 = findViewById(R.id.away_logo);
        tambah1_1 = findViewById(R.id.tambah1_1);
        tambah2_1 = findViewById(R.id.tambah2_1);
        tambah3_1 = findViewById(R.id.tambah3_1);
        reset_home = findViewById(R.id.reset_home);
        tambah1_2 = findViewById(R.id.tambah1_2);
        tambah2_2 = findViewById(R.id.tambah2_2);
        tambah3_2 = findViewById(R.id.tambah3_2);
        reset_away = findViewById(R.id.reset_away);
        homepoint = Integer.parseInt(tvscorehome.getText().toString());
        awaypoint = Integer.parseInt(tvscoreaway.getText().toString());

        Bundle bundle = getIntent().getExtras();
        group1Uri = bundle.getString("group1Uri");
        group2Uri = bundle.getString("group2Uri");
        group1_home = bundle.getString("group1");
        group2_away = bundle.getString("group2");

        iv1.setImageURI(Uri.parse(bundle.getString("BitmapHome")));
        iv2.setImageURI(Uri.parse(bundle.getString("BitmapAway")));
        tvhome.setText(group1_home);
        tvaway.setText(group2_away);

        tambah1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homepoint+=1;
                tvscorehome.setText(String.valueOf(homepoint));
            }
        });

        tambah2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homepoint+=2;
                tvscorehome.setText(String.valueOf(homepoint));
            }
        });

        tambah3_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homepoint+=3;
                tvscorehome.setText(String.valueOf(homepoint));
            }
        });

        reset_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homepoint=0;
                tvscorehome.setText(String.valueOf(homepoint));
            }
        });

        tambah1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                awaypoint+=1;
                tvscoreaway.setText(String.valueOf(awaypoint));
            }
        });

        tambah2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                awaypoint+=2;
                tvscoreaway.setText(String.valueOf(awaypoint));
            }
        });

        tambah3_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                awaypoint+=3;
                tvscoreaway.setText(String.valueOf(awaypoint));
            }
        });

        reset_away.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                awaypoint=0;
                tvscoreaway.setText(String.valueOf(awaypoint));
            }
        });

        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MatchActivity.this, ResultActivity.class);
                intent.putExtra("home team", tvhome.getText().toString());
                intent.putExtra("home team", tvaway.getText().toString());
                intent.putExtra("home team", tvscorehome.getText().toString());
                intent.putExtra("home team", tvscoreaway.getText().toString());
                startActivity(intent);
            }
        });


        //TODO
        //1.Menampilkan detail match sesuai data dari main activity
        //2.Tombol add score menambahkan satu angka dari angka 0, setiap kali di tekan
        //3.Tombol Cek Result menghitung pemenang dari kedua tim dan mengirim nama pemenang ke ResultActivity, jika seri di kirim text "Draw"
    }
}
