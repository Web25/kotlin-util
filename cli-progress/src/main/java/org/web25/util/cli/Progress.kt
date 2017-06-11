package org.web25.util.cli

import org.web25.util.os.onOS

/**
 * Created by felix on 6/8/17.
 */

class Progress(val name: String, var progress: Double = 0.0, val max: Double = 100.0, val layout: ProgressLayout = Layouts.ZYPPER) {

    private var spinnerIndex = 0

    fun print() {
        Console.clearLine()
        val total = Console.width - name.length - layout.additionalCharacters
        val progress = (total.toDouble() * (progress / max)).toInt()
        val rest = total - progress
        val progressString = layout.progress * progress
        val restString = layout.empty * rest
        if(layout.spinnerChars != null) {
            print(String.format(layout.layout, name, progressString, restString, layout.spinnerChars[spinnerIndex], this.progress.toInt()))
            spinnerIndex = (spinnerIndex + 1).rem(layout.spinnerChars.size)
        } else {
            print(String.format(layout.layout, name, progressString, restString, ' ', this.progress))
        }
    }
}

private operator fun  Char.times(times: Int): String {
    val builder = StringBuilder()
    for(i in 1..times) {
        builder.append(this)
    }
    return builder.toString()
}

object Layouts {
    val ZYPPER = ProgressLayout(progress = '.', empty = '=', spinnerChars = charArrayOf('|', '/', '-', '\\'), layout = "%1\$s %2\$s%3\$s[%4\$c]", additionalCharacters = 5)
}

/**
 * Creates a new progress layout that can be used to generate a progress bar
 *
 * This is the order in which the arguments of layout are added:
 *
 * 1 - name (the name of the job)
 * 2 - a string with the amount of progress chars that correspond to the progress
 * 3 - a string of the empty characters
 * 4 - the spinner character
 * 5 - the current progress
 */
class ProgressLayout(val progress: Char, val empty: Char, val layout: String, val spinnerChars: CharArray? = null, val additionalCharacters: Int = 0) {



}