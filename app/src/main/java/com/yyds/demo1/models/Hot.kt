package com.yyds.demo1.models

import com.yyds.demo1.strategys.TemperatureStrategy

class Hot: TemperatureStrategy {
    override fun getTemperature(): String {
        return "Hot"
    }
}