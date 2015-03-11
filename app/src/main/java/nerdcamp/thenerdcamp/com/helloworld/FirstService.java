package nerdcamp.thenerdcamp.com.helloworld;

import android.app.Service;
import android.content.Intent;
import android.os.Debug;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Zahid on 3/9/2015.
 */
public class FirstService extends Service{
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("Service","Create");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("Service","Start");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Service","destroy");
    }
}
