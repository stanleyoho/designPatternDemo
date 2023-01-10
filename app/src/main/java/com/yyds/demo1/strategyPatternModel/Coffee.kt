package com.yyds.demo1.strategyPatternModel

import com.yyds.demo1.strategyPatternModel.strategy.CoffeeStrategy
import com.yyds.demo1.strategyPatternModel.strategy.TemperatureStrategy

class Coffee(val strategy: CoffeeStrategy, val temperatureStrategy: TemperatureStrategy) {

    fun strategyCoffee():String{
        return strategy.generateCoffee(temperatureStrategy)
    }
}