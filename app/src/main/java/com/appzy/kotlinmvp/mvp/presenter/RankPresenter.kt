package com.appzy.kotlinmvp.mvp.presenter

import com.appzy.kotlinmvp.base.BasePresenter
import com.appzy.kotlinmvp.mvp.contract.RankContract
import com.appzy.kotlinmvp.mvp.model.RankModel
import com.appzy.kotlinmvp.net.exception.ExceptionHandle

/**
 * Created by appzy on 2017/11/30.
 * desc: 获取 TabInfo Presenter
 */
class RankPresenter : BasePresenter<RankContract.View>(), RankContract.Presenter {

    private val rankModel by lazy { RankModel() }


    /**
     *  请求排行榜数据
     */
    override fun requestRankList(apiUrl: String) {
        checkViewAttached()
        mRootView?.showLoading()
        val disposable = rankModel.requestRankList(apiUrl)
                .subscribe({ issue ->
                    mRootView?.apply {
                        dismissLoading()
                        setRankList(issue.itemList)
                    }
                }, { throwable ->
                    mRootView?.apply {
                        //处理异常
                        showError(ExceptionHandle.handleException(throwable),ExceptionHandle.errorCode)
                    }
                })
        addSubscription(disposable)
    }
}