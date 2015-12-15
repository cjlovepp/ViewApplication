package com.example.cj.progressbarapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;


public class ProgressBarActivity extends Activity {

    int[] data = new int[100];

    int status = 0;

    int hasData = 0;

    ProgressBar progressBar;

    ProgressBar progressBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);


        progressBar2 = (ProgressBar) findViewById(R.id.progressBar2);

        new Thread(){

            @Override
            public void run() {
                progressBar.setProgress(doWork());

                System.out.println(progressBar.getProgress());


                progressBar2.setProgress(doWork());
            }
        }.start();



    }

    public int doWork(){

        data[hasData++] = (int)Math.random()*100;

        try {
            Thread.sleep(100);
            return  hasData;
        }catch (Exception e){
            e.printStackTrace();
            return  hasData;
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_progress_bar, menu);
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
