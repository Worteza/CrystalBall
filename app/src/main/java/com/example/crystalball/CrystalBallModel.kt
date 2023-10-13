package com.example.crystalball

import android.content.Context
import android.os.CountDownTimer
import android.os.Looper
import android.view.View
import com.example.crystalball.databinding.ActivityMainBinding
import kotlin.math.ceil

class CrystalBallModel(private val context: Context, private val binding: ActivityMainBinding) {
    private var timer: CountDownTimer? = null
    private val crystalBallController = CrystalBallController(context)
    private val delayFinish: Long = 1000L
    private val questionDelay: Long = 2500L
    private val question: String = "Ask a question"
    private val finishWord: String = "Finish"
    private val waitingProcessList = mutableListOf(
        WaitingTime.PREDICTING_THE_FUTURE.getProcess(),
        WaitingTime.GOING_TO_THE_GADALKA.getProcess(),
        WaitingTime.ASKING_THE_SPIRITS.getProcess(),
        WaitingTime.LISTENING_TO_THE_STARS.getProcess(),
        WaitingTime.GET_AN_ANSWER.getProcess()
    )

    fun startCountDownTimer(timeMillis: Long){
        timer?.cancel()
        var processIndex = 0

        timer = object : CountDownTimer(timeMillis, 1000){
            override fun onTick(timeM: Long) {
                binding.tvTimer.text = ceil((timeM.toDouble()/1000)).toInt().toString()
                if (processIndex < waitingProcessList.size) {
                    binding.predView.text = waitingProcessList[processIndex]
                    processIndex++
                }
            }

            override fun onFinish() {
                binding.tvTimer.text = finishWord
                val handler = android.os.Handler(Looper.getMainLooper())
                handler.postDelayed({
                    binding.tvTimer.visibility = View.INVISIBLE
                    binding.predView.text = crystalBallController.getReto()
                }, delayFinish)
                handler.postDelayed({
                    binding.predView.text = question
                    binding.bAsk.visibility = View.VISIBLE
                }, questionDelay)
            }
        }.start()
    }
}