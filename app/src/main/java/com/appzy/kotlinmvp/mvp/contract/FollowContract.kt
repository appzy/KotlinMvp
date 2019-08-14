package com.appzy.kotlinmvp.mvp.contract

import com.appzy.kotlinmvp.base.IBaseView
import com.appzy.kotlinmvp.base.IPresenter
import com.appzy.kotlinmvp.mvp.model.bean.HomeBean

/**
 * Created by appzy on 2017/11/30.
 * desc: 契约类
 */
interface FollowContract {

    interface View : IBaseView {
        /**
         * 设置关注信息数据
         */
        fun setFollowInfo(issue: HomeBean.Issue)

        fun showError(errorMsg: String, errorCode: Int)
    }


    interface Presenter : IPresenter<View> {
        /**
         * 获取List
         */
        fun requestFollowList()

        /**
         * 加载更多
         */
        fun loadMoreData()
    }
}