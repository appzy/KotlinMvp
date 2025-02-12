package com.appzy.kotlinmvp.mvp.presenter

import com.appzy.kotlinmvp.base.BasePresenter
import com.appzy.kotlinmvp.mvp.contract.CategoryContract
import com.appzy.kotlinmvp.mvp.model.CategoryModel
import com.appzy.kotlinmvp.net.exception.ExceptionHandle

/**
 * Created by appzy on 2017/11/29.
 * desc:分类的 Presenter
 */
class CategoryPresenter : BasePresenter<CategoryContract.View>(), CategoryContract.Presenter {

    private val categoryModel: CategoryModel by lazy {
        CategoryModel()
    }

    /**
     * 获取分类
     */
    override fun getCategoryData() {
        checkViewAttached()
        mRootView?.showLoading()
        val disposable = categoryModel.getCategoryData()
                .subscribe({ categoryList ->
                    mRootView?.apply {
                        dismissLoading()
                        showCategory(categoryList)
                    }
                }, { t ->
                    mRootView?.apply {
                        //处理异常
                        showError(ExceptionHandle.handleException(t),ExceptionHandle.errorCode)
                    }

                })

        addSubscription(disposable)
    }
}