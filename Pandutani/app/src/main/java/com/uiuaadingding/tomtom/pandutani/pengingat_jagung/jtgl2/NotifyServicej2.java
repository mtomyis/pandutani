package com.uiuaadingding.tomtom.pandutani.pengingat_jagung.jtgl2;

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

public class NotifyServicej2 extends Service {
    protected static String EXTRA_ID = "";

    /**
     * Class for clients to access
     */
    public class ServiceBinder extends Binder {
        NotifyServicej2 getService() {
            return NotifyServicej2.this;
        }
    }

    // Unique id to identify the notification.
    private static final int NOTIFICATIONj2 = 122;
    // Name of an intent extra we can use to identify if this service was started to create a notification
    public static final String INTENT_NOTIFYj2 = "com.blundell.tut.service.INTENT_NOTIFYj2";
    // The system notification manager
    private NotificationManager mNMj2;

    @Override
    public void onCreate() {
        Log.i("NotifyServicej2", "onCreate()");
        mNMj2 = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("LocalService", "Received start id " + startId + ": " + intent);

        // If this service was started by out AlarmTask intent then we want to show our notification
        if(intent.getBooleanExtra(INTENT_NOTIFYj2, false))
            showNotificationj2();

        // We don't care if this service is stopped as we have already delivered our notification
        return START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinderj2;
    }

    // This is the object that receives interactions from clients
    private final IBinder mBinderj2 = new ServiceBinder();

    /**
     * Creates a notification and shows it in the OS drag-down status bar
     */
    private void showNotificationj2() {
        // This is the 'title' of the notification
        //CharSequence title = "Alarm!!";
        // This is the icon to use on the notification
        //int icon = R.drawable.ic_dialog_alert;
        // This is the scrolling text of the notification
        //CharSequence text = "Your notification time is upon us.";
        // What time to show on the notification
        //long time = System.currentTimeMillis();

        Notification.Builder builderj2 = new Notification.Builder(NotifyServicej2.this);

        Intent notifij2 = new Intent(this,DetailPengingatActivity.class);
        notifij2.putExtra(NotifyServicej2.EXTRA_ID, 17);
        notifij2.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntentj2 = PendingIntent.getActivity(this, 0,notifij2, PendingIntent.FLAG_UPDATE_CURRENT);
        builderj2.setSmallIcon(R.drawable.ic_dialog_alert)
                .setContentTitle("Pandutaniwangi").setContentText("Waktunya Pemupukan")
                .setContentIntent(pendingIntentj2);

        NotificationManager notificationManagerj2 = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification = builderj2.getNotification();
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
        mNMj2.notify(NOTIFICATIONj2, notification);

        // Stop the service when we are finished
        stopSelf();
    }
}

