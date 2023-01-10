package com.yyds.demo1.strategyPatternModel.items

import com.yyds.demo1.strategyPatternModel.strategy.CoffeeStrategy
import com.yyds.demo1.strategyPatternModel.strategy.TemperatureStrategy

class NonCoffee: CoffeeStrategy {
    override fun generateCoffee(temperatureStrategy: TemperatureStrategy): String {
        return "${temperatureStrategy.getTemperature()} NonCoffee"
    }
}