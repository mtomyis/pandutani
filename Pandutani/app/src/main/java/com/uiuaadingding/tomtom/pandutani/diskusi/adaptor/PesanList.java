package com.uiuaadingding.tomtom.pandutani.diskusi.adaptor;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.uiuaadingding.tomtom.pandutani.R;
import com.uiuaadingding.tomtom.pandutani.diskusi.model.Pesan;

import java.util.List;

/**
 * Created by Belal on 2/26/2017.
 */

public class PesanList extends ArrayAdapter<Pesan> {
    private Activity context;
    List<Pesan> pesans;

    public PesanList(Activity context, List<Pesan> pesans) {
        super(context, R.layout.item_pesan, pesans);
        this.context = context;
        this.pesans = pesans;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.item_pesan, null, true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.message_text);
        TextView textViewRating = (TextView) listViewItem.findViewById(R.id.message_user);

        Pesan pesan = pesans.get(position);
        textViewName.setText(pesan.getPesanName());
        textViewRating.setText(String.valueOf(pesan.getPesanPetani()));

        return listViewItem;
    }
}