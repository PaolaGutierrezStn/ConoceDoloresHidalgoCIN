package mx.utng.edu.conoceDolores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuSharedhActivity extends AppCompatActivity {

    //experiencia lucy
    public void nextActivity1(View view){
        startActivity(new Intent(this, MainTwoActivity.class));
    }

    //chat lucy
    public void nextActivity2(View view){
        startActivity(new Intent(this, MainMessageActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mx.utng.edu.conoceDolores.R.layout.activity_menu_sharedh);
    }
}
