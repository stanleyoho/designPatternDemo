package com.yyds.demo1.strategyPatternModel.items

import com.yyds.demo1.strategyPatternModel.strategy.CoffeeStrategy
import com.yyds.demo1.strategyPatternModel.strategy.TemperatureStrategy

class Mocha: CoffeeStrategy {
    override fun generateCoffee(temperature: TemperatureStrategy):String {
        return "${temperature.getTemperature()} Mocha"
    }
}