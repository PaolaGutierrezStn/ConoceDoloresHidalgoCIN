package mx.utng.edu.conoceDolores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class music_list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mx.utng.edu.conoceDolores.R.layout.activity_music_list);
    }


    public void nextActivity4(View view){
        startActivity(new Intent(this, Music.class));
    }

    public void nextActivity5(View view){
        startActivity(new Intent(this, MusicTwo.class));
    }

    public void nextActivity6(View view){
        startActivity(new Intent(this, MusicThree.class));
    }

    public void nextActivity7(View view){
        startActivity(new Intent(this, MusicFour.class));
    }
    public void nextActivity8(View view){
        startActivity(new Intent(this, MusicFive.class));
    }

    public void nextActivity9(View view){
        startActivity(new Intent(this, MusicSix.class));
    }
    public void nextActivity10(View view){
        startActivity(new Intent(this, MusicSeven.class));
    }

    public void nextActivity11(View view){
        startActivity(new Intent(this, MusicEight.class));
    }
    public void nextActivity12(View view){
        startActivity(new Intent(this, MusicNine.class));
    }
    public void nextActivity13(View view){
        startActivity(new Intent(this, MusicTen.class));
    }
}
