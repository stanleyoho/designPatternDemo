package com.yyds.demo1.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yyds.demo1.context.Coffee
import com.yyds.demo1.models.*
import com.yyds.demo1.strategys.CoffeeStrategy
import com.yyds.demo1.strategys.TemperatureStrategy

class CoffeeStationViewModel : ViewModel(){

    private val _isSelectedAmericano : MutableLiveData<Boolean> = MutableLiveData(false)
    val isSelectedAmericano : LiveData<Boolean>
        get() = _isSelectedAmericano

    private val _isSelectedCappuccino : MutableLiveData<Boolean> = MutableLiveData(false)
    val isSelectedCappuccino : LiveData<Boolean>
        get() = _isSelectedCappuccino

    private val _isSelectedMocha : MutableLiveData<Boolean> = MutableLiveData(false)
    val isSelectedMocha : LiveData<Boolean>
        get() = _isSelectedMocha

    private val _isHot : MutableLiveData<Boolean> = MutableLiveData(false)
    val isHot : LiveData<Boolean>
        get() = _isHot

    private val _isCold : MutableLiveData<Boolean> = MutableLiveData(false)
    val isCold : LiveData<Boolean>
        get() = _isCold

    private val _result : MutableLiveData<String> = MutableLiveData("")
    val result : LiveData<String>
        get() = _result

    var strategy : CoffeeStrategy? = null
    var temperatureStrategy: TemperatureStrategy? = null
    fun selectAmericano(){
        strategy = Americano()
        _isSelectedAmericano.value = true
        _isSelectedCappuccino.value = false
        _isSelectedMocha.value = false
    }

    fun selectCappuccino(){
        strategy = Cappuccino()
        _isSelectedAmericano.value = false
        _isSelectedCappuccino.value = true
        _isSelectedMocha.value = false
    }

    fun selectMocha(){
        strategy = Mocha()
        _isSelectedAmericano.value = false
        _isSelectedCappuccino.value = false
        _isSelectedMocha.value = true
    }

    fun selectHot(){
        temperatureStrategy = Hot()
        _isHot.value = true
        _isCold.value = false
    }

    fun selectIce(){
        temperatureStrategy = Ice()
        _isHot.value = false
        _isCold.value = true
    }

    fun generateResult(){
        val coffee = Coffee(strategy,temperatureStrategy)
        _result.value = coffee.strategyCoffee()
    }
}


