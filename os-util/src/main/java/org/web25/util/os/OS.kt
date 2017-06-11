package org.web25.util.os

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * Created by felix on 6/8/17.
 */

val osname by lazy {
    System.getProperty("os.name").toLowerCase()
}

fun <T> onOS(windows: (() -> T)? = null, linux: (() -> T)? = null, mac: (() -> T)? = null, other: ((name: String) -> T)? = null): T? {

    when(osname) {
        "linux" -> {
            return linux?.invoke()
        }
    }

    return null
}

fun exec(vararg cmd: String): String {

    val process = Runtime.getRuntime().exec(cmd)
    val reader = BufferedReader(InputStreamReader(process.inputStream))

    return reader.readLine()!!
}