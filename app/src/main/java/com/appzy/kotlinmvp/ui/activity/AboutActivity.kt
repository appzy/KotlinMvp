package com.appzy.kotlinmvp.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import com.appzy.kotlinmvp.MyApplication
import com.appzy.kotlinmvp.R
import com.appzy.kotlinmvp.base.BaseActivity
import com.appzy.kotlinmvp.utils.AppUtils
import com.appzy.kotlinmvp.utils.StatusBarUtil
import kotlinx.android.synthetic.main.activity_about.*

/**
 * Created by appzy on 2017/12/6.
 * desc: 关于
 */
class AboutActivity : BaseActivity() {
    override fun layoutId(): Int = R.layout.activity_about

    override fun initData() {
    }

    @SuppressLint("SetTextI18n")
    override fun initView() {
        StatusBarUtil.darkMode(this)
        StatusBarUtil.setPaddingSmart(this, toolbar)

        tv_version_name.text ="v${AppUtils.getVerName(MyApplication.context)}"
        //返回
        toolbar.setNavigationOnClickListener { finish() }
        //访问 GitHub
        relayout_gitHub.setOnClickListener {
            val uri = Uri.parse("https://github.com/appzy/KotlinMvp")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }

    override fun start() {

    }
}
