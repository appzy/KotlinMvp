package com.hazz.kotlinmvp.mvp.presenter

import android.util.Log

import com.hazz.kotlinmvp.base.BasePresenter
import com.hazz.kotlinmvp.mvp.contract.FollowContract
import com.hazz.kotlinmvp.mvp.contract.HomeContract

/**
 * 主要功能：
 * create by appzy on 2019-07-25
 * 修订历史：
 */
class javac : FollowContract.Presenter {

    override fun requestFollowList() {
        Log.i("", "11111111")
    }

    override fun loadMoreData() {
        for (i in 1..10) {
            if (i > 2) {
                Log.i("大于2", "" + i)
            }
        }

    }

    override fun attachView(mRootView: FollowContract.View) {
        Log.i("", "11111111")

    }

    override fun detachView() {

    }
}
