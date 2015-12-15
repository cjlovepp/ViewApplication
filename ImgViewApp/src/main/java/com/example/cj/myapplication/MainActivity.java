package com.example.cj.myapplication;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends Activity {

    public int[] img = new int[]{
            R.drawable.dog1,
            R.drawable.dog2,
            R.drawable.dog3,
            R.drawable.dog4,
            R.drawable.dog5,
            R.drawable.dog6,
            R.drawable.dog7
    };

    int currentNum = 0;

    int alpha = 255;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button butNext = (Button)findViewById(R.id.but_next);
        //初始化图片一
        final ImageView img1 = (ImageView)findViewById(R.id.img1);
        img1.setImageResource(img[currentNum%7]);
        final ImageView img2 = (ImageView) findViewById(R.id.img2);
        final Button butAdd = (Button)findViewById(R.id.but_add);
        final Button butPlus = (Button)findViewById(R.id.but_plus);

        //单机下一张按钮监听器
        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img1.setImageResource(img[currentNum%7]);
                currentNum++;
            }
        });

        //对图片透明度进行调节
        butAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alpha +=5;
                img1.setImageAlpha(alpha);
                Log.i("alpha",""+alpha);
            }
        });

        butPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alpha -=5;
                img1.setImageAlpha(alpha);
                Log.i("alpha",""+alpha);

            }
        });

        img1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) img1.getDrawable();

                Bitmap bitmap = bitmapDrawable.getBitmap();

                double scale = bitmap.getWidth()/320.0;

                int x = (int) (event.getX()*scale);
                int y = (int) (event.getY()*scale);

                if(x +120 >bitmap.getWidth()){
                    x = bitmap.getWidth() - 120;
                }
                if(y+120>bitmap.getHeight()){
                    y = bitmap.getHeight() - 120;
                }

                img2.setImageBitmap(Bitmap.createBitmap(bitmap,x,y,120,120));
                return false;
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
