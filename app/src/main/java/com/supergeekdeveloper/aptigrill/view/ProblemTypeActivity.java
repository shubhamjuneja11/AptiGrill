package com.supergeekdeveloper.aptigrill.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.supergeekdeveloper.aptigrill.R;
import com.supergeekdeveloper.aptigrill.controller.ProblemTypeAdapter;
import com.supergeekdeveloper.aptigrill.model.ProblemTypeModel;

import java.util.ArrayList;

public class ProblemTypeActivity extends AppCompatActivity {
    ProblemTypeAdapter adapter;
    ArrayList<ProblemTypeModel> al;
    FirebaseDatabase database;
    DatabaseReference ref;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem_type);
        recyclerView=(RecyclerView)findViewById(R.id.recycler);
        al=new ArrayList<>();
        adapter=new ProblemTypeAdapter(this,al);
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        database=FirebaseDatabase.getInstance();
        ref=database.getReference("type");
        listen();
    }
    void listen(){
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String so=dataSnapshot.getKey();
                al.add(new ProblemTypeModel(so));
                adapter.notifyDataSetChanged();
                Log.e("abc",so);
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
}
