package com.zhangrenwen.kotlinui.utils

fun String.lettersCount(): Int {
    var count = 0
    for (char in this) {
        if (char.isLetter()) {
            count++
        }

    }
    return count
}

operator fun String.times(n: Int) = this.repeat(n)