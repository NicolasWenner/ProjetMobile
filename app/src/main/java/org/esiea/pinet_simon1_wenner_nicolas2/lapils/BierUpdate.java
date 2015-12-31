package org.esiea.pinet_simon1_wenner_nicolas2.lapils;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.NotificationCompat;
import android.util.Log;


public class BierUpdate extends BroadcastReceiver{

    public static final String TAG = "Biers downloaded !";

    @Override
    public void onReceive(Context context, Intent intent){
        Log.d(TAG,intent.getAction());

        PendingIntent pi = PendingIntent.getActivity(context,0,new Intent(context,ShowBierList.class),0);

        NotificationCompat.Builder notif= new NotificationCompat.Builder(context);
        notif.setSmallIcon(R.drawable.notification);
        notif.setContentTitle("List of Biers");
        // Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        // notif.setSound(alarmSound);
        notif.setContentText("List is ready !");
        notif.setPriority(0);
        notif.setContentIntent(pi);
        notif.setAutoCancel(true);
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(14,notif.build());
    }

}
