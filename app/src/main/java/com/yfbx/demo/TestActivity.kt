package com.yfbx.demo

import android.Manifest
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.yfbx.helper.launchFor
import com.yfbx.helper.permissionsFor
import kotlinx.android.synthetic.main.activity_test.*

/**
 * Author: Edward
 * Date: 2020-08-25
 * Description:
 */
class TestActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toast("data form MainActivity:${intent.getStringExtra("key")}")

        btn1.setOnClickListener {
            launchFor<MainActivity>("key" to "TestActivity") {
                toast("resultCode = ${it.resultCode},data = ${it.data.toString()}")
            }
        }

        btn2.setOnClickListener {
            permissionsFor(Manifest.permission.CALL_PHONE, Manifest.permission.WRITE_EXTERNAL_STORAGE) {
                if (it[Manifest.permission.CALL_PHONE] == true) {
                    //TODO
                }
                if (it[Manifest.permission.WRITE_EXTERNAL_STORAGE] == true) {
                    //TODO
                }
            }
        }
    }

    private fun toast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}