package org.web25.util.cli

/**
 * Created by felix on 6/8/17.
 */

fun main(args: Array<String>) {
    val progress = Progress("test")
    for (i in 0..100) {
        progress.print()
        progress.progress = i.toDouble()
        Thread.sleep(100)
    }
    progress.print()
}