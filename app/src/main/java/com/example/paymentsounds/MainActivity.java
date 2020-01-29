package com.example.paymentsounds;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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

    public void OnClickButton(View view){
        TextView payment = findViewById(R.id.tx_payment);
        Button button = (Button)view;
        payment.setText(button.getText().toString().replace("\n"," ") +" で");
        ImageView logo = findViewById(R.id.im_logo);
        int imageId = R.drawable.logo_felica;
        MediaPlayer mediaPlayer = null;
        switch (view.getId()){
            case R.id.bt_suica:
                imageId = R.drawable.logo_suica;
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.suica);
                break;
            case R.id.bt_edy:
                imageId = R.drawable.logo_edy;
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.edy);
                break;
            case R.id.bt_nanaco:
                imageId = R.drawable.logo_nanaco;
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.nanaco);
                break;
            case R.id.bt_waon:
                imageId = R.drawable.logo_waon;
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.waon);
                break;
            case R.id.bt_id:
                imageId = R.drawable.logo_id;
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.id);
                break;
            case R.id.bt_quicpay:
                imageId= R.drawable.logo_quicpay;
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.quicpay);
                break;
            case R.id.bt_linepay:
                imageId= R.drawable.logo_linepay;
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.linepay);
                break;
            case R.id.bt_paypay:
                imageId= R.drawable.logo_paypay;
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.paypay);
                break;
            case R.id.bt_origamipay:
                imageId= R.drawable.logo_origamipay;
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.origamipay);
                break;
            case R.id.bt_rakutenpay:
                imageId= R.drawable.logo_rakutenpay;
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.rakutenpay);
                break;
            case R.id.bt_merpay:
                imageId= R.drawable.logo_merpay;
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.merpay);
                break;
            case R.id.bt_yuchopay:
                imageId= R.drawable.logo_yuchopay;
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.yuchopay);
                break;
        }
        if (mediaPlayer != null){
            mediaPlayer.start();
        }
        logo.setImageResource(imageId);
        logo.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }
}
