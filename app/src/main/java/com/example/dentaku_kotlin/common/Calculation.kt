package com.example.dentaku_kotlin.common

object Calculation {

    fun calPlus(sb: StringBuilder): String {
        val textArray = sb.toString().split(Constants.PLUS)
        val x = textArray[0].toDouble()
        val y = textArray[1].toDouble()
        sb.clear()
        sb.append((x + y))
        return sb.toString()
    }

    fun calMinus(sb: StringBuilder): String {
        val textArray = sb.toString().split(Constants.MINUS)
        val x = textArray[0].toDouble()
        val y = textArray[1].toDouble()
        sb.clear()
        sb.append((x - y))
        return sb.toString()
    }

    fun calTimes(sb: StringBuilder): String {
        val textArray = sb.toString().split(Constants.TIMES)
        val x = textArray[0].toDouble()
        val y = textArray[1].toDouble()
        sb.clear()
        sb.append((x * y))
        return sb.toString()
    }

    fun calDivided(sb: StringBuilder): String {
        val textArray = sb.toString().split(Constants.DIVIDED)
        val x = textArray[0].toDouble()
        val y = textArray[1].toDouble()
        sb.clear()
        sb.append((x / y))
        return sb.toString()
    }

    fun zeroCut(text: String): String {
        // 小数点以下が０の場合、小数点以下を削除する
        return if (text.matches("^.*\\.0+$".toRegex())) {
            text.substring(0, text.indexOf("."))
        } else {
            text
        }
    }

}