/*

Author: Zahid Ali Khan
Date: 3/1132015
Working with android studio at the nerd camp


 */



package nerdcamp.thenerdcamp.com.helloworld;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;


public class ThirdActivity extends ActionBarActivity {

    Button b1,b2;
    FrameLayout fl1,fl2;
    SharedPreferences s;
    SharedPreferences.Editor editor;
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);
        b2 = (Button)findViewById(R.id.btn2);
        s = getSharedPreferences("UserSettings",0);
        editor = s.edit();
        String string = s.getString("SMS","You have no message");
        int number = s.getInt("MYnumber",45454);
        Toast.makeText(getApplicationContext(),string + number,Toast.LENGTH_SHORT).show();
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            editor.clear();
                editor.commit();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_third, menu);
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
