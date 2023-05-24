package com.example.project

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.project.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding

    var myDB: DatabaseHelper? = null

    var login: Button? = null
    var logid: EditText? = null
    var logpw: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myDB = DatabaseHelper(this)

        login = binding.login
        logid = binding.logid
        logpw = binding.logpw

        binding.loghome.setOnClickListener {
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent) //인트로 실행 후 바로 MainActivity로 넘어감.
        }

        binding.logreg.setOnClickListener {
            val intent = Intent(this@LoginActivity, MemberActivity::class.java)
            startActivity(intent) //인트로 실행 후 바로 MainActivity로 넘어감.
        }


    }

    fun SearchMem() {
        login!!.setOnClickListener(View.OnClickListener {
            val res = myDB!!.idData(logid!!.text.toString(),logpw!!.text.toString())

            if (res.count == 0) {
                ShowMessage("실패", "데이터를 찾을 수 없습니다.")
                return@OnClickListener
            }

            val buffer = StringBuffer()

            while (res.moveToNext()) {
                buffer.append(
                    """
                        ID: ${res.getString(0)}
                        
                            """.trimIndent()
                )
                buffer.append(
                    """
                        PW: ${res.getString(1)}
                        
                            """.trimIndent()
                )
                buffer.append(
                    """
                        PW_CON: ${res.getString(2)}
                        
                            """.trimIndent()
                )
                buffer.append(
                    """
                        NAME: ${res.getString(3)}
                        
                            """.trimIndent()
                )
                buffer.append(
                    """
                        PHONE: ${res.getString(4)}
                        
                            """.trimIndent()
                )
                buffer.append(
                    """
                        ADDRESS: ${res.getString(5)}
                        
                            """.trimIndent()
                )
                buffer.append(
                        """
                        GENDER: ${res.getString(0)}
                        
                            """.trimIndent()
                        )
            }
            ShowMessage("데이터", buffer.toString())
        })
    }
    fun ShowMessage(title: String?, Message: String?) {
        val builder = AlertDialog.Builder(this)
        builder.setCancelable(true)
        builder.setTitle(title)
        builder.setMessage(Message)
        builder.show()
    }
}