package mx.utng.edu.conoceDolores;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by vazquez on 28/02/2018.
 */


public class AdapterMessageActivity extends RecyclerView.Adapter<HolderMessageActivity> {

    List<MessageReceiveActivity> listMessage = new ArrayList<>();
    private Context c;

    public AdapterMessageActivity(Context c){
        this.c = c;

    }

    public  void  addMessage (MessageReceiveActivity m){
        listMessage.add(m);
        notifyItemInserted(listMessage.size());
    }

    @Override
    public HolderMessageActivity onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(mx.utng.edu.conoceDolores.R.layout.activity_card_view_messages, parent, false);
        return  new HolderMessageActivity(v);
     }

    @Override
    public void onBindViewHolder(HolderMessageActivity holder, int position) {
    holder.getName().setText(listMessage.get(position).getName());
    holder.getMessage().setText(listMessage.get(position).getMessage());


    if(listMessage.get(position).getType_message().equals("2")){
    holder.getPhotoMessage().setVisibility(View.VISIBLE);
    holder.getMessage().setVisibility(View.VISIBLE);
        Glide.with(c).load(listMessage.get(position).getUrlPhoto()).into(holder.getPhotoMessage()) ;
    }else if(listMessage.get(position).getType_message().equals("1")){
        holder.getPhotoMessage().setVisibility(View.GONE);
        holder.getMessage().setVisibility(View.VISIBLE);
    }if(listMessage.get(position).getPhotoPerfil().isEmpty()){
        holder.getPhotoMessagePerfil().setImageResource(mx.utng.edu.conoceDolores.R.mipmap.ic_launcher);
        }else{
        Glide.with(c).load(listMessage.get(position).getUrlPhoto()).into(holder.getPhotoMessagePerfil());

        }
        Long codeTime = listMessage.get(position).getTime();
        Date d = new Date(codeTime);
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
        holder.getTime().setText(sdf.format(d));
    }


    @Override
    public int getItemCount() {
        return listMessage.size();
    }
}