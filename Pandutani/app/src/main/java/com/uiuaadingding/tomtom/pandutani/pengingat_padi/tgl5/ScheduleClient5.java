package com.uiuaadingding.tomtom.pandutani.pengingat_padi.tgl5;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

import java.util.Calendar;

public class ScheduleClient5 {
    // The hook into our service
    private ScheduleService5 mBoundService5;
    // The context to start the service in
    private Context mContext5;
    // A flag if we are connected to the service or not
    private boolean mIsBound5;

    public ScheduleClient5(Context context) {
        mContext5 = context;
    }

    /**
     * Call this to connect your activity to your service
     */
    public void doBindService() {
        // Establish a connection with our service
        mContext5.bindService(new Intent(mContext5, ScheduleService5.class), mConnection, Context.BIND_AUTO_CREATE);
        mIsBound5 = true;
    }

    /**
     * When you attempt to connect to the service, this connection will be called with the result.
     * If we have successfully connected we instantiate our service object so that we can call methods on it.
     */
    private ServiceConnection mConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName className, IBinder service) {
            // This is called when the connection with our service has been established,
            // giving us the service object we can use to interact with our service.
            mBoundService5 = ((ScheduleService5.ServiceBinder) service).getService();
        }

        public void onServiceDisconnected(ComponentName className) {
            mBoundService5 = null;
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
        if (mIsBound5) {
            // Detach our existing connection.
            mContext5.unbindService(mConnection);
            mIsBound5 = false;
        }
    }

    public void setAlarmForNotification(Calendar paditgl5) {
        mBoundService5.setAlarm(paditgl5);
    }

    public void cancelAlarm(){
        Intent intent = new Intent(mContext5, NotifyService5.class);
        intent.putExtra(NotifyService5.INTENT_NOTIFY5, true);
        PendingIntent pendingIntent = PendingIntent.getService(mContext5, 0, intent, 0);

        AlarmManager am = (AlarmManager) mContext5.getSystemService(Context.ALARM_SERVICE);
        am.cancel(pendingIntent);
    }
}
