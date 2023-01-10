package com.yyds.demo1.models

import com.yyds.demo1.strategys.CoffeeStrategy
import com.yyds.demo1.strategys.TemperatureStrategy

class Cappuccino: CoffeeStrategy {
    override fun generateCoffee(temperature: TemperatureStrategy):String {
        return "${temperature.getTemperature()} Cappuccino"
    }
}