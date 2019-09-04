package com.kotlin.homecreditindonesia.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.kotlin.homecreditindonesia.R
import com.kotlin.homecreditindonesia.adapter.AdapterMenuAtas
import com.kotlin.homecreditindonesia.adapter.AdapterMenuBawah
import com.kotlin.homecreditindonesia.databinding.ActivityMainBinding
import com.kotlin.homecreditindonesia.network.InitRetrofit
import com.kotlin.homecreditindonesia.viewmodel.HomeViewModel
import org.jetbrains.anko.ctx
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: HomeViewModel
    private lateinit var mainBinding: ActivityMainBinding
    private var mAdapterProduct: AdapterMenuAtas? = null
    private var mAdapterArticle: AdapterMenuBawah? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )
        viewModel = HomeViewModel()
        mainBinding.viewModel = viewModel
        setSupportActionBar(mainBinding.toolbarMain)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        viewModel.initData(InitRetrofit().instance())
        refreshPage()
        mainBinding.listMenuAtas.setHasFixedSize(true)
        mainBinding.listMenuBawah.setHasFixedSize(true)
        mainBinding.listMenuAtas.layoutManager = GridLayoutManager(applicationContext, 3)
        mainBinding.listMenuBawah.layoutManager = LinearLayoutManager(applicationContext)
    }

    private fun refreshPage() {
        viewModel.mLiveDataProduct.observe(this, Observer {
            it.let {
                mAdapterProduct = AdapterMenuAtas(it, ctx) {
                    startActivity<WebViewActivity>("data" to "${it.link}")
                }
                mainBinding.listMenuAtas.adapter = mAdapterProduct
            }
        })
        viewModel.mLiveDataArticle.observe(this, Observer {
            it.let {
                mAdapterArticle = AdapterMenuBawah(it, ctx) {
                    startActivity<WebViewActivity>("data" to "${it.link}")
                }
                mainBinding.listMenuBawah.adapter = mAdapterArticle
            }
        })
    }
}
