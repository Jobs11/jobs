package com.example.test10

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.RemoteInput

class ReplyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        val replyText = RemoteInput.getResultsFromIntent(intent)?.getCharSequence("key_text_reply")
        Log.d("SEEE", "reply 답장: $replyText")

        val manager = context.getSystemService(AppCompatActivity.NOTIFICATION_SERVICE)
            as NotificationManager

        val builder: NotificationCompat.Builder

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channelId = "one-channel"
            val channelName = "My Channel One"
            val channel = NotificationChannel(
                channelId,
                channelName,
                NotificationManager.IMPORTANCE_HIGH
            )

            manager.createNotificationChannel(channel)

            builder = NotificationCompat.Builder(context, channelId)

        }else {
            builder = NotificationCompat.Builder(context)
        }

        builder.setSmallIcon(android.R.drawable.ic_notification_overlay)
        builder.setWhen(System.currentTimeMillis())
        builder.setContentTitle("임시 제목")
        builder.setContentText(replyText)

        manager.notify(11, builder.build() )
    }
}