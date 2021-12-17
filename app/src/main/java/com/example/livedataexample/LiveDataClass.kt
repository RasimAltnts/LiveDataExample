package com.example.livedataexample

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class LiveDataClass() {
    var rand1Number:Double = 0.0;
    var rand2Number:Double = 0.0;

    //SumLiveData is initializer in here..
    //It hold data of type Double...
    val sumLiveData: MutableLiveData<Double> by lazy {
        MutableLiveData<Double>()
    }

    //getnumber is a flow.
    //Flow is a channel. This channel make cominication to between different thread.
    val getNumber=flow<Any>{
        while (true){
            //sumNumber is a suspend fun.
                //This function takes place in background
            sumNumber()
            delay(10000L)
        }
    }

    suspend fun sumNumber(){
        getNumber()
        //
        sumLiveData.postValue(rand1Number+rand2Number)
    }


    suspend fun getNumber(){
        val rand1 = (0..100).random()
        val rand2 = (0..100).random()
        rand1Number = rand1.toDouble()
        rand2Number = rand2.toDouble()
    }


}
