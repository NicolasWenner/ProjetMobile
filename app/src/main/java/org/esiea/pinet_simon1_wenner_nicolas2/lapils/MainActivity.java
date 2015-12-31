package org.esiea.pinet_simon1_wenner_nicolas2.lapils;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.format.DateUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv_hw = (TextView) findViewById(R.id.tv_hello_world);


        String now = DateUtils.formatDateTime(getApplicationContext(), (new Date()).getTime(), DateFormat.FULL);
        tv_hw.setText("Bienvenue  " + now);


        Button btn_hw = (Button) findViewById(R.id.btn_hello_world);
        String s = getString(R.string.button_text);

        Button btn_2 = (Button) findViewById(R.id.btn2);
        String t = getString(R.string.button_text2);

        Button btn_3 = (Button) findViewById(R.id.btn3);
        String l = getString(R.string.button_text3);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    public static class dpd extends DialogFragment implements DatePickerDialog.OnDateSetListener

    {
      //  public Dialog onCreateDialog(Bundle savedInstanceState)


        public void onDateSet (DatePicker view,int year, int monthOfYear, int dayOfMonth){


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


    public void FonctionTwo(View view) {
        Intent myIntent = new Intent (this,HSActivity.class);
        startActivity(myIntent);
        Toast.makeText(getApplicationContext(), getString(R.string.msg), Toast.LENGTH_LONG).show();
    }



    public void FonctionOnePlus(View view) {
        Intent myIntent = new Intent (this,LOLActivity.class);
        startActivity(myIntent);
        Toast.makeText(getApplicationContext(), getString(R.string.msg), Toast.LENGTH_LONG).show();
    }


    public void FonctionTree(View view) {

        GetBiersServices.startActionBiers(this);
        Intent myIntent = new Intent (this,ShowBierList.class);
        startActivity(myIntent);
    }

}