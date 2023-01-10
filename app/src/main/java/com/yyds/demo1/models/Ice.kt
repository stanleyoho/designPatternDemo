package com.yyds.demo1.models

import com.yyds.demo1.strategys.TemperatureStrategy

class Ice: TemperatureStrategy {
    override fun getTemperature(): String {
        return "Ice"
    }
}