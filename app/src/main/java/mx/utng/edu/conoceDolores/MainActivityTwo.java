package mx.utng.edu.conoceDolores;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivityTwo extends AppCompatActivity {


    private Button btnShare;

    private EditText editText2;
    String msj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mx.utng.edu.conoceDolores.R.layout.activity_main_two);
        editText2 = (EditText) findViewById(mx.utng.edu.conoceDolores.R.id.editText2);


        btnShare = (Button) findViewById(mx.utng.edu.conoceDolores.R.id.bt_share);


        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "" + editText2.getText());

                startActivity(Intent.createChooser(intent, "share with"));

            }
        });
    }
}

