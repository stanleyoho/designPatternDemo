package com.yyds.demo1.enums

enum class EnumCoffeeType(val typeId:Int,val typeString:String ){
    NONE(-1,"NONE"),
    AMERICANO(0,"AMERICANO"),
    CAPPUCCINO(1,"CAPPUCCINO"),
    MOCHA(2,"MOCHA");

    companion object{
        fun getTypeString(typeId: Int):String{
            return when(typeId) {
                AMERICANO.typeId->{ AMERICANO.typeString }
                CAPPUCCINO.typeId->{ CAPPUCCINO.typeString }
                MOCHA.typeId ->{ MOCHA.typeString }
                else->{ NONE.typeString }
            }
        }
    }
}