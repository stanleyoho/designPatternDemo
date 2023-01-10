package com.yyds.demo1.ui

import android.os.Bundle
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.yyds.demo1.R
import com.yyds.demo1.databinding.ActivityMainBinding
import com.yyds.demo1.enums.EnumCoffeeType
import com.yyds.demo1.enums.EnumCoffeeTypeOfTemperature
import com.yyds.demo1.model.Coffee
import com.yyds.demo1.viewModel.CoffeeStationViewModel

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
            val typeCoffeeSelectedId = binding.groupCoffeeStyle.checkedRadioButtonId
            val typeCoffeeSelectedView = findViewById<RadioButton>(typeCoffeeSelectedId)
            val typeCoffeeIndex = binding.groupCoffeeStyle.indexOfChild(typeCoffeeSelectedView)

            val tempCoffeeSelectedId = binding.groupIsHot.checkedRadioButtonId
            val tempCoffeeSelectedView = findViewById<RadioButton>(tempCoffeeSelectedId)
            val tempCoffeeIndex = binding.groupIsHot.indexOfChild(tempCoffeeSelectedView)

            coffeeViewModel.generateResult(Coffee(typeCoffeeIndex,tempCoffeeIndex))
        }
    }
}