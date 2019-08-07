package com.hazz.kotlinmvp.ui.activity

import com.hazz.kotlinmvp.base.BaseActivity

/**
 * 主要功能：
 * create by appzy on 2019-08-07
 * 修订历史：
 */
class MineActivity : BaseActivity() {

    override fun layoutId(): Int {
        return 0
    }

    override fun initData() {

    }

    fun main(args: Array<String>) {
        for (i in 1..10) {
            if (i==3) continue  // i 为 3 时跳过当前循环，继续下一次循环
            println(i)
            if (i>5) break   // i 为 6 时 跳出循环
        }
    }

    override fun initView() {

    }

    override fun start() {

        var sum2 = 0
        for (i in 1..100) {
            var sum1 = 0
            for (j in 1..i) {
                sum1 += j
            }
            sum2 += sum1
        }
        println(sum2)

    }
}
