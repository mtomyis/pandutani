package com.uiuaadingding.tomtom.pandutani.pengingat_padi.tgl15;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

import java.util.Calendar;

public class ScheduleClient15 {
    // The hook into our service
    private ScheduleService15 mBoundService15;
    // The context to start the service in
    private Context mContext15;
    // A flag if we are connected to the service or not
    private boolean mIsBound15;

    public ScheduleClient15(Context context) {
        mContext15 = context;
    }

    /**
     * Call this to connect your activity to your service
     */
    public void doBindService() {
        // Establish a connection with our service
        mContext15.bindService(new Intent(mContext15, ScheduleService15.class), mConnection, Context.BIND_AUTO_CREATE);
        mIsBound15 = true;
    }

    /**
     * When you attempt to connect to the service, this connection will be called with the result.
     * If we have successfully connected we instantiate our service object so that we can call methods on it.
     */
    private ServiceConnection mConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName className, IBinder service) {
            // This is called when the connection with our service has been established,
            // giving us the service object we can use to interact with our service.
            mBoundService15 = ((ScheduleService15.ServiceBinder) service).getService();
        }

        public void onServiceDisconnected(ComponentName className) {
            mBoundService15 = null;
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
        if (mIsBound15) {
            // Detach our existing connection.
            mContext15.unbindService(mConnection);
            mIsBound15 = false;
        }
    }

    public void setAlarmForNotification(Calendar paditgl15) {
        mBoundService15.setAlarm(paditgl15);
    }

    public void cancelAlarm(){
        Intent intent = new Intent(mContext15, NotifyService15.class);
        intent.putExtra(NotifyService15.INTENT_NOTIFY15, true);
        PendingIntent pendingIntent = PendingIntent.getService(mContext15, 0, intent, 0);

        AlarmManager am = (AlarmManager) mContext15.getSystemService(Context.ALARM_SERVICE);
        am.cancel(pendingIntent);
    }
}
