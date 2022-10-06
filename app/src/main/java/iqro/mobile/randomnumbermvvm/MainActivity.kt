package iqro.mobile.randomnumbermvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import iqro.mobile.randomnumbermvvm.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collectLatest

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel :RandomNumberViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launchWhenCreated {
            viewModel.flow.collectLatest { response->
                when (response) {
                    is RandomNumberResponse.Failure -> TODO()
                    is RandomNumberResponse.Loading -> {
                        binding.progressBar.isVisible = true
                        binding.randomNumberTv.isVisible = false
                    }
                    is RandomNumberResponse.Success -> {
                        binding.progressBar.isVisible = false
                        binding.randomNumberTv.isVisible = true
                        binding.randomNumberTv.text = response.number.toString()
                    }
                }
            }
        }


        binding.generateRandomNumberBtn.setOnClickListener {
            viewModel.getRandomNumber()
        }
    }
}