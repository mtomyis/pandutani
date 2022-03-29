package com.uiuaadingding.tomtom.pandutani.c_lihatmenu.c_adaptor;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.uiuaadingding.tomtom.pandutani.R;
import com.uiuaadingding.tomtom.pandutani.c_lihatmenu.c_model.ItemLihat;

import java.util.ArrayList;

public class LihatAdaptor extends RecyclerView.Adapter<LihatAdaptor.LihatViewHolder> {

    private Context mContext;
    private ArrayList<ItemLihat> mListLihat;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public LihatAdaptor(Context context, ArrayList<ItemLihat> listLihat) {
        mContext = context;
        mListLihat = listLihat;
    }

    @NonNull
    @Override
    public LihatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_lihat, parent, false);
        return new LihatViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull LihatViewHolder holder, int position) {
        ItemLihat currentitem = mListLihat.get(position);

        String imgUrl = currentitem.getImageUrl();
        String nama = currentitem.getNama();

        holder.nama.setText(nama);
        Picasso.with(mContext)
                .load("http://192.168.43.158/pandutani/upload/"+imgUrl)
                .placeholder(R.drawable.farmer)
                .resize(180, 150)
                .error(R.drawable.farmer)
                .into(holder.et_iv_itemlihat);
    }

    @Override
    public int getItemCount() {
        return mListLihat.size();
    }

    public class LihatViewHolder extends RecyclerView.ViewHolder {
        public ImageView et_iv_itemlihat;
        public TextView nama;

        public LihatViewHolder(View itemView) {
            super(itemView);
            et_iv_itemlihat = itemView.findViewById(R.id.iv_itemlihat);
            nama = itemView.findViewById(R.id.tv_namalihat);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener !=null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

}

