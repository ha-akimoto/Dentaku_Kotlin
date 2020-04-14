package com.example.dentaku_kotlin.ui.main

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.dentaku_kotlin.R
import com.example.dentaku_kotlin.common.Calculation
import com.example.dentaku_kotlin.common.Constants
import com.example.dentaku_kotlin.common.OperatorFlg

class MainViewModel(application: Application) : AndroidViewModel(application) {
    var text : MutableLiveData<String> = MutableLiveData()
    var sb: StringBuilder = StringBuilder()
    var opeFlg : MutableLiveData<OperatorFlg> = MutableLiveData()
    var equalFlg : MutableLiveData<Boolean> = MutableLiveData()
    var dotFlg : MutableLiveData<Boolean> = MutableLiveData()
    var opeEnableFlg : MutableLiveData<Boolean> = MutableLiveData()

    init {
        this.opeFlg.value = OperatorFlg.DEFAULT
        this.equalFlg.value = false
        this.dotFlg.value = true
        this.opeEnableFlg.value = false
    }

    fun onClickNumber(number: Char) {
        this.sb.append(number)
        this.text.value = this.sb.toString()
        flgSet()
    }

    fun onClickOperator(view: View) {
        when (view.id) {
            R.id.button_plus -> {
                this.sb.append(Constants.PLUS)
                this.opeFlg.value = OperatorFlg.PLUS
            }
            R.id.button_minus -> {
                this.sb.append(Constants.MINUS)
                this.opeFlg.value = OperatorFlg.MINUS
            }
            R.id.button_times -> {
                this.sb.append(Constants.TIMES)
                this.opeFlg.value = OperatorFlg.TIMES
            }
            R.id.button_divided -> {
                this.sb.append(Constants.DIVIDED)
                this.opeFlg.value = OperatorFlg.DIVIDED
            }
        }
        this.text.value = this.sb.toString()
        this.dotFlg.value = true
        this.opeEnableFlg.value = false
    }

    fun onClickDot() {
        this.sb.append(".")
        this.text.value = this.sb.toString()
        this.dotFlg.value = false
    }

    fun onClickClear() {
        this.sb.clear()
        this.text.value = null
        this.opeFlg.value = OperatorFlg.DEFAULT
        this.dotFlg.value = true
        this.equalFlg.value = false
        this.opeEnableFlg.value = false
    }

    fun onClickEqual() {
        executeCalculation()
        this.opeFlg.value = OperatorFlg.DEFAULT
        this.sb.clear()
        this.dotFlg.value = true
        this.equalFlg.value = false
        this.opeEnableFlg.value = false
    }

    private fun flgSet() {
        // オペレータフラグがデフォルトの場合
        if (this.opeFlg.value == OperatorFlg.DEFAULT) {
            this.opeEnableFlg.value = true
        } else {
            this.equalFlg.value = true
        }
    }

    private fun executeCalculation() {

        when (this.opeFlg.value) {
            OperatorFlg.PLUS -> {
                this.text.value = Calculation.calPlus(this.sb)
            }
            OperatorFlg.MINUS -> {
                this.text.value = Calculation.calMinus(this.sb)
            }
            OperatorFlg.TIMES -> {
                this.text.value = Calculation.calTimes(this.sb)
            }
            OperatorFlg.DIVIDED -> {
                this.text.value = Calculation.calDivided(this.sb)
            }
        }
        // 小数点以下が０の場合は削除する
        this.text.value = Calculation.zeroCut(this.text.value!!)

    }

}
