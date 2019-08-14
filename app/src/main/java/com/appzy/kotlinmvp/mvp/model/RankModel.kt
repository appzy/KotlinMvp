package com.appzy.kotlinmvp.mvp.model

import com.appzy.kotlinmvp.mvp.model.bean.HomeBean
import com.appzy.kotlinmvp.net.RetrofitManager
import com.appzy.kotlinmvp.rx.scheduler.SchedulerUtils
import io.reactivex.Observable

/**
 * Created by appzy on 2017/11/30.
 * desc: 排行榜 Model
 */
class RankModel {

    /**
     * 获取排行榜
     */
    fun requestRankList(apiUrl:String): Observable<HomeBean.Issue> {

        return RetrofitManager.service.getIssueData(apiUrl)
                .compose(SchedulerUtils.ioToMain())
    }

}
