package com.example.widgetcontrols;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

public class searchveiw_demo extends AppCompatActivity {
   SearchView searchView;
   ListView listView;
   String cities[]={"Ahmed","Anand","Amrel","Vadodara","Valsad","surat","Surrend","Gandinagar","Junagadh","Jamnagar","Bhavnagar","Morbi","Palnpur","Porgbandar","Dwarka"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchveiw_demo);
        searchView=findViewById(R.id.searchView);
        listView=findViewById(R.id.listView);
        ArrayAdapter adapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,cities);
        listView.setAdapter(adapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                adapter.getFilter().filter(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });
    }
}