package com.uiuaadingding.tomtom.pandutani.b_pilihmenu.b_adaptor;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.uiuaadingding.tomtom.pandutani.R;
import com.uiuaadingding.tomtom.pandutani.a_menu.TentangActivity;
import com.uiuaadingding.tomtom.pandutani.b_pilihmenu.PilihHamaActivity;
import com.uiuaadingding.tomtom.pandutani.b_pilihmenu.b_model.ItemPilih;

import java.util.ArrayList;

public class PilihAdaptor extends RecyclerView.Adapter<PilihAdaptor.PilihViewHolder> {
    private Context mContext;
    private ArrayList<ItemPilih> mListPilih;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public PilihAdaptor(Context context, ArrayList<ItemPilih> listPilih) {
        mContext = context;
        mListPilih = listPilih;
    }

    @NonNull
    @Override
    public PilihViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_pilih, parent, false);
        return new PilihViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PilihViewHolder holder, int position) {
        ItemPilih currentitem = mListPilih.get(position);

        String imgUrl = currentitem.getImageUrl();
        String nama = currentitem.getNama();

        //Picasso.with(mContext).load(imgUrl).into(holder.et_iv_itempilih);
        holder.nama.setText(nama);
        Picasso.with(mContext)
                .load("http://192.168.43.158/pandutani/upload/"+imgUrl)
                .placeholder(R.drawable.farmer)
                .resize(180, 150)
                .error(R.drawable.farmer)
                .into(holder.et_iv_itempilih);
    }

    @Override
    public int getItemCount() {
        return mListPilih.size();
    }

    public class PilihViewHolder extends RecyclerView.ViewHolder {
        public ImageView et_iv_itempilih;
        public TextView nama;

        public PilihViewHolder(View itemView) {
            super(itemView);
            et_iv_itempilih = itemView.findViewById(R.id.iv_itempilih);
            nama = itemView.findViewById(R.id.tv_namapilih);

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

