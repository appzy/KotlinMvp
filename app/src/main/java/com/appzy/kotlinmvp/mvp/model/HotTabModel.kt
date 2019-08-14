package com.appzy.kotlinmvp.mvp.model

import com.appzy.kotlinmvp.mvp.model.bean.TabInfoBean
import com.appzy.kotlinmvp.net.RetrofitManager
import com.appzy.kotlinmvp.rx.scheduler.SchedulerUtils
import io.reactivex.Observable

/**
 * Created by appzy on 2017/11/30.
 * desc: 热门 Model
 */
class HotTabModel {

    /**
     * 获取 TabInfo
     */
    fun getTabInfo(): Observable<TabInfoBean> {

        return RetrofitManager.service.getRankList()
                .compose(SchedulerUtils.ioToMain())
    }

}
