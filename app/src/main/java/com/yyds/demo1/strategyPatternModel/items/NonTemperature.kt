package com.yyds.demo1.strategyPatternModel.items

import com.yyds.demo1.strategyPatternModel.strategy.TemperatureStrategy

class NonTemperature: TemperatureStrategy {
    override fun getTemperature(): String {
        return "None Temperature"
    }
}