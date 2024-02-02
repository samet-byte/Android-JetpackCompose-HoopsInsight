package com.sametb.hoopsinsight.util.functions


/*
* Hoops Insight.com.sametb.hoopsinsight.util.functions
* Created by SAMET BAYAT 
* on 2.02.2024 at 10:20 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

import android.annotation.SuppressLint
import com.sametb.sam_custom.SamTextFormat
import java.io.*
import java.lang.reflect.Method

object SystemProperties {
    private var failedUsingReflection = false
    private var getPropMethod: Method? = null

    @SuppressLint("PrivateApi")
    fun getProp(propName: String, defaultResult: String = ""): String {
        if (!failedUsingReflection) try {
            if (getPropMethod == null) {
                val clazz = Class.forName("android.os.SystemProperties")
                getPropMethod = clazz.getMethod("get", String::class.java, String::class.java)
            }
            return getPropMethod!!.invoke(null, propName, defaultResult) as String? ?: defaultResult
        } catch (e: Exception) {
            getPropMethod = null
            failedUsingReflection = true
        }
        var process: Process? = null
        try {
            process = Runtime.getRuntime().exec("getprop \"$propName\" \"$defaultResult\"")
            val reader = BufferedReader(InputStreamReader(process.inputStream))
            return reader.readLine()
        } catch (e: IOException) {
            SamTextFormat.create(e.message.toString()).red().print()
        } finally {
            process?.destroy()
        }
        return defaultResult
    }
}