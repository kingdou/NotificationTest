package com.example.notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                Notification notification;
                Intent intent=new Intent(MainActivity.this,MainActivity.class);
                PendingIntent pi=PendingIntent.getActivity(MainActivity.this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
                Notification.Builder builder = new Notification.Builder(MainActivity.this).setTicker("hello").setSmallIcon(R.mipmap.ic_launcher);
                notification = builder.setContentTitle("hello").setContentText("world").setContentIntent(pi).build();
                notification.defaults= Notification.DEFAULT_ALL;
                manager.notify(1,notification);
            }
        });
    }
}
