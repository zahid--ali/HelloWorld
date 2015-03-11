package nerdcamp.thenerdcamp.com.helloworld;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FirstActivity extends ActionBarActivity {
    Button button;
    EditText input;
    TextView display;
    SharedPreferences settings;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);

        settings = getSharedPreferences("UserSettings",MODE_PRIVATE);
        editor = settings.edit();
        editor.putString("SMS","Hey you have 1 new message");
        editor.putInt("MYnumber",052141122);

        if(settings.getBoolean("FirstActivity",false)){
            editor.commit();
           startActivity(new Intent(FirstActivity.this,ThirdActivity.class));
        }
        else
        {
            editor.putBoolean("FirstActivity",true);

        }
        editor.commit();

        button = (Button)findViewById(R.id.btnPressme);
        input = (EditText)findViewById(R.id.etInput);
        display = (TextView)findViewById(R.id.tvDisplay);

        display.setText("Welcome");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = input.getText().toString();
                s += " Welcome";
                display.setText(s);


                startActivity(new Intent(FirstActivity.this,ThirdActivity.class));
//                startActivity(new Intent(FirstActivity.this,SecondActivity.class));
//               Intent i = new Intent(FirstActivity.this,SecondActivity.class);
//               Bundle b = new Bundle();
//                b.putString("Message",s);
//                b.putBoolean("Checkbox",true);
//                i.putExtras(b);

//                startActivity(i);
//                FirstActivity.this.finish();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_first, menu);
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
