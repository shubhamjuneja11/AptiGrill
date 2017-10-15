package com.supergeekdeveloper.aptigrill.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.supergeekdeveloper.aptigrill.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main2Activity extends AppCompatActivity {
ListView lv;
    ArrayList<String> al=new ArrayList<>();
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lv=(ListView)findViewById(R.id.listview);
        adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,al);
        set();

        lv.setAdapter(adapter);
    }
    static class Question{
       String ans;
        String ques;
        String option[];

        public Question(String ques, String[] option,String ans) {

            this.ques = ques;
            this.option = option;
            this.ans=ans;
        }


    }
    void set(){
        try {
            Scanner in = new Scanner(getResources().openRawResource(R.raw.bix));
            StringBuilder sb = new StringBuilder();
            while(in.hasNext()) {
                sb.append(in.next());
            }
            in.close();
            String outString = sb.toString();
            JSONObject jsonObject=new JSONObject(outString);
            JSONObject object=jsonObject.getJSONObject("Current-Affairs");
            JSONArray array=object.getJSONArray("State");
            for(int i=0;i<array.length();i++){
                JSONObject object1=array.getJSONObject(i);
                String ans=object1.getString("ans");
                String ques=object1.getString("question");
                String opt[]=new String[4];
                JSONArray op=object1.getJSONArray("options");
                for(int j=0;j<op.length();j++){
                    opt[j]=op.getString(j);
                }
                al.add(ques);
                Log.e("abcd","1");
            }
            adapter.notifyDataSetChanged();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
