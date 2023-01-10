package com.yyds.demo1.ui

import android.os.Bundle
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.yyds.demo1.R
import com.yyds.demo1.databinding.ActivityMainBinding
import com.yyds.demo1.viewModel.CoffeeStationViewModel
import com.yyds.demo1.strategyPatternModel.Coffee
import com.yyds.demo1.strategyPatternModel.items.*
import com.yyds.demo1.strategyPatternModel.strategy.CoffeeStrategy
import com.yyds.demo1.strategyPatternModel.strategy.TemperatureStrategy

class MainActivity : AppCompatActivity() {

    private val coffeeViewModel by lazy {
        ViewModelProvider(this)[CoffeeStationViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.coffeeModel = coffeeViewModel

        binding.groupCoffeeStyle.setOnCheckedChangeListener { p0, p1 ->
            when (p1) {
                R.id.coffee_americano -> {
                    coffeeViewModel.selectAmericano()
                }
                R.id.coffee_cappuccino -> {
                    coffeeViewModel.selectCappuccino()
                }
                R.id.coffee_mocha -> {
                    coffeeViewModel.selectMocha()
                }
            }
        }

        binding.groupIsHot.setOnCheckedChangeListener { p0, p1 ->
            when(p1){
                R.id.isHot->{ coffeeViewModel.selectHot() }
                R.id.isCold->{ coffeeViewModel.selectIce() }
            }
        }

        binding.btnGenerateCoffee.setOnClickListener {
            val strategy : CoffeeStrategy
            val temperatureStrategy: TemperatureStrategy
            //get coffee selected index
            val typeCoffeeSelectedId = binding.groupCoffeeStyle.checkedRadioButtonId
            val typeCoffeeSelectedView = findViewById<RadioButton>(typeCoffeeSelectedId)
            val typeCoffeeIndex = binding.groupCoffeeStyle.indexOfChild(typeCoffeeSelectedView)
            strategy = when(typeCoffeeIndex){
                0->{ Americano() }
                1->{ Cappuccino() }
                2->{ Mocha() }
                else->{ NonCoffee() }
            }
            //get coffee temperature selected index
            val tempCoffeeSelectedId = binding.groupIsHot.checkedRadioButtonId
            val tempCoffeeSelectedView = findViewById<RadioButton>(tempCoffeeSelectedId)
            val tempCoffeeIndex = binding.groupIsHot.indexOfChild(tempCoffeeSelectedView)
            temperatureStrategy = when(tempCoffeeIndex){
                0->{ Hot() }
                1->{ Ice() }
                else->{ NonTemperature() }
            }

            val coffee = Coffee(strategy,temperatureStrategy)

            coffeeViewModel.generateResult(coffee)
        }
    }
}