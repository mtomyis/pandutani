package com.uiuaadingding.tomtom.pandutani.pengingat_jagung.jtgl2;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.uiuaadingding.tomtom.pandutani.pengingat_jagung.jtgl2.NotifyServicej2;

import java.util.Calendar;

/**
 * Set an alarm for the date passed into the constructor
 * When the alarm is raised it will start the NotifyService
 *
 * This uses the android build in alarm manager *NOTE* if the phone is turned off this alarm will be cancelled
 *
 * This will run on it's own thread.
 *
 * @author paul.blundell
 */
public class AlarmTaskj2 implements Runnable{
    // The date selected for the alarm
    private final Calendar date;
    // The android system alarm manager
    private final AlarmManager am;
    // Your context to retrieve the alarm manager from
    private final Context context;

    public AlarmTaskj2(Context context, Calendar date) {
        this.context = context;
        this.am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        this.date = date;
    }

    @Override
    public void run() {
        // Request to start are service when the alarm date is upon us
        // We don't start an activity as we just want to pop up a notification into the system bar not a full activity
        Intent intentj2 = new Intent(context, NotifyServicej2.class);
        intentj2.putExtra(NotifyServicej2.INTENT_NOTIFYj2, true);
        intentj2.putExtra(NotifyServicej2.EXTRA_ID, 17);
        PendingIntent pendingIntentj2 = PendingIntent.getService(context, 0, intentj2, 0);

        // Sets an alarm - note this alarm will be lost if the phone is turned off and on again
        am.set(AlarmManager.RTC, date.getTimeInMillis(), pendingIntentj2);
    }
}
