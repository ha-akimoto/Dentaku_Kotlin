package com.example.dentaku_kotlin.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.dentaku_kotlin.R
import com.example.dentaku_kotlin.common.Calculation
import com.example.dentaku_kotlin.common.Constants
import com.example.dentaku_kotlin.common.OperatorFlg
import com.example.dentaku_kotlin.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding
    //private val sb: StringBuilder = java.lang.StringBuilder()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // ViewModel呼び出し
        this.viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // データバインディング設定
        this.binding = DataBindingUtil.inflate(
            inflater, R.layout.main_fragment, container,
            false
        )
        this.binding.viewModel = viewModel
        this.binding.defaultFlg = OperatorFlg.DEFAULT
        this.binding.lifecycleOwner = this

        // リスナー設定
        this.binding.button0.setOnClickListener {
            this.viewModel.sb.value!!.append("0")
            this.viewModel.sbToText()
            flgSet()
        }
        this.binding.button1.setOnClickListener {
            this.viewModel.sb.value!!.append("1")
            this.viewModel.sbToText()
            flgSet()
        }
        this.binding.button2.setOnClickListener {
            this.viewModel.sb.value!!.append("2")
            this.viewModel.sbToText()
            flgSet()
        }
        this.binding.button3.setOnClickListener {
            this.viewModel.sb.value!!.append("3")
            this.viewModel.sbToText()
            flgSet()
        }
        this.binding.button4.setOnClickListener {
            this.viewModel.sb.value!!.append("4")
            this.viewModel.sbToText()
            flgSet()
        }
        this.binding.button5.setOnClickListener {
            this.viewModel.sb.value!!.append("5")
            this.viewModel.sbToText()
            flgSet()
        }
        this.binding.button6.setOnClickListener {
            this.viewModel.sb.value!!.append("6")
            this.viewModel.sbToText()
            flgSet()
        }
        this.binding.button7.setOnClickListener {
            this.viewModel.sb.value!!.append("7")
            this.viewModel.sbToText()
            flgSet()
        }
        this.binding.button8.setOnClickListener {
            this.viewModel.sb.value!!.append("8")
            this.viewModel.sbToText()
            flgSet()
        }
        this.binding.button9.setOnClickListener {
            this.viewModel.sb.value!!.append("9")
            this.viewModel.sbToText()
            flgSet()
        }
        this.binding.buttonPlus.setOnClickListener {
            this.viewModel.sb.value!!.append(Constants.PLUS)
            this.viewModel.opeFlg.value = OperatorFlg.PLUS
            this.viewModel.sbToText()
            this.viewModel.dotFlg.value = true
            this.viewModel.opeEnableFlg.value = false
        }
        this.binding.buttonMinus.setOnClickListener {
            this.viewModel.sb.value!!.append(Constants.MINUS)
            this.viewModel.opeFlg.value = OperatorFlg.MINUS
            this.viewModel.sbToText()
            this.viewModel.dotFlg.value = true
            this.viewModel.opeEnableFlg.value = false
        }
        this.binding.buttonTimes.setOnClickListener {
            this.viewModel.sb.value!!.append(Constants.TIMES)
            this.viewModel.opeFlg.value = OperatorFlg.TIMES
            this.viewModel.sbToText()
            this.viewModel.dotFlg.value = true
            this.viewModel.opeEnableFlg.value = false
        }
        this.binding.buttonDivided.setOnClickListener {
            this.viewModel.sb.value!!.append(Constants.DIVIDED)
            this.viewModel.opeFlg.value = OperatorFlg.DIVIDED
            this.viewModel.sbToText()
            this.viewModel.dotFlg.value = true
            this.viewModel.opeEnableFlg.value = false
        }
        this.binding.buttonDot.setOnClickListener {
            this.viewModel.sb.value!!.append(".")
            this.viewModel.sbToText()
            this.viewModel.dotFlg.value = false
        }
        this.binding.buttonEquals.setOnClickListener {
            executeCalculation()
            this.viewModel.opeFlg.value = OperatorFlg.DEFAULT
            this.viewModel.sb.value!!.clear()
            this.viewModel.dotFlg.value = true
            this.viewModel.equalFlg.value = false
            this.viewModel.opeEnableFlg.value = false
        }
        this.binding.buttonClear.setOnClickListener {
            this.viewModel.sb.value!!.clear()
            this.viewModel.text.value = null
            this.viewModel.opeFlg.value = OperatorFlg.DEFAULT
            this.viewModel.dotFlg.value = true
            this.viewModel.equalFlg.value = false
            this.viewModel.opeEnableFlg.value = false
        }

        return this.binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // ViewModelのテキストがNullか空文字じゃない場合
        /*
        if (!this.viewModel.text.value.isNullOrEmpty()) {
            this.viewModel.sb.value!!.append(this.viewModel.text.value)
        }

         */
    }

    private fun executeCalculation() {
        // それぞれの計算を呼び出す
        when (this.viewModel.opeFlg.value) {
            OperatorFlg.PLUS -> {
                this.viewModel.text.value = Calculation.calPlus(this.viewModel.sb.value!!)
            }
            OperatorFlg.MINUS -> {
                this.viewModel.text.value = Calculation.calMinus(this.viewModel.sb.value!!)
            }
            OperatorFlg.TIMES -> {
                this.viewModel.text.value = Calculation.calTimes(this.viewModel.sb.value!!)
            }
            OperatorFlg.DIVIDED -> {
                this.viewModel.text.value = Calculation.calDivided(this.viewModel.sb.value!!)
            }
        }
        // 小数点以下が０の場合は削除する
        this.viewModel.text.value = Calculation.zeroCut(this.viewModel.text.value!!)
    }

    private fun flgSet() {
        // オペレータフラグがデフォルトの場合
        if (this.viewModel.opeFlg.value == OperatorFlg.DEFAULT) {
            this.viewModel.opeEnableFlg.value = true
        } else {
            this.viewModel.equalFlg.value = true
        }
    }

}
