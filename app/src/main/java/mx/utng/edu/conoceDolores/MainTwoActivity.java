package mx.utng.edu.conoceDolores;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hsalf.smilerating.SmileRating;

public class MainTwoActivity extends AppCompatActivity {
private EditText edtText;

    private Button btnFace, btnWhats, btnTwitter , btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mx.utng.edu.conoceDolores.R.layout.activity_two_main);
        edtText= (EditText) findViewById(mx.utng.edu.conoceDolores.R.id.editText2);
       btnShare = (Button) findViewById(mx.utng.edu.conoceDolores.R.id.btn_share);

        SmileRating smileRating = (SmileRating) findViewById(mx.utng.edu.conoceDolores.R.id.smile_rating);
        smileRating.setOnSmileySelectionListener(new SmileRating.OnSmileySelectionListener() {
            @Override
            public void onSmileySelected(int smiley, boolean reselected) {
                switch (smiley) {
                    case SmileRating.BAD:
                        Toast.makeText(MainTwoActivity.this, "SOLO POR COMPROMISO", Toast.LENGTH_SHORT).show();
                        break;
                    case SmileRating.GOOD:
                        Toast.makeText(MainTwoActivity.this, "REGRESARÉ MUY PRONTO", Toast.LENGTH_SHORT).show();
                        break;
                    case SmileRating.GREAT:
                        Toast.makeText(MainTwoActivity.this, "VOLVERÉ", Toast.LENGTH_SHORT).show();
                        break;
                    case SmileRating.OKAY:
                        Toast.makeText(MainTwoActivity.this, "TAL VEZ REGRESÉ ", Toast.LENGTH_SHORT).show();
                        break;
                    case SmileRating.TERRIBLE:
                        Toast.makeText(MainTwoActivity.this, "NUNCA REGRESARE!", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        smileRating.setOnSmileySelectionListener(new SmileRating.OnSmileySelectionListener() {
            @Override
            public void onSmileySelected(int level, boolean reselected) {
              //  Toast.makeText(MainTwoActivity.this, "Seleccionaste rating"+level , Toast.LENGTH_SHORT).show();
            }
        });


        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, ""+ edtText.getText());

                startActivity(Intent.createChooser(intent, "share with"));

            }
        });
    }
}
