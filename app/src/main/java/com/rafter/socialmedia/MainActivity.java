package com.rafter.socialmedia;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rafter.socialmedia.Adapters.TitleAdapter;
import com.rafter.socialmedia.Constants.Constants;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    public static final String TAG = "MainActivity";
    private Context mcontext;
    public ArrayList<String> titlesArray;
    RecyclerView recyclerView;
    String value;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Socaial Media Book");
        mcontext = MainActivity.this;
        setSupportActionBar(toolbar);

        titlesArray = new ArrayList<String>();
        titlesArray.add(Constants.Overview);
        titlesArray.add(Constants.What_Is_Social_Media);
        titlesArray.add(Constants.Popular_Social_Media_Sites);
        titlesArray.add(Constants.What_is_Social_Media_Marketing);
        titlesArray.add(Constants.How_to_Use_Social_Media_Marketing);
        titlesArray.add(Constants.Promote_Business_Using_Social_Media);
        titlesArray.add(Constants.Advertising);
        titlesArray.add(Constants.Advertising_Methods);
        titlesArray.add(Constants.BENEFITS_OF_SOCIAL_MEDIA);


        recyclerView = findViewById(R.id.recycler_view_titles);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        TitleAdapter adapter = new TitleAdapter(mcontext, titlesArray); // our adapter takes two string array
        recyclerView.setAdapter(adapter);


    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this).setMessage("Do you want to close this application ?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //  Action for 'NO' Button
                dialog.cancel();
            }
        }).show();

        // super.onBackPressed();

    }


}

