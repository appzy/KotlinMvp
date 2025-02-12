package com.appzy.kotlinmvp.view.recyclerview

/**
 * Created by appzy on 2017/11/22.
 * desc: 多布局条目类型
 */

interface MultipleType<in T> {
    fun getLayoutId(item: T, position: Int): Int
}
