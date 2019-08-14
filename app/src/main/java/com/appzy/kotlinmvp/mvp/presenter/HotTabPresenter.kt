package com.appzy.kotlinmvp.mvp.presenter

import com.appzy.kotlinmvp.base.BasePresenter
import com.appzy.kotlinmvp.mvp.contract.HotTabContract
import com.appzy.kotlinmvp.mvp.model.HotTabModel
import com.appzy.kotlinmvp.net.exception.ExceptionHandle

/**
 * Created by appzy on 2017/11/30.
 * desc: 获取 TabInfo Presenter
 */
class HotTabPresenter:BasePresenter<HotTabContract.View>(),HotTabContract.Presenter {

    private val hotTabModel by lazy { HotTabModel() }


    override fun getTabInfo() {
        checkViewAttached()
        mRootView?.showLoading()
        val disposable = hotTabModel.getTabInfo()
                .subscribe({
                    tabInfo->
                    mRootView?.setTabInfo(tabInfo)
                },{
                    throwable->
                    //处理异常
                    mRootView?.showError(ExceptionHandle.handleException(throwable), ExceptionHandle.errorCode)
                })
        addSubscription(disposable)
    }
}