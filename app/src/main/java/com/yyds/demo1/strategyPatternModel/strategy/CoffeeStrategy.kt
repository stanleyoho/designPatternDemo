package com.yyds.demo1.strategyPatternModel.strategy

interface CoffeeStrategy {
    fun  generateCoffee(temperatureStrategy: TemperatureStrategy):String
}