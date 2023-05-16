package com.example.test10

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import android.widget.MediaController
import android.widget.TimePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.test10.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val eventHandler = object : DialogInterface.OnClickListener{
        override fun onClick(dialog: DialogInterface?, which: Int) {
            if (which == DialogInterface.BUTTON_POSITIVE) {
                Toast.makeText(this@MainActivity, "토스트 띄우기", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@MainActivity, "토스트 닫기", Toast.LENGTH_SHORT).show()
            }
        }
    }
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
                Log.d("SEEE", "year : $p1, month : $p2, dayOfMonth : $p3")

                Toast.makeText(
                    this@MainActivity,
                    "year : $p1, month : $p2, dayOfMonth : $p3",
                    Toast.LENGTH_SHORT
                ).show()


            }
        }, 2022, 9, 12).show()

        binding.btn7.setOnClickListener {
            /*val player: MediaPlayer = MediaPlayer.create(this, R.raw.testsound)
            player.start()*/
            val videoFile:Uri = Uri.parse("android.resource://"+packageName+"/raw/testcloud")

            val mc = MediaController(this)

            binding.vd1.setMediaController(mc)
            binding.vd1.setVideoPath(videoFile.toString())
            binding.vd1.start()
        }

        binding.btn6.setOnClickListener {
            val notification : Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            val ringtone = RingtoneManager.getRingtone(applicationContext, notification)
            ringtone.play()
        }

        binding.btn5.setOnClickListener {
            val items = arrayOf<String>("두루치기", "된장찌개", "밀면", "칼국수")
            AlertDialog.Builder(this@MainActivity).run {
                setTitle("메뉴 alert 다이얼로그")
                setIcon(android.R.drawable.ic_dialog_info)
                setMultiChoiceItems(
                    items,
                    booleanArrayOf(true, false, false, false),
                    object : DialogInterface.OnMultiChoiceClickListener {
                        override fun onClick(
                            dialog: DialogInterface?,
                            which: Int,
                            isChecked: Boolean
                        ) {
                            Log.d("SEEE", "${items[which]} ${if (isChecked) "선택" else "선택 해제"}")
                        }
                    })
                setPositiveButton("닫기", null)
                show()

            }
        }

            binding.btn4.setOnClickListener {
                val items = arrayOf<String>("두루치기", "된장찌개", "밀면", "칼국수")

                AlertDialog.Builder(this@MainActivity).run {
                    setTitle("메뉴 alert 다이얼로그")
                    setIcon(android.R.drawable.ic_dialog_info)
                    setItems(
                        items, object : DialogInterface.OnClickListener {
                            override fun onClick(dialog: DialogInterface?, which: Int) {
                                Toast.makeText(
                                    this@MainActivity,
                                    "선택한 점심 메뉴 : ${items[which]}",
                                    Toast.LENGTH_SHORT
                                ).show()
                                Log.d("SEEE", "선택한 점심 메뉴 : ${items[which]}")
                            }
                        }
                    )
                    setPositiveButton("닫기", null)
                    show()
                }
            }

            binding.btn2.setOnClickListener {
                TimePickerDialog(this, object : TimePickerDialog.OnTimeSetListener {
                    override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
                        Toast.makeText(this@MainActivity, "${p1}시 ${p2}분", Toast.LENGTH_SHORT)
                            .show()
                        Log.d("SEEE", "${p1}시 ${p2}분")
                    }
                }, 15, 0, true).show()
            }




            binding.btn3.setOnClickListener {
                AlertDialog.Builder(this@MainActivity).run {
                    setTitle("test dialog")
                    setIcon(android.R.drawable.ic_dialog_info)
                    setMessage("토스트 메시지 띄울까요??")
                    setPositiveButton("확인", eventHandler)
                    setNegativeButton("취소", eventHandler)

                    show()
                }
            }

            binding.btn1.setOnClickListener {
                fun showToast() {
                    val toast = Toast.makeText(this, "종료하려면 한 번 더 누르세요.", Toast.LENGTH_SHORT)
                    toast.addCallback(
                        object : Toast.Callback() {
                            override fun onToastHidden() {
                                super.onToastHidden()
                                Log.d("SEEE", "토스트 히든, 숨겨진 후 기능")
                            }

                            override fun onToastShown() {
                                super.onToastShown()
                                Log.d("SEEE", "토스트 숀, 보여진후 기능")
                            }
                        })
                    toast.show()
                }

                showToast()
            }
            /*@RequiresApi(Build.VERSION_CODES.R)
        fun showToast() {
            val toast = Toast.makeText(this, "종료하려면 한 번 더 누르세요.", Toast.LENGTH_SHORT)
            toast.addCallback(
                object : Toast.Callback() {
                    override fun onToastHidden() {
                        super.onToastHidden()
                        Log.d("SEEE", "토스트 히든, 숨겨진 후 기능")
                    }

                    override fun onToastShown() {
                        super.onToastShown()
                        Log.d("SEEE", "토스트 숀, 보여진후 기능")
                    }
                })
            toast.show()
        }*/


            /*val requestPermissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted ->
            if (isGranted) {
                Log.d("SEEE", "승인됨2")
            } else {
                Log.d("SEEE", "승인안됨2")
            }
        }

        val status = ContextCompat.checkSelfPermission(this,
            "android.permission.ACCESS_FINE_LOCATION")
        if(status == PackageManager.PERMISSION_GRANTED) {
            Log.d("SEEE", "승인됨2")
        } else {
            requestPermissionLauncher.launch("android.permission.ACCESS_FINE_LOCATION")
            Log.d("SEEE", "승인안됨2")
        }*/


    }

}