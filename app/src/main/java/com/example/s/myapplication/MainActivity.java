package com.example.s.myapplication;
//package com.iaiai.activity;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends Activity implements SeekBar.OnSeekBarChangeListener, Button.OnClickListener, Button.OnTouchListener {

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private SeekBar seekBar;
    private SeekBar seekBar2;

    private Button button;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
        seekBar.setOnSeekBarChangeListener(this);
        seekBar2.setOnSeekBarChangeListener(this);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        button.setOnTouchListener(this);
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);
        button3.setOnTouchListener(this);

        //set button tag to distinguish the two buttons
        //we can also set tag in xml file by the format android:tag="2"
        button.setTag(1);
        button3.setTag(3);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress,
                                  boolean fromUser) {
        // TODO Auto-generated method stub
        if (seekBar.getId() == R.id.seekBar) {
            textView2.setText("刻度1" + progress);
        }
        if (seekBar.getId() == R.id.seekBar2) {
            textView3.setText("刻度2" + progress);
        }
    }
    public void onClick(View v) {
        int tag = (Integer) v.getTag();
        if (tag == 1) {
            System.out.println("1111您点击了Button3");
        }
        if (tag == 3) {
            System.out.println("22222 button");
        }
    }

    public boolean onTouchEvent( MotionEvent event)
    {   //touch on other area of the screen ACTION UP ACTION DOWN
            if(event.getAction() == MotionEvent.ACTION_UP){
                float x = event.getX();
                float y = event.getY();
                System.out.println(x + "/" + y + "screen press up");
            }
            if(event.getAction() == MotionEvent.ACTION_DOWN){
                System.out.println("screen press Down");
            }
            if(event.getAction() == MotionEvent.ACTION_MOVE){

            }
      //  }
        return false;
    }
    public boolean onTouch(View v, MotionEvent event) {
        int tag = (Integer) v.getTag();
        if(tag == 1){
            if(event.getAction() == MotionEvent.ACTION_DOWN){  //why cannot use ACTION_BUTTON_PRESS
                textView4.setText("Button1 Pressed");
            }
            if(event.getAction() == MotionEvent.ACTION_UP){
                textView4.setText("Button1 Released");
            }
        }
        if(tag == 3){
            if(event.getAction() == MotionEvent.ACTION_DOWN){
                textView4.setText("Button3 Pressed");
            }
            if(event.getAction() == MotionEvent.ACTION_UP){
                textView4.setText("Button3 Released");
            }
        }
        return false;
    }
    //seekBar开始拖动位置
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated method stub
        if (seekBar.getId() == R.id.seekBar) {
            textView2.setText("开始拖动");
        } else// if(seekBar.getId()==R.id.seekBar2)
        {
            textView3.setText("当前拖动");
        }
    }


    //seekBar停止拖动位置
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated method stub
        if (seekBar.getId() == R.id.seekBar) {
            textView2.setText("停止拖动");
        } else// if(seekBar.getId()==R.id.seekBar2)
        {
            textView3.setText("停止拖动");
        }
    }

    public void clickHandler(View v) {
        System.out.println("您点击了Button3");
    }

    /*
    public void clickHandler(View v) {
        textView4.setText("Button pressed");
    }
*/

 }

