package com.ibrahim.mohammad.entertainmentapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Postpage extends AppCompatActivity {

    private FragmentComment fragmentComment = new FragmentComment();
    private String text;
    private String[] fruits;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postpage);

        text = "asdasdasda";
        /*TextView tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvTitle.setText(text);//set the text in edit text
*/
        final ListView lv = (ListView) findViewById(R.id.lvList);
        fruits = new String[]{" - " + "asdas", "asdasdasd" , "adsasdasd ", "dasdasdasd"};
        final List<String> fruitsList = new ArrayList<String>(Arrays.asList(fruits));
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, fruitsList);
        lv.setAdapter(arrayAdapter);



    }


}
