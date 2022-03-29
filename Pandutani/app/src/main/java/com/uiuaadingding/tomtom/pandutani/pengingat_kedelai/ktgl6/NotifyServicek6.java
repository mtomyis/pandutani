package com.uiuaadingding.tomtom.pandutani.pengingat_kedelai.ktgl6;

import android.R;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import com.uiuaadingding.tomtom.pandutani.d_detailmenu.DetailPengingatActivity;

public class NotifyServicek6 extends Service {
    protected static String EXTRA_ID = "";

    /**
     * Class for clients to access
     */
    public class ServiceBinder extends Binder {
        NotifyServicek6 getService() {
            return NotifyServicek6.this;
        }
    }

    // Unique id to identify the notification.
    private static final int NOTIFICATION = 126;
    // Name of an intent extra we can use to identify if this service was started to create a notification
    public static final String INTENT_NOTIFYk6 = "com.blundell.tut.service.INTENT_NOTIFY";
    // The system notification manager
    private NotificationManager mNM;

    @Override
    public void onCreate() {
        Log.i("NotifyServicek6", "onCreate()");
        mNM = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("LocalService", "Received start id " + startId + ": " + intent);

        // If this service was started by out AlarmTask intent then we want to show our notification
        if(intent.getBooleanExtra(INTENT_NOTIFYk6, false))
            showNotification();

        // We don't care if this service is stopped as we have already delivered our notification
        return START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    // This is the object that receives interactions from clients
    private final IBinder mBinder = new ServiceBinder();

    /**
     * Creates a notification and shows it in the OS drag-down status bar
     */
    private void showNotification() {
        // This is the 'title' of the notification
        //CharSequence title = "Alarm!!";
        // This is the icon to use on the notification
        //int icon = R.drawable.ic_dialog_alert;
        // This is the scrolling text of the notification
        //CharSequence text = "Your notification time is upon us.";
        // What time to show on the notification
        //long time = System.currentTimeMillis();

        Notification.Builder builder = new Notification.Builder(NotifyServicek6.this);

        Intent notifi = new Intent(this,DetailPengingatActivity.class);
        notifi.putExtra(NotifyServicek6.EXTRA_ID, 34);
        notifi.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,notifi, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setSmallIcon(R.drawable.ic_dialog_alert)
                .setContentTitle("Pandutaniwangi").setContentText("Waktunya Penyiangan")
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification = builder.getNotification();
        notification.defaults |= Notification.DEFAULT_SOUND;
        notification.defaults |= Notification.DEFAULT_VIBRATE;
        notification.flags |= Notification.FLAG_AUTO_CANCEL;


        //Notification notification = new Notification(icon, text, time);

        // The PendingIntent to launch our activity if the user selects this notification
        //PendingIntent contentIntent = PendingIntent.getActivity(this, 0, new Intent(this, SecondActivity.class), 0);

        // Set the info for the views that show in the notification panel.
        //notification.setLatestEventInfo(this, title, text, contentIntent);

        // Clear the notification when it is pressed
        notification.flags |= Notification.FLAG_AUTO_CANCEL;

        // Send the notification to the system.
        mNM.notify(NOTIFICATION, notification);

        // Stop the service when we are finished
        stopSelf();
    }
}

