package com.example.crystalball

import android.content.Context

class CrystalBallController(private val context: Context) {
     fun getReto(): String {
        return context.resources.getStringArray(R.array.retos)[randomNumber()]
    }

    private fun randomNumber(): Int {
        val size = context.resources.getStringArray(R.array.retos).size - 1
        return (0..size).random()
    }
}