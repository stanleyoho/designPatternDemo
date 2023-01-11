package com.yyds.demo1.ui

import android.os.Bundle
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.yyds.demo1.R
import com.yyds.demo1.databinding.ActivityMainBinding
import com.yyds.demo1.viewModel.CoffeeStationViewModel
import com.yyds.mylibrary.MyLogUtils

class MainActivity : AppCompatActivity() {

    private val coffeeViewModel by lazy {
        ViewModelProvider(this)[CoffeeStationViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.coffeeModel = coffeeViewModel

        binding.groupCoffeeStyle.setOnCheckedChangeListener(myCoffeeCheckChangeListener)
        binding.groupIsHot.setOnCheckedChangeListener(myCoffeeTemperatureCheckChangeListener)

        binding.btnGenerateCoffee.setOnClickListener {
            coffeeViewModel.generateResult()
        }

        MyLogUtils().logDebug()
    }

    private val myCoffeeCheckChangeListener = RadioGroup.OnCheckedChangeListener { p0, p1 ->
        when (p1) {
            R.id.coffee_americano -> { coffeeViewModel.selectAmericano() }
            R.id.coffee_cappuccino -> { coffeeViewModel.selectCappuccino() }
            R.id.coffee_mocha -> { coffeeViewModel.selectMocha() }
        }
    }

    private val myCoffeeTemperatureCheckChangeListener = RadioGroup.OnCheckedChangeListener { p0, p1 ->
        when(p1){
            R.id.isHot->{ coffeeViewModel.selectHot() }
            R.id.isCold->{ coffeeViewModel.selectIce() }
        }
    }
}