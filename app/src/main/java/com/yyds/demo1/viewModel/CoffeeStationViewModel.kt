package com.yyds.demo1.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yyds.demo1.enums.EnumCoffeeType
import com.yyds.demo1.model.Coffee
import com.yyds.demo1.model.CoffeeStation

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

    fun selectAmericano(){
        _isSelectedAmericano.value = true
        _isSelectedCappuccino.value = false
        _isSelectedMocha.value = false
    }

    fun selectCappuccino(){
        _isSelectedAmericano.value = false
        _isSelectedCappuccino.value = true
        _isSelectedMocha.value = false
    }

    fun selectMocha(){
        _isSelectedAmericano.value = false
        _isSelectedCappuccino.value = false
        _isSelectedMocha.value = true
    }

    fun selectHot(){
        _isHot.value = true
        _isCold.value = false
    }

    fun selectIce(){
        _isHot.value = false
        _isCold.value = true
    }

    fun generateResult(coffee:Coffee){
        _result.value = CoffeeStation().generateCoffee(coffee)
    }
}


