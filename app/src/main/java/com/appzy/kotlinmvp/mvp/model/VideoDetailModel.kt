package com.appzy.kotlinmvp.mvp.model

import com.appzy.kotlinmvp.mvp.model.bean.HomeBean
import com.appzy.kotlinmvp.net.RetrofitManager
import com.appzy.kotlinmvp.rx.scheduler.SchedulerUtils
import io.reactivex.Observable

/**
 * Created by appzy on 2017/11/25.
 * desc:
 */
class VideoDetailModel {

    fun requestRelatedData(id:Long):Observable<HomeBean.Issue>{

        return RetrofitManager.service.getRelatedData(id)
                .compose(SchedulerUtils.ioToMain())
    }

}