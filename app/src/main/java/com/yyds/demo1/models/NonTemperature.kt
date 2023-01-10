package com.yyds.demo1.models

import com.yyds.demo1.strategys.TemperatureStrategy

class NonTemperature: TemperatureStrategy {
    override fun getTemperature(): String {
        return "None Temperature"
    }
}