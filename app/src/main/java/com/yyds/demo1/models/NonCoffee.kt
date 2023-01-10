package com.yyds.demo1.models

import com.yyds.demo1.strategys.CoffeeStrategy
import com.yyds.demo1.strategys.TemperatureStrategy

class NonCoffee: CoffeeStrategy {
    override fun generateCoffee(temperatureStrategy: TemperatureStrategy): String {
        return "${temperatureStrategy.getTemperature()} NonCoffee"
    }
}