package com.yfbx.helper

import android.content.Context
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment

/**
 * Author: Edward
 * Date: 2020-06-28
 * Description:Request permissions
 */
fun Context.permissionFor(permission: String, callback: (isGrant: Boolean) -> Unit) {
    permissionsFor(permission) { map ->
        callback.invoke(map[permission] ?: false)
    }
}

fun Context.permissionsFor(vararg permission: String, callback: (Map<String, Boolean>) -> Unit) {
    val permissionContracts = ActivityResultContracts.RequestMultiplePermissions()
    val resultCallback = ActivityResultCallback<Map<String, Boolean>> { result ->
        callback.invoke(result ?: emptyMap())
    }
    when (this) {
        is ComponentActivity -> {
            registerForActivityResult(permissionContracts, resultCallback).launch(permission)
        }
        is Fragment -> {
            registerForActivityResult(permissionContracts, resultCallback).launch(permission)
        }
        else -> {
            throw IllegalArgumentException("Context must be ComponentActivity or Fragment")
        }
    }
}

