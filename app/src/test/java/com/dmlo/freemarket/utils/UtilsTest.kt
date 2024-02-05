package com.dmlo.freemarket.utils

import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.math.BigDecimal

class UtilsTest {

    @Test
    fun callFormatMoney_andReturnBRLFormat() {
        assertEquals(
            BigDecimal(1500).formatToMoney(),
            "R$ 1500,00"
        )
    }
}
