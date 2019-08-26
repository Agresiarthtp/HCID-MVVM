package com.kotlin.homecreditindonesia.activity

import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.kotlin.homecreditindonesia.R
import com.kotlin.homecreditindonesia.databinding.ActivityWebViewBinding
import com.kotlin.homecreditindonesia.viewmodel.WebViewModel

class WebViewActivity : AppCompatActivity() {
    private lateinit var webViewModel: WebViewModel
    private lateinit var webViewBinding: ActivityWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        webViewBinding = DataBindingUtil.setContentView(this, R.layout.activity_web_view)
        webViewModel = WebViewModel()
        webViewBinding.viewModel = webViewModel

        webViewBinding.webviewHome.settings.javaScriptEnabled = true
        webViewBinding.webviewHome.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                view.loadUrl("javascript:alert('success loaded')")
            }
        }
        webViewBinding.webviewHome.webChromeClient = object : WebChromeClient() {
            override fun onJsAlert(
                view: WebView,
                url: String,
                message: String,
                result: android.webkit.JsResult
            ): Boolean {
                result.confirm()
                return true
            }
        }
        val url = intent.getStringExtra("data")
        webViewBinding.webviewHome.loadUrl(url)
    }
}
