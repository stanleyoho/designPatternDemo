package com.yyds.demo1.strategys

interface CoffeeStrategy {
    fun  generateCoffee(temperatureStrategy: TemperatureStrategy):String
}