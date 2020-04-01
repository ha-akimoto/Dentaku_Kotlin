package com.example.dentaku_kotlin.common

class Calculation {
    companion object {
        fun calPlus(sb: StringBuilder): String {
            var textArray = sb.toString().split(Constants.PLUS)
            var x = textArray[0].toDouble()
            var y = textArray[1].toDouble()
            sb.clear()
            sb.append((x + y))
            return sb.toString()
        }

        fun calMinus(sb: StringBuilder): String{
            var textArray = sb.toString().split(Constants.MINUS)
            var x = textArray[0].toDouble()
            var y = textArray[1].toDouble()
            sb.clear()
            sb.append((x - y))
            return sb.toString()
        }

        fun calTimes(sb: StringBuilder): String{
            var textArray = sb.toString().split(Constants.TIMES)
            var x = textArray[0].toDouble()
            var y = textArray[1].toDouble()
            sb.clear()
            sb.append((x * y))
            return sb.toString()
        }

        fun calDivided(sb: StringBuilder): String{
            var textArray = sb.toString().split(Constants.DIVIDED)
            var x = textArray[0].toDouble()
            var y = textArray[1].toDouble()
            sb.clear()
            sb.append((x / y))
            return sb.toString()
        }

        fun zeroCut(text:String):String{
            // 小数点以下が０の場合、小数点以下を削除する
            return if (text.matches("^.*\\.0+$".toRegex())) {
                text.substring(0, text.indexOf("."))
            } else {
                text
            }
        }
    }
}