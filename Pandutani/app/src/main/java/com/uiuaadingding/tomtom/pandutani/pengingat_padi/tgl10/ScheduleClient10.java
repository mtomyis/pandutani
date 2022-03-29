package com.uiuaadingding.tomtom.pandutani.pengingat_padi.tgl10;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

import java.util.Calendar;

public class ScheduleClient10 {
    // The hook into our service
    private ScheduleService10 mBoundService10;
    // The context to start the service in
    private Context mContext10;
    // A flag if we are connected to the service or not
    private boolean mIsBound10;

    public ScheduleClient10(Context context) {
        mContext10 = context;
    }

    /**
     * Call this to connect your activity to your service
     */
    public void doBindService() {
        // Establish a connection with our service
        mContext10.bindService(new Intent(mContext10, ScheduleService10.class), mConnection, Context.BIND_AUTO_CREATE);
        mIsBound10 = true;
    }

    /**
     * When you attempt to connect to the service, this connection will be called with the result.
     * If we have successfully connected we instantiate our service object so that we can call methods on it.
     */
    private ServiceConnection mConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName className, IBinder service) {
            // This is called when the connection with our service has been established,
            // giving us the service object we can use to interact with our service.
            mBoundService10 = ((ScheduleService10.ServiceBinder) service).getService();
        }

        public void onServiceDisconnected(ComponentName className) {
            mBoundService10 = null;
        }
    };

    /**
     * Tell our service to set an alarm for the given date
     * @param c a date to set the notification for
     */
//    public void setAlarmForNotification(Calendar c){
//        mBoundService.setAlarm(c);
//    }

    /**
     * When you have finished with the service call this method to stop it
     * releasing your connection and resources
     */
    public void doUnbindService() {
        if (mIsBound10) {
            // Detach our existing connection.
            mContext10.unbindService(mConnection);
            mIsBound10 = false;
        }
    }

    public void setAlarmForNotification(Calendar paditgl10) {
        mBoundService10.setAlarm(paditgl10);
    }

    public void cancelAlarm(){
        Intent intent = new Intent(mContext10, NotifyService10.class);
        intent.putExtra(NotifyService10.INTENT_NOTIFY10, true);
        PendingIntent pendingIntent = PendingIntent.getService(mContext10, 0, intent, 0);

        AlarmManager am = (AlarmManager) mContext10.getSystemService(Context.ALARM_SERVICE);
        am.cancel(pendingIntent);
    }
}
