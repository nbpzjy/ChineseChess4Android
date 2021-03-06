package com.luojiawei.chinesechess.chinesechess4android;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener {

    private Button mBtnLowRank;
    private Button mBtnMiddleRank;
    private Button mBtnHighRank;
    private Button mBtnBluetooth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置无标题，全屏显示
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        setContentView(R.layout.activity_main);

        //找按钮控件，并设置监听
        mBtnLowRank = (Button) findViewById(R.id.btn_low_rank);
        mBtnLowRank.setOnClickListener(this);
        mBtnMiddleRank = (Button) findViewById(R.id.btn_middle_rank);
        mBtnMiddleRank.setOnClickListener(this);
        mBtnHighRank = (Button) findViewById(R.id.btn_high_rank);
        mBtnHighRank.setOnClickListener(this);
        mBtnBluetooth = (Button) findViewById(R.id.btn_bluetooth);
        mBtnBluetooth.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_low_rank:
                LogUtil.i(getLocalClassName(), "btn_low_rank");
                GameActivity.actionStart(MainActivity.this, GameActivity.LOW_RANK);
                break;
            case R.id.btn_middle_rank:
                LogUtil.i(getLocalClassName(), "btn_middle_rank");
                GameActivity.actionStart(MainActivity.this, GameActivity.MIDDLE_RANK);
                break;
            case R.id.btn_high_rank:
                LogUtil.i(getLocalClassName(), "btn_high_rank");
                GameActivity.actionStart(MainActivity.this, GameActivity.HIGH_RANK);
                break;
            case R.id.btn_bluetooth:
                LogUtil.i(getLocalClassName(), "btn_bluetooth");
                GameActivity.actionStart(MainActivity.this, GameActivity.BLUETOOTH);
                break;
            default:
                break;
        }
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
