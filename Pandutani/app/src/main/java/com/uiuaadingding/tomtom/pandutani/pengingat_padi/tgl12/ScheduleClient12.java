package com.uiuaadingding.tomtom.pandutani.pengingat_padi.tgl12;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

import java.util.Calendar;

public class ScheduleClient12 {
    // The hook into our service
    private ScheduleService12 mBoundService12;
    // The context to start the service in
    private Context mContext12;
    // A flag if we are connected to the service or not
    private boolean mIsBound12;

    public ScheduleClient12(Context context) {
        mContext12 = context;
    }

    /**
     * Call this to connect your activity to your service
     */
    public void doBindService() {
        // Establish a connection with our service
        mContext12.bindService(new Intent(mContext12, ScheduleService12.class), mConnection, Context.BIND_AUTO_CREATE);
        mIsBound12 = true;
    }

    /**
     * When you attempt to connect to the service, this connection will be called with the result.
     * If we have successfully connected we instantiate our service object so that we can call methods on it.
     */
    private ServiceConnection mConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName className, IBinder service) {
            // This is called when the connection with our service has been established,
            // giving us the service object we can use to interact with our service.
            mBoundService12 = ((ScheduleService12.ServiceBinder) service).getService();
        }

        public void onServiceDisconnected(ComponentName className) {
            mBoundService12 = null;
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
        if (mIsBound12) {
            // Detach our existing connection.
            mContext12.unbindService(mConnection);
            mIsBound12 = false;
        }
    }

    public void setAlarmForNotification(Calendar paditgl12) {
        mBoundService12.setAlarm(paditgl12);
    }

    public void cancelAlarm(){
        Intent intent = new Intent(mContext12, NotifyService12.class);
        intent.putExtra(NotifyService12.INTENT_NOTIFY12, true);
        PendingIntent pendingIntent = PendingIntent.getService(mContext12, 0, intent, 0);

        AlarmManager am = (AlarmManager) mContext12.getSystemService(Context.ALARM_SERVICE);
        am.cancel(pendingIntent);
    }
}
