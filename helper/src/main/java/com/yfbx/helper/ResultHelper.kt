@file:Suppress("unused")

package com.yfbx.helper

import android.content.Context
import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment

/**
 * Author: Edward
 * Date: 2020-06-02
 * Description:
 */


/**
 * Start Activity for result with args.
 */
inline fun <reified T> Context.launchFor(
    vararg param: Pair<String, Any?>,
    noinline callback: (ActivityResult) -> Unit
) {
    launchFor(Intent(this, T::class.java).fillArgs(param), callback)
}

/**
 * Start Activity for result simply with target Activity(without args.)
 */
inline fun <reified T> Context.launchFor(noinline callback: (ActivityResult) -> Unit) {
    launchFor(Intent(this, T::class.java), callback)
}


fun Context.launchFor(intent: Intent, callback: (ActivityResult) -> Unit) {
    val resultContracts = ActivityResultContracts.StartActivityForResult()
    val resultCallback = ActivityResultCallback<ActivityResult> { result ->
        callback.invoke(result ?: ActivityResult(-2, null))
    }
    when (this) {
        is ComponentActivity -> {
            registerForActivityResult(resultContracts, resultCallback).launch(intent)
        }
        is Fragment -> {
            registerForActivityResult(resultContracts, resultCallback).launch(intent)
        }
        else -> {
            throw IllegalArgumentException("Context must be ComponentActivity or Fragment")
        }
    }
}