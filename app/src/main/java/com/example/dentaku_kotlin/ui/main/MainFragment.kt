package com.example.dentaku_kotlin.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.dentaku_kotlin.R
import com.example.dentaku_kotlin.common.Calculation
import com.example.dentaku_kotlin.common.Constants
import com.example.dentaku_kotlin.common.OperatorFlg
import kotlinx.android.synthetic.main.main_fragment.*
import com.example.dentaku_kotlin.databinding.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding
    private val buf :StringBuilder = java.lang.StringBuilder()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // ViewModel呼び出し
        this.viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // データバインディング設定
        this.binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container,
            false)
        this.binding.viewModel = viewModel
        this.binding.defaultFlg = OperatorFlg.DEFAULT
        this.binding.lifecycleOwner = this

        // リスナー設定
        this.binding.button0.setOnClickListener{
            this.buf.append("0")
            this.viewModel.text.value = this.buf.toString()
            flgSet()
        }
        this.binding.button1.setOnClickListener{
            this.buf.append("1")
            this.viewModel.text.value = this.buf.toString()
            flgSet()
        }
        this.binding.button2.setOnClickListener{
            this.buf.append("2")
            this.viewModel.text.value = this.buf.toString()
            flgSet()
        }
        this.binding.button3.setOnClickListener{
            this.buf.append("3")
            this.viewModel.text.value = this.buf.toString()
            flgSet()
        }
        this.binding.button4.setOnClickListener{
            this.buf.append("4")
            this.viewModel.text.value = this.buf.toString()
            flgSet()
        }
        this.binding.button5.setOnClickListener{
            this.buf.append("5")
            this.viewModel.text.value = this.buf.toString()
            flgSet()
        }
        this.binding.button6.setOnClickListener{
            this.buf.append("6")
            this.viewModel.text.value = this.buf.toString()
            flgSet()
        }
        this.binding.button7.setOnClickListener{
            this.buf.append("7")
            this.viewModel.text.value = this.buf.toString()
            flgSet()
        }
        this.binding.button8.setOnClickListener{
            this.buf.append("8")
            this.viewModel.text.value = this.buf.toString()
            flgSet()
        }
        this.binding.button9.setOnClickListener{
            this.buf.append("9")
            this.viewModel.text.value = this.buf.toString()
            flgSet()
        }
        this.binding.buttonPlus.setOnClickListener{
            this.buf.append(Constants.PLUS)
            this.viewModel.opeFlg.value = OperatorFlg.PLUS
            this.viewModel.text.value = this.buf.toString()
            this.viewModel.dotFlg.value = true
            this.viewModel.opeEnableFlg.value = false
        }
        this.binding.buttonMinus.setOnClickListener{
            this.buf.append(Constants.MINUS)
            this.viewModel.opeFlg.value = OperatorFlg.MINUS
            this.viewModel.text.value = this.buf.toString()
            this.viewModel.dotFlg.value = true
            this.viewModel.opeEnableFlg.value = false
        }
        this.binding.buttonTimes.setOnClickListener{
            this.buf.append(Constants.TIMES)
            this.viewModel.opeFlg.value = OperatorFlg.TIMES
            this.viewModel.text.value = this.buf.toString()
            this.viewModel.dotFlg.value = true
            this.viewModel.opeEnableFlg.value = false
        }
        this.binding.buttonDivided.setOnClickListener{
            this.buf.append(Constants.DIVIDED)
            this.viewModel.opeFlg.value = OperatorFlg.DIVIDED
            this.viewModel.text.value = this.buf.toString()
            this.viewModel.dotFlg.value = true
            this.viewModel.opeEnableFlg.value = false
        }
        this.binding.buttonDot.setOnClickListener{
            this.buf.append(".")
            this.viewModel.text.value = this.buf.toString()
            this.viewModel.dotFlg.value = false
        }
        this.binding.buttonEquals.setOnClickListener{
            executeCalculation()
            this.viewModel.opeFlg.value = OperatorFlg.DEFAULT
            this.buf.clear()
            this.viewModel.dotFlg.value = true
            this.viewModel.equalFlg.value = false
            this.viewModel.opeEnableFlg.value = false
        }
        this.binding.buttonClear.setOnClickListener{
            this.buf.clear()
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
        if(!this.viewModel.text.value.isNullOrEmpty()){
            this.buf.append(this.viewModel.text.value)
        }
    }

    private fun executeCalculation(){
        // それぞれの計算を呼び出す
        if(this.viewModel.opeFlg.value == OperatorFlg.PLUS){
            this.viewModel.text.value = Calculation.calPlus(this.buf)
        } else if (this.viewModel.opeFlg.value == OperatorFlg.MINUS){
            this.viewModel.text.value = Calculation.calMinus(this.buf)
        } else if (this.viewModel.opeFlg.value == OperatorFlg.TIMES){
            this.viewModel.text.value = Calculation.calTimes(this.buf)
        } else if (this.viewModel.opeFlg.value == OperatorFlg.DIVIDED){
            this.viewModel.text.value = Calculation.calDivided(this.buf)
        }
        // 小数点以下が０の場合は削除する
        this.viewModel.text.value = Calculation.zeroCut(this.viewModel.text.value!!)
    }

    private fun flgSet(){
        // オペレータフラグがデフォルトの場合
        if(this.viewModel.opeFlg.value == OperatorFlg.DEFAULT){
            this.viewModel.opeEnableFlg.value = true
        }else{
            this.viewModel.equalFlg.value = true
        }
    }

}
