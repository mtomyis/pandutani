package com.uiuaadingding.tomtom.pandutani.diskusi;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;
import com.uiuaadingding.tomtom.pandutani.R;
import com.uiuaadingding.tomtom.pandutani.SessionManager;
import com.uiuaadingding.tomtom.pandutani.diskusi.adaptor.DiskusiList;
import com.uiuaadingding.tomtom.pandutani.diskusi.model.Diskusi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiskusiActivity extends AppCompatActivity {
    //we will use these constants later to pass the diskusi name and id to another activity
    public static final String DISKUSI_NAME = "net.simplifiedcoding.firebasedatabaseexample.diskusiname";
    public static final String DISKUSI_ID = "net.simplifiedcoding.firebasedatabaseexample.diskusiid";
    public static final String DISKUSI_PETANI = "net.simplifiedcoding.firebasedatabaseexample.diskusipetani";
    public static final String DISKUSI_GAMBAR = "net.simplifiedcoding.firebasedatabaseexample.diskusigambar";

    //view objects

    ListView listViewDiskusis;

    //a list to store all the diskusi from firebase database
    List<Diskusi> diskusis;

    //our database reference object
    DatabaseReference databaseDiskusis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diskusi);

        //getting the reference of diskusis node
        databaseDiskusis = FirebaseDatabase.getInstance().getReference("diskusis");

        //getting views
        listViewDiskusis = findViewById(R.id.listViewArtists);

        //list to store diskusis
        diskusis = new ArrayList<>();

        //attaching listener to listview
        listViewDiskusis.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //getting the selected diskusi
                Diskusi diskusi = diskusis.get(i);

                //creating an intent
                Intent intent = new Intent(getApplicationContext(), PesanActivity.class);

                //putting diskusi name and id to intent
                intent.putExtra(DISKUSI_ID, diskusi.getDiskusiId());
                intent.putExtra(DISKUSI_NAME, diskusi.getDiskusiName());
                intent.putExtra(DISKUSI_PETANI, diskusi.getDiskusiPetani());
                intent.putExtra(DISKUSI_GAMBAR, diskusi.getDiskusiGambar());

                //starting the activity with intent
                startActivity(intent);
            }
        });

        listViewDiskusis.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Diskusi diskusi = diskusis.get(i);
                showUpdateDeleteDialog(diskusi.getDiskusiId(), diskusi.getDiskusiName(), diskusi.getDiskusiPetani(), diskusi.getDiskusiGambar());
                return true;
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        //attaching value event listener
        databaseDiskusis.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous diskusi list
                diskusis.clear();

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting diskusi
                    Diskusi diskusi = postSnapshot.getValue(Diskusi.class);
                    //adding diskusi to the list
                    diskusis.add(diskusi);
                }

                //creating adapter
                DiskusiList diskusiAdapter = new DiskusiList(DiskusiActivity.this, diskusis);
                //attaching adapter to the listview
                listViewDiskusis.setAdapter(diskusiAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private boolean updateDiskusi(String id, String name, String genre, String petani, String gambar) {
        //getting the specified diskusi reference
        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("diskusis").child(id);

        //updating diskusi
        Diskusi diskusi = new Diskusi(id, name, genre, petani, gambar);
        dR.setValue(diskusi);
        Toast.makeText(getApplicationContext(), "Diskusi Updated", Toast.LENGTH_LONG).show();
        return true;
    }

    private void showUpdateDeleteDialog(final String artistId, String artistName, final String petani, final String gambar) {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.update_dialog, null);
        dialogBuilder.setView(dialogView);

        final EditText editTextName = (EditText) dialogView.findViewById(R.id.editTextName);
        final Spinner spinnerGenre = (Spinner) dialogView.findViewById(R.id.spinnerGenres);
        final Button buttonUpdate = (Button) dialogView.findViewById(R.id.buttonUpdateArtist);
        final Button buttonDelete = (Button) dialogView.findViewById(R.id.buttonDeleteArtist);

        dialogBuilder.setTitle(artistName);
        final AlertDialog b = dialogBuilder.create();
        b.show();


        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextName.getText().toString().trim();
                String genre = spinnerGenre.getSelectedItem().toString();
                if (!TextUtils.isEmpty(name)) {
                    updateDiskusi(artistId, name, genre, petani, gambar);
                    b.dismiss();
                }
            }
        });


        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                deleteArtist(artistId);
                b.dismiss();

            }
        });
    }

    private boolean deleteArtist(String id) {
        //getting the specified artist reference
        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("diskusis").child(id);

        //removing artist
        dR.removeValue();

        //getting the tracks reference for the specified artist
        DatabaseReference drTracks = FirebaseDatabase.getInstance().getReference("pesans").child(id);

        //removing all tracks
        drTracks.removeValue();
        Toast.makeText(getApplicationContext(), "Diskusi dihapus", Toast.LENGTH_LONG).show();

        return true;
    }

    public void bt_intenttambahtopik(View view) {
        Intent intent = new Intent(this, TambahTopikActivity.class);
        startActivity(intent);
    }
}
