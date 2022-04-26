package ru.sumin.coroutinestart

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class MainViewModel : ViewModel() {

    private val parentJob = Job()
    private val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        Log.d(LOG_TAG, "throwable $throwable")
    }
    private val coroutineScope = CoroutineScope(Dispatchers.Main + parentJob + exceptionHandler)

    fun method() {
        val childJob1 = coroutineScope.launch {
            delay(3000)
            Log.d(LOG_TAG , "1st coroutine finished")
        }
        val childJob2 = coroutineScope.launch {
            delay(2000)
            Log.d(LOG_TAG , "2nd coroutine finished")
        }
        val childJob3 = coroutineScope.launch {
            delay(1000)
            Log.d(LOG_TAG , "3d coroutine finished")
            error()
        }
    }

    private fun error() {
        throw RuntimeException()
    }

    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()
    }

    companion object {
        private const val LOG_TAG = "MainViewModel"
    }
}