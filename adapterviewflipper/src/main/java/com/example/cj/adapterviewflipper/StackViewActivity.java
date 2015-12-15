package com.example.cj.adapterviewflipper;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.StackView;


public class StackViewActivity extends Activity {

    public int[] img = new int[]{
            R.drawable.dog1,
            R.drawable.dog2,
            R.drawable.dog3,
            R.drawable.dog4,
            R.drawable.dog5,
            R.drawable.dog6,
            R.drawable.dog7
    };

    StackView stackView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack_view);

        stackView = (StackView)findViewById(R.id.stackView);

        BaseAdapter baseAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return img.length;
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                ImageView imageView = new ImageView(StackViewActivity.this);
                imageView.setImageResource(img[position]);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setLayoutParams(new RelativeLayout.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT,ActionBar.LayoutParams.MATCH_PARENT));

                return imageView;
            }
        };

        stackView.setAdapter(baseAdapter);

    }

    public void toPreview(View view){
        stackView.showPrevious();
    }

    public void toNext(View view){
        stackView.showNext();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_stack_view, menu);
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
