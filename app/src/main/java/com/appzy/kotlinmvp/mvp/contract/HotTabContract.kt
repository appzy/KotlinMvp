package com.appzy.kotlinmvp.mvp.contract

import com.appzy.kotlinmvp.base.IBaseView
import com.appzy.kotlinmvp.base.IPresenter
import com.appzy.kotlinmvp.mvp.model.bean.TabInfoBean

/**
 * Created by appzy on 2017/11/30.
 * desc: 契约类
 */
interface HotTabContract {

    interface View:IBaseView{
        /**
         * 设置 TabInfo
         */
        fun setTabInfo(tabInfoBean: TabInfoBean)

        fun showError(errorMsg:String,errorCode:Int)
    }


    interface Presenter:IPresenter<View>{
        /**
         * 获取 TabInfo
         */
        fun getTabInfo()
    }
}