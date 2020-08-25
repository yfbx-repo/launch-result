package com.yfbx.demo

import android.Manifest
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.yfbx.helper.launchFor
import com.yfbx.helper.permissionFor
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener {
            launchFor<TestActivity>("key" to "MainActivity") {
                toast("resultCode = ${it.resultCode},data = ${it.data.toString()}")
            }
        }

        btn2.setOnClickListener {
            permissionFor(Manifest.permission.WRITE_EXTERNAL_STORAGE) {
                toast("permission ${if (it) "granted" else "denied"}")
            }
        }
    }


    private fun toast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}