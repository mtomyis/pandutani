package com.uiuaadingding.tomtom.pandutani.pengingat_padi.tgl11;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

import java.util.Calendar;

public class ScheduleClient11 {
    // The hook into our service
    private ScheduleService11 mBoundService11;
    // The context to start the service in
    private Context mContext11;
    // A flag if we are connected to the service or not
    private boolean mIsBound11;

    public ScheduleClient11(Context context) {
        mContext11 = context;
    }

    /**
     * Call this to connect your activity to your service
     */
    public void doBindService() {
        // Establish a connection with our service
        mContext11.bindService(new Intent(mContext11, ScheduleService11.class), mConnection, Context.BIND_AUTO_CREATE);
        mIsBound11 = true;
    }

    /**
     * When you attempt to connect to the service, this connection will be called with the result.
     * If we have successfully connected we instantiate our service object so that we can call methods on it.
     */
    private ServiceConnection mConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName className, IBinder service) {
            // This is called when the connection with our service has been established,
            // giving us the service object we can use to interact with our service.
            mBoundService11 = ((ScheduleService11.ServiceBinder) service).getService();
        }

        public void onServiceDisconnected(ComponentName className) {
            mBoundService11 = null;
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
        if (mIsBound11) {
            // Detach our existing connection.
            mContext11.unbindService(mConnection);
            mIsBound11 = false;
        }
    }

    public void setAlarmForNotification(Calendar paditgl11) {
        mBoundService11.setAlarm(paditgl11);
    }

    public void cancelAlarm(){
        Intent intent = new Intent(mContext11, NotifyService11.class);
        intent.putExtra(NotifyService11.INTENT_NOTIFY11, true);
        PendingIntent pendingIntent = PendingIntent.getService(mContext11, 0, intent, 0);

        AlarmManager am = (AlarmManager) mContext11.getSystemService(Context.ALARM_SERVICE);
        am.cancel(pendingIntent);
    }
}
