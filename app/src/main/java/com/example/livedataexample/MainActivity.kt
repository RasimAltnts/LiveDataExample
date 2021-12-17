package com.example.livedataexample


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.livedataexample.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var LiveData:LiveDataClass //Live Data Class is initializer in here...
    private lateinit var binding : ActivityMainBinding // Android View Binding is initalizer in here....
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        LiveData = LiveDataClass() //Live Data Class is identify in here

        //sumLiveData is LiveData.
        // Firstly observe to live data
        LiveData.sumLiveData.observe(this, Observer {
            binding.NumberTextView.text = it.toString()

        })

        GlobalScope.launch() {
            LiveData.getNumber.collect {
                delay(1000L)
            }
        }

    }

}