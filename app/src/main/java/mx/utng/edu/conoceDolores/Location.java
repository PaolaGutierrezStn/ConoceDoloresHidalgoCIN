package mx.utng.edu.conoceDolores;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Location extends AppCompatActivity {
    private EditText edtText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mx.utng.edu.conoceDolores.R.layout.activity_location);

        edtText=(EditText)findViewById(mx.utng.edu.conoceDolores.R.id.edt_place);

    }
    public void nextActivity2(View view){
        startActivity(new Intent(this, MainActivityTwo.class));
    }



    public void nextActivity33(View view){
        startActivity(new Intent(this, MapsRouteActivity.class));
    }

    public void c(View view){
        Intent i;
        i= new Intent(Intent.ACTION_CALL,Uri.parse("tel:4181544070"));
        if(ActivityCompat.checkSelfPermission(Location.this, Manifest.permission.CALL_PHONE)!=PackageManager.PERMISSION_GRANTED)
            return;
        startActivity(i);
    }



    public void next(View view){
Intent intent;
            intent= new Intent(this, Main2Activity.class);
            String value="http:www.iberotec.edu.pe";
        getIntent().putExtra("value",value);
        startActivity(intent);
    }

}
