package com.aydar.bestfeed

object NavGraph {

    var id_counter = 0

    val id = id_counter++

    object dest {
        val home = id_counter++
    }

    object action {
    }
}