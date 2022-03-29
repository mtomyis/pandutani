package com.uiuaadingding.tomtom.pandutani.pengingat_padi.tgl9;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

import java.util.Calendar;

public class ScheduleClient9 {
    // The hook into our service
    private ScheduleService9 mBoundService9;
    // The context to start the service in
    private Context mContext9;
    // A flag if we are connected to the service or not
    private boolean mIsBound9;

    public ScheduleClient9(Context context) {
        mContext9 = context;
    }

    /**
     * Call this to connect your activity to your service
     */
    public void doBindService() {
        // Establish a connection with our service
        mContext9.bindService(new Intent(mContext9, ScheduleService9.class), mConnection, Context.BIND_AUTO_CREATE);
        mIsBound9 = true;
    }

    /**
     * When you attempt to connect to the service, this connection will be called with the result.
     * If we have successfully connected we instantiate our service object so that we can call methods on it.
     */
    private ServiceConnection mConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName className, IBinder service) {
            // This is called when the connection with our service has been established,
            // giving us the service object we can use to interact with our service.
            mBoundService9 = ((ScheduleService9.ServiceBinder) service).getService();
        }

        public void onServiceDisconnected(ComponentName className) {
            mBoundService9 = null;
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
        if (mIsBound9) {
            // Detach our existing connection.
            mContext9.unbindService(mConnection);
            mIsBound9 = false;
        }
    }

    public void setAlarmForNotification(Calendar paditgl9) {
        mBoundService9.setAlarm(paditgl9);
    }

    public void cancelAlarm(){
        Intent intent = new Intent(mContext9, NotifyService9.class);
        intent.putExtra(NotifyService9.INTENT_NOTIFY9, true);
        PendingIntent pendingIntent = PendingIntent.getService(mContext9, 0, intent, 0);

        AlarmManager am = (AlarmManager) mContext9.getSystemService(Context.ALARM_SERVICE);
        am.cancel(pendingIntent);
    }
}
