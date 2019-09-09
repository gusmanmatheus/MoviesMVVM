package com.example.movies.dependences

object Util {

    fun datePatterBr(date: String): String {
        if (!date.contains("-")) {
            return date
        }
        val dateBr = date.split("-")
        return "${dateBr[2]}/${dateBr[1]}/${dateBr[0]}"
    }
}
