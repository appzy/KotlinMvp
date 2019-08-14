package com.appzy.kotlinmvp.ui.activity

import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import android.support.v4.content.ContextCompat
import android.support.v4.widget.NestedScrollView
import android.webkit.WebView
import android.webkit.WebViewClient
import com.appzy.kotlinmvp.R
import com.appzy.kotlinmvp.base.BaseActivity
import com.appzy.kotlinmvp.utils.CleanLeakUtils
import com.appzy.kotlinmvp.utils.StatusBarUtil
import com.scwang.smartrefresh.layout.api.RefreshHeader
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener
import com.scwang.smartrefresh.layout.util.DensityUtil
import kotlinx.android.synthetic.main.activity_profile_homepage.*
import java.util.*

/**
 * Created by appzy on 2017/12/6.
 * desc: 个人主页
 */

class ProfileHomePageActivity : BaseActivity() {


    private var mOffset = 0
    private var mScrollY = 0
    private var mRawBitmap: BitmapFactory? = null

    private var 𓃟 ="初级"
    private var 𓃟𓃟="中级"
    private var 𓃟𓃟𓃟="高级"
    private var 𓃟𓃟𓃟𓃟="专家"

    override fun layoutId(): Int = R.layout.activity_profile_homepage

    override fun initData() {

    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun initView() {
        //状态栏透明和间距处理
        StatusBarUtil.darkMode(this)
        StatusBarUtil.setPaddingSmart(this, toolbar)

        refreshLayout.setOnMultiPurposeListener(object : SimpleMultiPurposeListener() {
            override fun onHeaderPulling(header: RefreshHeader?, percent: Float, offset: Int, bottomHeight: Int, extendHeight: Int) {
                mOffset = offset / 2
                parallax.translationY = (mOffset - mScrollY).toFloat()
                toolbar.alpha = 1 - Math.min(percent, 1f)
            }

            override fun onHeaderReleasing(header: RefreshHeader?, percent: Float, offset: Int, bottomHeight: Int, extendHeight: Int) {
                mOffset = offset / 2
                parallax.translationY = (mOffset - mScrollY).toFloat()
                toolbar.alpha = 1 - Math.min(percent, 1f)
            }
        })
        scrollView.setOnScrollChangeListener(object : NestedScrollView.OnScrollChangeListener {
            private var lastScrollY = 0
            private val h = DensityUtil.dp2px(170f)
            private val color = ContextCompat.getColor(applicationContext, R.color.colorPrimary) and 0x00ffffff
            override fun onScrollChange(v: NestedScrollView, scrollX: Int, scrollY: Int, oldScrollX: Int, oldScrollY: Int) {
                var tScrollY= scrollY
                if (lastScrollY < h) {
                    tScrollY = Math.min(h, tScrollY)
                    mScrollY = if (tScrollY > h) h else tScrollY
                    buttonBarLayout.alpha = 1f * mScrollY / h
                    toolbar.setBackgroundColor(255 * mScrollY / h shl 24 or color)
                    parallax.translationY = (mOffset - mScrollY).toFloat()
                }
                lastScrollY = tScrollY
            }
        })
        buttonBarLayout.alpha = 0f
        toolbar.setBackgroundColor(0)
         //返回
        toolbar.setNavigationOnClickListener { finish() }


        refreshLayout.setOnRefreshListener {  mWebView.loadUrl("https://appzy.vip") }
        refreshLayout.autoRefresh()

        mWebView.settings.javaScriptEnabled = true
        mWebView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                view.loadUrl(url)
                return true
            }

            override fun onPageFinished(view: WebView, url: String) {
                super.onPageFinished(view, url)
                refreshLayout.finishRefresh()
                view.loadUrl(String.format(Locale.CHINA, "javascript:document.body.style.paddingTop='%fpx'; void 0", DensityUtil.px2dp(mWebView.paddingTop.toFloat())))
            }
        }

    }

    override fun start() {

    }

    override fun onDestroy() {
        CleanLeakUtils.fixInputMethodManagerLeak(this)
        super.onDestroy()
    }
}
