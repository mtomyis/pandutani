package com.uiuaadingding.tomtom.pandutani.diskusi.adaptor;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.uiuaadingding.tomtom.pandutani.R;
import com.uiuaadingding.tomtom.pandutani.diskusi.model.Diskusi;

import java.util.List;

public class DiskusiList extends ArrayAdapter<Diskusi> {
    private Activity context;
    List<Diskusi> diskusis;

    public DiskusiList(Activity context, List<Diskusi> diskusis) {
        super(context, R.layout.item_list, diskusis);
        this.context = context;
        this.diskusis = diskusis;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.item_list, null, true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);
        TextView textViewGenre = (TextView) listViewItem.findViewById(R.id.textViewGenre);

        Diskusi diskusi = diskusis.get(position);
        textViewName.setText(diskusi.getDiskusiName());
        textViewGenre.setText(diskusi.getDiskusiGenre());

        return listViewItem;
    }
}
