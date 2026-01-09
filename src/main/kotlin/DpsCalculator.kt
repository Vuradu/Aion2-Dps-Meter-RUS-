package com.tbread

import com.tbread.entity.DpsData

interface DpsCalculator {
    fun getDps():DpsData

    fun getDetailLog():DpsData
}