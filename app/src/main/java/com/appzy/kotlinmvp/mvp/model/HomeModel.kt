package com.appzy.kotlinmvp.mvp.model

import com.appzy.kotlinmvp.mvp.model.bean.HomeBean
import com.appzy.kotlinmvp.net.RetrofitManager
import com.appzy.kotlinmvp.rx.scheduler.SchedulerUtils
import io.reactivex.Observable

/**
 * Created by appzy on 2017/11/21.
 * desc: 首页精选 model
 */

class HomeModel{

    /**
     * 获取首页 Banner 数据
     */
    fun requestHomeData(num:Int):Observable<HomeBean>{
        return RetrofitManager.service.getFirstHomeData(num)
                .compose(SchedulerUtils.ioToMain())
    }

    /**
     * 加载更多
     */
    fun loadMoreData(url:String):Observable<HomeBean>{

        return RetrofitManager.service.getMoreHomeData(url)
                .compose(SchedulerUtils.ioToMain())
    }



}
