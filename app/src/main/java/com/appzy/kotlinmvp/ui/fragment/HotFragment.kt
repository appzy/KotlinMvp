package com.appzy.kotlinmvp.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import com.appzy.kotlinmvp.R
import com.appzy.kotlinmvp.base.BaseFragment
import com.appzy.kotlinmvp.base.BaseFragmentAdapter
import com.appzy.kotlinmvp.mvp.contract.HotTabContract
import com.appzy.kotlinmvp.mvp.model.bean.TabInfoBean
import com.appzy.kotlinmvp.mvp.presenter.HotTabPresenter
import com.appzy.kotlinmvp.net.exception.ErrorStatus
import com.appzy.kotlinmvp.showToast
import com.appzy.kotlinmvp.utils.StatusBarUtil
import kotlinx.android.synthetic.main.fragment_hot.*

/**
 * Created by appzy on 2017/11/9.
 * 热门
 */
class HotFragment : BaseFragment(), HotTabContract.View {

    private val mPresenter by lazy { HotTabPresenter() }

    private var mTitle: String? = null

    /**
     * 存放 tab 标题
     */
    private val mTabTitleList = ArrayList<String>()

    private val mFragmentList = ArrayList<Fragment>()

    companion object {
        fun getInstance(title: String): HotFragment {
            val fragment = HotFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            fragment.mTitle = title
            return fragment
        }
    }

    init {
        mPresenter.attachView(this)
    }


    override fun getLayoutId(): Int = R.layout.fragment_hot


    override fun lazyLoad() {
        mPresenter.getTabInfo()
    }

    override fun initView() {

        mLayoutStatusView = multipleStatusView
        //状态栏透明和间距处理
        activity?.let { StatusBarUtil.darkMode(it) }
        activity?.let { StatusBarUtil.setPaddingSmart(it, toolbar) }
    }


    override fun showLoading() {
      multipleStatusView.showLoading()
    }

    override fun dismissLoading() {

    }

    /**
     * 设置 TabInfo
     */
    override fun setTabInfo(tabInfoBean: TabInfoBean) {
        multipleStatusView.showContent()

        tabInfoBean.tabInfo.tabList.mapTo(mTabTitleList) { it.name }
        tabInfoBean.tabInfo.tabList.mapTo(mFragmentList) { RankFragment.getInstance(it.apiUrl) }

        mViewPager.adapter = BaseFragmentAdapter(childFragmentManager,mFragmentList,mTabTitleList)
        mTabLayout.setupWithViewPager(mViewPager)

    }

    override fun showError(errorMsg: String,errorCode:Int) {
        showToast(errorMsg)
        if (errorCode == ErrorStatus.NETWORK_ERROR) {
            multipleStatusView.showNoNetwork()
        } else {
            multipleStatusView.showError()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }

}