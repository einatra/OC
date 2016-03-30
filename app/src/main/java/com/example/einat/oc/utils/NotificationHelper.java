package com.example.einat.oc.utils;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.SystemClock;

import com.example.einat.oc.MainActivity;
import com.example.einat.oc.R;

/**
 * Created by Einat on 27/03/2016.
 */
public class NotificationHelper {

    public static void scheduleNotification(int delay, Context context){
        Notification notification = createNotification(context);
        Intent notificationIntent = new Intent(context, NotificationBroadcastReceiver.class);
        notificationIntent.putExtra(NotificationBroadcastReceiver.NOTIFICATION, notification);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        long futureInMillis = SystemClock.elapsedRealtime() + delay;
        AlarmManager alarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, futureInMillis, pendingIntent);
    }

    public static Notification createNotification(Context context){
        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent pIntent= PendingIntent.getActivity(context, (int) System.currentTimeMillis(), intent, 0);

        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        Notification.Builder builder = new Notification.Builder(context)
                .setContentTitle("POP QUIZ!")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setSound(alarmSound)
                .setContentIntent(pIntent);
        return builder.build();
    }
}
