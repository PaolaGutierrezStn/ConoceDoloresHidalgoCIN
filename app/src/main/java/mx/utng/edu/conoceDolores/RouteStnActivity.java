package mx.utng.edu.conoceDolores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RouteStnActivity extends AppCompatActivity {

    public void nextActivity1(View view){
        startActivity(new Intent(this, Direcction1Activity.class));
    }

    public void nextActivity2(View view){
        startActivity(new Intent(this, Direcction2Activity.class));
    }

    public void nextActivity3(View view){
        startActivity(new Intent(this, Direcction3Activity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mx.utng.edu.conoceDolores.R.layout.activity_route_stn);
    }
}
