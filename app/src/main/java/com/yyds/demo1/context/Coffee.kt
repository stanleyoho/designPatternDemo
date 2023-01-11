package com.yyds.demo1.context

import com.yyds.demo1.strategys.CoffeeStrategy
import com.yyds.demo1.strategys.TemperatureStrategy

class Coffee(val strategy: CoffeeStrategy?, val temperatureStrategy: TemperatureStrategy?) {

    fun strategyCoffee():String{
        val type = strategy?.generateCoffee()?:"NONE"
        val temp = temperatureStrategy?.getTemperature()?:"NONE"

        return "$temp $type"
    }
}