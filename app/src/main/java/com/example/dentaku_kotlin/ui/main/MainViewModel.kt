package com.example.dentaku_kotlin.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dentaku_kotlin.common.OperatorFlg
import java.lang.StringBuilder

class MainViewModel(application: Application) : AndroidViewModel(application)  {
    var text : MutableLiveData<String> = MutableLiveData()
    var sb: MutableLiveData<StringBuilder> = MutableLiveData()
    var opeFlg : MutableLiveData<OperatorFlg> = MutableLiveData()
    var equalFlg : MutableLiveData<Boolean> = MutableLiveData()
    var dotFlg : MutableLiveData<Boolean> = MutableLiveData()
    var opeEnableFlg : MutableLiveData<Boolean> = MutableLiveData()
    init {
        this.sb.value = StringBuilder()
        this.opeFlg.value = OperatorFlg.DEFAULT
        this.equalFlg.value = false
        this.dotFlg.value = true
        this.opeEnableFlg.value = false
    }

    fun sbToText() {
        this.text.value = this.sb.value.toString()
    }

}
