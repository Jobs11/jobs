package com.example.test10

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.Color
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.RemoteInput
import com.example.test10.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        /*binding.btn21.setOnClickListener {
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            val builder: NotificationCompat.Builder

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
            {
                val channelId = "one-channel"
                val channelName = "My Channel One"
                val channel = NotificationChannel(
                    channelId,
                    channelName,
                    NotificationManager.IMPORTANCE_HIGH
                )

                channel.description = "My Channel 테스트 중.230515"
                channel.setShowBadge(true)
                val soundUri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                val audioAttr = AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_ALARM)
                    .build()
                channel.setSound(soundUri,audioAttr)
                channel.enableLights(true)
                channel.lightColor = Color.RED
                channel.enableVibration(true)
                channel.vibrationPattern = longArrayOf(100,200,100,200)

                manager.createNotificationChannel(channel)

                builder = NotificationCompat.Builder(this, channelId)

            } else {
                builder = NotificationCompat.Builder(this)
            }

            builder.setSmallIcon(android.R.drawable.ic_notification_overlay)
            builder.setWhen(System.currentTimeMillis())
            builder.setContentTitle("임시 제목")
            builder.setContentText("이이이잇")

            *//*builder.setAutoCancel(false)
            builder.setOngoing(true)*//*
            val intent = Intent(this@MainActivity2, MainActivity3::class.java)

            val pendingIntent =
                PendingIntent.getActivity(this@MainActivity2, 10, intent, PendingIntent.FLAG_IMMUTABLE)

            builder.setContentIntent(pendingIntent)
            builder.setAutoCancel(true)

            manager.notify(11, builder.build())


        }*/
        binding.btn21.setOnClickListener {
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            val builder: NotificationCompat.Builder

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
            {
                val channelId = "one-channel"
                val channelName = "My Channel One"
                val channel = NotificationChannel(
                    channelId,
                    channelName,
                    NotificationManager.IMPORTANCE_HIGH
                )

                channel.description = "My Channel 테스트 중.230515"
                channel.setShowBadge(true)
                val soundUri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                val audioAttr = AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_ALARM)
                    .build()
                channel.setSound(soundUri,audioAttr)
                channel.enableLights(true)
                channel.lightColor = Color.RED
                channel.enableVibration(true)
                channel.vibrationPattern = longArrayOf(100,200,100,200)

                manager.createNotificationChannel(channel)

                builder = NotificationCompat.Builder(this, channelId)

            } else {
                builder = NotificationCompat.Builder(this)
            }

            builder.setSmallIcon(android.R.drawable.ic_notification_overlay)
            builder.setWhen(System.currentTimeMillis())
            builder.setContentTitle("임시 제목")
            builder.setContentText("이이이잇")

            /*builder.setAutoCancel(false)
            builder.setOngoing(true)*/
            val intent = Intent(this@MainActivity2, MainActivity3::class.java)

            val pendingIntent =
                PendingIntent.getActivity(this@MainActivity2, 10, intent, PendingIntent.FLAG_IMMUTABLE)

            builder.setContentIntent(pendingIntent)
            builder.setAutoCancel(true)

            //manager.notify(11, builder.build())

            val actionIntent = Intent(this@MainActivity2, OneReceiver::class.java)
            val actionPendingIntent = PendingIntent.getBroadcast(this@MainActivity2, 20, actionIntent, PendingIntent.FLAG_IMMUTABLE)
            builder.addAction(
                NotificationCompat.Action.Builder(
                    android.R.drawable.stat_notify_more, "액션 제목", actionPendingIntent
                ).build()
            )

            val KEY_TEXT_REPLY = "Key_text_reply"
            val replyLabel: String = "답장 테스트"
            var remoteInput: RemoteInput = RemoteInput.Builder(KEY_TEXT_REPLY).run {
                setLabel(replyLabel)
                build()
            }

            val replyIntent = Intent(this@MainActivity2, ReplyReceiver::class.java)
            val replyPendingIntent = PendingIntent.getBroadcast(this@MainActivity2, 30, replyIntent, PendingIntent.FLAG_MUTABLE)
            builder.addAction(
                NotificationCompat.Action.Builder(
                    android.R.drawable.ic_menu_send,
                    "답장 테스트",
                    replyPendingIntent
                ).addRemoteInput(remoteInput).build()
            )


            manager.notify(11, builder.build())




        }
    }
}