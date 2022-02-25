package org.mozilla.fenix.analytics

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log

class EventTracker private constructor(private val context: Context) {

    companion object {

        @Volatile private var INSTANCE: EventTracker? = null

        fun getInstance(context: Context): EventTracker =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: EventTracker(context).also { INSTANCE = it }
            }
    }

    fun log(message: String) {
        val className = context.applicationInfo.className
        Log.d("EventTracker", "$message from $className")
    }
}