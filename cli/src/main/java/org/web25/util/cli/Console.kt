package org.web25.util.cli

import org.web25.util.os.onOS

/**
 * Created by felix on 6/8/17.
 */

object Console {

    var width: Int
    get() {
        return onOS(linux = {
            val width : String? = System.getenv("WIDTH")
            width?.toInt() ?: 80
        }) ?: 80
    }
    set(value) {

    }

    fun clearLine() {
        onOS ( linux = {
            print("\u001b[2K\r")
        })
    }

}