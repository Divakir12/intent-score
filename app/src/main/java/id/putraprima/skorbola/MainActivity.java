package id.putraprima.skorbola;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getCanonicalName();
    private static final int GALLERY_REQUEST_CODE = 1;
    private static final int PHOTO_REQUEST_CODE = 2;
    private EditText home_team, away_team;
    private Bitmap bitmap_home, bitmap_away;
    private Uri group1Uri;
    private Uri group2Uri;
    private ImageView group1;
    private ImageView group2;
    private Button btn_team;

    public void InsertPhoto(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, GALLERY_REQUEST_CODE);
    }

    public void InsertPhoto_away(View view) {
        Intent intent= new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, PHOTO_REQUEST_CODE);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        group1 = findViewById(R.id.home_logo);
        group2 = findViewById(R.id.away_logo);
        home_team = findViewById(R.id.home_team);
        away_team = findViewById(R.id.away_team);
        btn_team = findViewById(R.id.btn_team);

        btn_team.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String group1 = home_team.getText().toString();
                String group2 = away_team.getText().toString();
                Intent intent = new Intent(MainActivity.this, MatchActivity.class);
                intent.putExtra("group1", group1);
                intent.putExtra("group2", group2);
                intent.putExtra("BitmapHome", group1Uri.toString());
                intent.putExtra("BitmapAway", group2Uri.toString());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED){
            Log.d(TAG, "onActivityResult: Pilih gambar batal");
            return;
        }else if(requestCode == GALLERY_REQUEST_CODE){
            if (data != null){
                try {
                    Uri imageUri = data.getData();
                    group1Uri = data.getData();
                    bitmap_home = MediaStore.Images.Media.getBitmap(this.getContentResolver(), group1Uri);
                    group1.setImageBitmap(bitmap_home);
                } catch (IOException e){
                    Toast.makeText(this, "Can't load image", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, e.getMessage());
                }
            }
        }else if(requestCode == PHOTO_REQUEST_CODE){
            if(data!=null){
                try{
                    Uri imageUri = data.getData();
                    group2Uri = data.getData();
                    bitmap_home = MediaStore.Images.Media.getBitmap(this.getContentResolver(), group2Uri);
                    group2.setImageBitmap(bitmap_home);
                } catch (IOException e){
                    Toast.makeText(this, "Can't load image", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, e.getMessage());
                }
            }
        }
    }
}
