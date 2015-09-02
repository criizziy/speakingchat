package com.example.criizziy.speakingchat;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

public class bienvenida extends AppCompatActivity {

    public static final int segundos=6;
    public static final int milisegundos=segundos*1000;
    public static final  int delay=2;
    private ProgressBar pbprogreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);
        pbprogreso = (ProgressBar) findViewById(R.id.progressBar);
        pbprogreso.setMax(maximo_progreso());
        empezaranimacion();
        findViewById(R.id.progressBar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(bienvenida.this, inicio.class));
            }
        });
    }
     public void empezaranimacion()
     {
         new CountDownTimer(milisegundos,1000)
         {
             @Override
             public void onTick(long millisUntilFinished) {
             pbprogreso.setProgress(establecer_progreso(millisUntilFinished));
             }

             @Override
             public void onFinish() {
                 Intent nuevofrom=new Intent(bienvenida.this,inicio.class);
                 startActivity(nuevofrom);
                 finish();

             }
         }.start();
     }

    public int establecer_progreso(long miliseconds)
    {
      return (int)((milisegundos-miliseconds)/1000);
    }

    public int maximo_progreso()
    {
        return segundos-delay;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bienvenida, menu);
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
