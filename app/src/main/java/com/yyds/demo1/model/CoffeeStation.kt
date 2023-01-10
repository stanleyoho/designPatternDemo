package com.yyds.demo1.model

import com.yyds.demo1.enums.EnumCoffeeType
import com.yyds.demo1.enums.EnumCoffeeTypeOfTemperature

class CoffeeStation {
    fun generateCoffee(coffee: Coffee):String{
        val type = EnumCoffeeType.getTypeString(coffee.typeId)
        val temp = EnumCoffeeTypeOfTemperature.getTypeString(coffee.typeOfTemperatureId)
        return "$temp $type"
    }
}