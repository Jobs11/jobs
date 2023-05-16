package com.example.test8

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatActivity
import com.example.test8.databinding.ActivityMainBinding

class MyEventHandler : CompoundButton.OnCheckedChangeListener {
    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        Log.d("seee", "클래스 구현2")
    }

}

/*class MainActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.check1.setOnCheckedChangeListener(this)
    }*/
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // binding.check1.setOnCheckedChangeListener(MyEventHandler())
        binding.check1.setOnCheckedChangeListener {
                compoundButton, b ->
            Log.d("seee","췤췤췤췤 3번")
        }

        binding.btn1.setOnLongClickListener {
            Log.d("seee","bttttttttttttttttttttttn")
            true
        }

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action){
            MotionEvent.ACTION_DOWN -> {
                Log.d("SEEEEE", "Touch downnnnnnnnnnnn ${event.x}, ${event.rawX}, ${event.y},${event.rawY}")
            }

            MotionEvent.ACTION_UP -> {
                Log.d("SEEEEE","Touch uppppppppppppp ${event.x}, ${event.rawX}, ${event.y},${event.rawY}")
            }
        }
        return super.onTouchEvent(event)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        when (keyCode) {
            KeyEvent.KEYCODE_BACK -> Log.d("seeee", "baccccccccccccccccccckk")
            KeyEvent.KEYCODE_VOLUME_UP -> Log.d("seeee", "volume upppppppppppp")
            KeyEvent.KEYCODE_VOLUME_DOWN -> Log.d("seeee", "volume downnnnnnnnn")
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        Log.d("seeeeeeeeeee", "keeeeeeeeeeeeeeeeeup")
        return super.onKeyUp(keyCode, event)
    }

    /*override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        Log.d("seeee", "체체체쳌")
    }*/


}

