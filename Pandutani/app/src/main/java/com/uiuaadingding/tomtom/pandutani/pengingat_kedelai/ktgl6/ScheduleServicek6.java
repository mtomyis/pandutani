package com.uiuaadingding.tomtom.pandutani.pengingat_kedelai.ktgl6;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.util.Calendar;

public class ScheduleServicek6 extends Service {

    /**
     * Class for clients to access
     */
    public class ServiceBinder extends Binder {
        ScheduleServicek6 getService() {
            return ScheduleServicek6.this;
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("ScheduleServicek6", "Received start id " + startId + ": " + intent);

        // We want this service to continue running until it is explicitly stopped, so return sticky.
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    // This is the object that receives interactions from clients. See
    private final IBinder mBinder = new ServiceBinder();

    /**
     * Show an alarm for a certain date when the alarm is called it will pop up a notification
     */
    public void setAlarm(Calendar kedelaitgl6) {
        // This starts a new thread to set the alarm
        // You want to push off your tasks onto a new thread to free up the UI to carry on responding
        new AlarmTaskk6(this, kedelaitgl6).run();
    }
}
