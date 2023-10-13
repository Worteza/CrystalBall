package com.example.crystalball

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.crystalball.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val crystalBallModel: CrystalBallModel by lazy {CrystalBallModel (this, binding) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bAsk.setOnClickListener {
            binding.bAsk.visibility = View.INVISIBLE
            binding.tvTimer.visibility = View.VISIBLE
            crystalBallModel.startCountDownTimer(5000L)
        }
    }
}
