package ru.sumin.coroutinestart

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.sumin.coroutinestart.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel.method()
        binding.buttonLoad.setOnClickListener {
            binding.progress.isVisible = true
            binding.buttonLoad.isEnabled = false
//            val deferredCity: Deferred<String> = lifecycleScope.async {
//                val city = loadCity()
//                binding.tvLocation.text = city
//                city
//            }
//            val deferredTemp: Deferred<Int> = lifecycleScope.async {
//                val temp = loadTemperature()
//                binding.tvTemperature.text = temp.toString()
//                temp
//            }
//            lifecycleScope.launch {
//                val city = deferredCity.await()
//                val temp = deferredTemp.await()
//                Toast.makeText(this@MainActivity, "City: $city; temp: $temp", Toast.LENGTH_SHORT).show()
//                binding.progress.isVisible = false
//                binding.buttonLoad.isEnabled = true
//            }
//            loadWithoutCoroutine()
        }
    }
}
