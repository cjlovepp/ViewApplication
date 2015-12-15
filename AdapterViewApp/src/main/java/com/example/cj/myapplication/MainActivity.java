package com.example.cj.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends Activity {

    String names[] = {
      "付昭阳","张田","杨永武","王刚","CC","QQ"
    };

    String descs[] ={
      "牙疼","带早饭","街舞","爱吃大闸蟹","晨练","肉肉"
    };

    int imgs[]={
               R.drawable.dog1,
               R.drawable.dog2,
               R.drawable.dog3,
               R.drawable.dog4,
               R.drawable.dog5,
               R.drawable.dog6
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化
        List<Map<String, Object>> items = new ArrayList<>();
        for (int i=0;i<names.length;i++){
            Map<String, Object> item = new HashMap<>();
            item.put("headPic", imgs[i]);
            item.put("name", names[i]);
            item.put("desc", descs[i]);
            items.add(item);
        }

        String[] keys = {"headPic","name","desc"};

        int[] ids = {R.id.img, R.id.title, R.id.desc};

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,items,R.layout.item_layout,keys,ids);

        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(simpleAdapter);

        //监听
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println(names[position]);
                System.out.println(id);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
