package com.uiuaadingding.tomtom.pandutani.pengingat_jagung.jtgl12;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

import com.uiuaadingding.tomtom.pandutani.pengingat_jagung.jtgl11.NotifyServicej11;

import java.util.Calendar;

public class ScheduleClientj12 {
    // The hook into our service
    private ScheduleServicej12 mBoundService;
    // The context to start the service in
    private Context mContext;
    // A flag if we are connected to the service or not
    private boolean mIsBound;

    public ScheduleClientj12(Context context) {
        mContext = context;
    }

    /**
     * Call this to connect your activity to your service
     */
    public void doBindService() {
        // Establish a connection with our service
        mContext.bindService(new Intent(mContext, ScheduleServicej12.class), mConnection, Context.BIND_AUTO_CREATE);
        mIsBound = true;
    }

    /**
     * When you attempt to connect to the service, this connection will be called with the result.
     * If we have successfully connected we instantiate our service object so that we can call methods on it.
     */
    private ServiceConnection mConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName className, IBinder service) {
            // This is called when the connection with our service has been established,
            // giving us the service object we can use to interact with our service.
            mBoundService = ((ScheduleServicej12.ServiceBinder) service).getService();
        }

        public void onServiceDisconnected(ComponentName className) {
            mBoundService = null;
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
        if (mIsBound) {
            // Detach our existing connection.
            mContext.unbindService(mConnection);
            mIsBound = false;
        }
    }

    public void setAlarmForNotification(Calendar jagungtgl12) {
        mBoundService.setAlarm(jagungtgl12);
    }

    public void cancelAlarm(){
        Intent intent = new Intent(mContext, NotifyServicej12.class);
        intent.putExtra(NotifyServicej12.INTENT_NOTIFYj12, true);
        PendingIntent pendingIntent = PendingIntent.getService(mContext, 0, intent, 0);

        AlarmManager am = (AlarmManager) mContext.getSystemService(Context.ALARM_SERVICE);
        am.cancel(pendingIntent);
    }
}
