package mx.utng.edu.conoceDolores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuDoloreshActivity extends AppCompatActivity {

    //historia paola
    public void nextActivity1(View view){
        startActivity(new Intent(this, HistoryActivity.class));
    }

    //rutas paola
    public void nextActivity2(View view){
        startActivity(new Intent(this, RouteStnActivity.class));
    }

    //adivina paola
    public void nextActivity3(View view){
        startActivity(new Intent(this, GameActivity.class));
    }

    //artesanias paola
    public void nextActivity4(View view){
        startActivity(new Intent(this, CraftsVideoActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mx.utng.edu.conoceDolores.R.layout.activity_menu_doloresh);
    }
}
