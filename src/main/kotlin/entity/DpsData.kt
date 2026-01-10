package com.tbread.entity

import kotlinx.serialization.Serializable

@Serializable
data class DpsData(val map:HashMap<String,Double> = HashMap()){
}

