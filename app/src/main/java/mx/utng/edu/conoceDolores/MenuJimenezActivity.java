package mx.utng.edu.conoceDolores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuJimenezActivity extends AppCompatActivity {

    //galeria jose alfredo martha
    public void nextActivity1(View view){
        startActivity(new Intent(this, GalleryActivityTwo.class));
    }



    //quiz lucy
    public void nextActivity3(View view){
        startActivity(new Intent(this, QuizActivity.class));
    }

    //juego martha
    public void nextActivity4(View view){
        startActivity(new Intent(this, MainActivity.class));
    }

    //historia martha
    public void nextActivity5(View view){
        startActivity(new Intent(this, History.class));
    }

    //informacion martha
    public void nextActivity6(View view){
        startActivity(new Intent(this, Location.class));
    }

    //cancionero martha
    public void nextActivity7(View view){
        startActivity(new Intent(this, music_list.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mx.utng.edu.conoceDolores.R.layout.activity_menu_jimenez);
    }
}