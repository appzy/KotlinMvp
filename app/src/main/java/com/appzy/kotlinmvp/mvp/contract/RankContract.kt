package com.appzy.kotlinmvp.mvp.contract

import com.appzy.kotlinmvp.base.IBaseView
import com.appzy.kotlinmvp.base.IPresenter
import com.appzy.kotlinmvp.mvp.model.bean.HomeBean

/**
 * Created by appzy on 2017/11/30.
 * desc: 契约类
 */
interface RankContract {

    interface View:IBaseView{
        /**
         * 设置排行榜的数据
         */
        fun setRankList(itemList: ArrayList<HomeBean.Issue.Item>)

        fun showError(errorMsg:String,errorCode:Int)
    }


    interface Presenter:IPresenter<View>{
        /**
         * 获取 TabInfo
         */
        fun requestRankList(apiUrl:String)
    }
}