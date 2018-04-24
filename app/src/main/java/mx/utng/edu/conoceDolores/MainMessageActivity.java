
package mx.utng.edu.conoceDolores;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainMessageActivity extends AppCompatActivity {

    private CircleImageView photoPerfil;
    private TextView name;
    private RecyclerView rvMessage;
    private EditText txtMessage;
    private Button btnShare;
    private ImageButton btnSharePhoto;

    private AdapterMessageActivity adapter;

    private Button btnFace, btnWhats, btnTwitter , btnCompartir;


    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private FirebaseStorage storage ;
    private StorageReference storageReference;

    private  static  final int PHOTO_SEND = 1;
    private static final int PHOTO_PERFIL=2;
    private  String photoPerfi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mx.utng.edu.conoceDolores.R.layout.activity_message_main);
        photoPerfil = (CircleImageView) findViewById(mx.utng.edu.conoceDolores.R.id.photo_perfil);
        name = (TextView) findViewById(mx.utng.edu.conoceDolores.R.id.name);
        rvMessage = (RecyclerView) findViewById(mx.utng.edu.conoceDolores.R.id.rv_message);
        txtMessage = (EditText) findViewById(mx.utng.edu.conoceDolores.R.id.txt_message);
        btnShare = (Button) findViewById(mx.utng.edu.conoceDolores.R.id.btn_share);
        photoPerfi ="";


        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("chat");//sala de chat
        databaseReference = database.getReference("image");//sala de chat
        storage = FirebaseStorage.getInstance();

        adapter = new AdapterMessageActivity(this);
        LinearLayoutManager l = new LinearLayoutManager(this);
        rvMessage.setLayoutManager(l);
        rvMessage.setAdapter(adapter);

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.push().setValue(new MessageShareActivity(txtMessage.getText().toString(),name.getText().toString(),"","1", ServerValue.TIMESTAMP));
                txtMessage.setText("");
            }
        });


        photoPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_GET_CONTENT);
                i.setType("image/jpeg");
                i.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
                startActivityForResult(Intent.createChooser(i,"Selecciona una foto"),PHOTO_PERFIL);
            }
        });

        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onItemRangeInserted(int positionStart, int itemCount){
                super.onItemRangeInserted(positionStart, itemCount);
                setScrollbar();
            }
        });

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                MessageReceiveActivity m = dataSnapshot.getValue(MessageReceiveActivity.class);
                adapter.addMessage(m);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
    private  void setScrollbar(){
        rvMessage.scrollToPosition(adapter.getItemCount()-1);
    }



    protected  void  onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PHOTO_SEND && resultCode== RESULT_OK){
            Uri u = data.getData();
            storageReference = storage.getReference("images_chat");//images
            final StorageReference fotoRerefence = storageReference.child(u.getLastPathSegment());
            fotoRerefence.putFile(u).addOnSuccessListener(this, new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Uri u = taskSnapshot.getDownloadUrl();
                    MessageShareActivity m = new MessageShareActivity("Te han enviado una foto",u.toString(), name.getText().toString(),photoPerfi,"2",ServerValue.TIMESTAMP);
                    databaseReference.push().setValue(m);

                }
            });
        }
            else if(requestCode == PHOTO_SEND && resultCode== RESULT_OK){
                Uri u = data.getData();
                storageReference = storage.getReference("photo_perfil");//images
                final StorageReference fotoRerefence = storageReference.child(u.getLastPathSegment());
                fotoRerefence.putFile(u).addOnSuccessListener(this, new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Uri u = taskSnapshot.getDownloadUrl();
                        photoPerfi = u.toString();
                        MessageShareActivity m = new MessageShareActivity("Han actualizado su foto de perfil",u.toString(), name.getText().toString(),photoPerfi,"2",ServerValue.TIMESTAMP);
                        databaseReference.push().setValue(m);
                        Glide.with(MainMessageActivity.this).load(u.toString()).into(photoPerfil);

                    }
                });
        }


    }

}
