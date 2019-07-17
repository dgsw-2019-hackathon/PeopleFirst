package org.techtown.hackathon.network;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import org.techtown.hackathon.R;
import org.techtown.hackathon.activity.MainActivity;

public class BroadcastD extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationManager notificationmanager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, new Intent(context, MainActivity.class), PendingIntent.FLAG_UPDATE_CURRENT);

        Notification.Builder builder = new Notification.Builder(context, "channel")
                .setWhen(System.currentTimeMillis())
                .setContentTitle("HelloParents")
                .setContentText("약 먹을 시간입니다.")
                .setSmallIcon(R.drawable.green_icon)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        notificationmanager.notify(1, builder.build());
    }
}