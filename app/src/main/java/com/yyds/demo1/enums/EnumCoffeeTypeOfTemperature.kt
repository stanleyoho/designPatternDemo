package com.yyds.demo1.enums

enum class EnumCoffeeTypeOfTemperature(val typeId:Int, val typeString:String){
    NONE(-1, "NONE"),
    HOT(0, "HOT"),
    ICE(1, "ICE");

    companion object{
        fun getTypeString(typeId: Int):String{
            return when(typeId) {
                HOT.typeId->{ HOT.typeString }
                ICE.typeId ->{ ICE.typeString }
                else->{ NONE.typeString }
            }
        }
    }
}