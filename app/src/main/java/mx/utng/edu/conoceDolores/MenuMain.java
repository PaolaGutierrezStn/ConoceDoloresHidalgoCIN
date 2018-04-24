package mx.utng.edu.conoceDolores;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;

public class MenuMain extends AppCompatActivity {

    String arrayName[]={"Historia","Museo","Restaurantes","Hoteles","Taxis"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(mx.utng.edu.conoceDolores.R.layout.activity_menu_main);

        CircleMenu circleMenu = (CircleMenu) findViewById(mx.utng.edu.conoceDolores.R.id.circle_menu);

        circleMenu.setMainMenu(Color.parseColor("#FFFFFF"), mx.utng.edu.conoceDolores.R.drawable.ic_menu_main0, mx.utng.edu.conoceDolores.R.drawable.ic_menu_main0)
                .addSubMenu(Color.parseColor("#F68B42"), mx.utng.edu.conoceDolores.R.drawable.ic_menu_main1)
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {
                    @Override
                    public void onMenuSelected(int index) {
                        if(index==0) {
                            Toast.makeText(MenuMain.this, "José Alfredo Jiménez ", Toast.LENGTH_SHORT).show();
                            Intent newFor = new Intent(MenuMain.this,MenuJimenezActivity.class);
                            startActivity(newFor);


                        }else if(index==1){
                            Toast.makeText(MenuMain.this, "Dolores Hidalgo C.I.N. ", Toast.LENGTH_SHORT).show();
                            Intent newFor = new Intent(MenuMain.this, MenuDoloreshActivity.class);
                            startActivity(newFor);

                        }else if(index==2){
                            Toast.makeText(MenuMain.this, "Recomendaciones", Toast.LENGTH_SHORT).show();
                            Intent newFor = new Intent(MenuMain.this, MenuRecommendActivity.class);
                            startActivity(newFor);

                        }else if(index==3){
                            Toast.makeText(MenuMain.this, "Compartir experiencias", Toast.LENGTH_SHORT).show();
                            Intent newFor = new Intent(MenuMain.this, MenuSharedhActivity.class);
                            startActivity(newFor);

                        }else if(index==4){
                            Toast.makeText(MenuMain.this, "Créditos", Toast.LENGTH_SHORT).show();
                            Intent newFor = new Intent(MenuMain.this, CreditsDhActivity.class);
                            startActivity(newFor);
                        }
                    }

                }).addSubMenu(Color.parseColor("#EC87C0"), mx.utng.edu.conoceDolores.R.drawable.ic_menu_main2)
                .addSubMenu(Color.parseColor("#AC92EC"), mx.utng.edu.conoceDolores.R.drawable.ic_menu_main3)
                .addSubMenu(Color.parseColor("#4FC1E9"), mx.utng.edu.conoceDolores.R.drawable.ic_menu_main4)
                .addSubMenu(Color.parseColor("#A0D468"), mx.utng.edu.conoceDolores.R.drawable.ic_menu_main5);
        }
    }




