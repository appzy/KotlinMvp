package com.appzy.kotlinmvp.mvp.contract

import com.appzy.kotlinmvp.base.IBaseView
import com.appzy.kotlinmvp.base.IPresenter
import com.appzy.kotlinmvp.mvp.model.bean.HomeBean

/**
 * Created by appzy on 2017/11/30.
 * desc: 分类详情契约类
 */
interface CategoryDetailContract {

    interface View:IBaseView{
        /**
         *  设置列表数据
         */
        fun setCateDetailList(itemList:ArrayList<HomeBean.Issue.Item>)

        fun showError(errorMsg:String)




    }

    interface Presenter:IPresenter<View>{

        fun getCategoryDetailList(id:Long)

        fun loadMoreData()
    }
}