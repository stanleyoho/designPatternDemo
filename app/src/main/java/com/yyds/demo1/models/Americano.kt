package com.yyds.demo1.models

import com.yyds.demo1.strategys.CoffeeStrategy
import com.yyds.demo1.strategys.TemperatureStrategy

class Americano : CoffeeStrategy {
    override fun generateCoffee() :String{
        return "Americano"
    }
}