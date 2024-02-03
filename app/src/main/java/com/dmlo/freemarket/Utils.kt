package com.dmlo.freemarket

import java.math.BigDecimal
import java.math.RoundingMode

fun BigDecimal.formatToMoney(): String {
    val amount = this.setScale(2, RoundingMode.HALF_EVEN)
    return "R$ $amount".replace(".", ",")
}