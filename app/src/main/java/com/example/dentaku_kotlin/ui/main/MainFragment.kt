package com.example.dentaku_kotlin.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.dentaku_kotlin.R
import com.example.dentaku_kotlin.common.OperatorFlg
import com.example.dentaku_kotlin.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding

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

        return this.binding.root
    }

}
