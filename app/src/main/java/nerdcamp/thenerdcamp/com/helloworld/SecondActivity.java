package nerdcamp.thenerdcamp.com.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.internal.widget.TintEditText;
import android.widget.Toast;

/**
 * Created by Zahid on 3/9/2015.
 */
public class SecondActivity extends ActionBarActivity {
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        Intent a = getIntent();
        String message = a.getStringExtra("Message");
        Boolean b = a.getBooleanExtra("Checkbox",false);
        Toast.makeText(getApplicationContext(),"Checkbox: " + String.valueOf(b),Toast.LENGTH_LONG).show();
        i = new Intent(SecondActivity.this,FirstService.class);
        //startService(i);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(i);
    }
}
