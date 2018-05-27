package com.sembozdemir.autoscout24.extensions

import java.math.BigDecimal
import java.text.DecimalFormat

const val DECIMAL_FORMAT_PATTERN = "###,###.##"

fun Int.asFormattedAmount(decimalFormatPattern: String = DECIMAL_FORMAT_PATTERN): String {
    val decimalFormat = DecimalFormat(decimalFormatPattern)

    return decimalFormat.format(BigDecimal(this))

}