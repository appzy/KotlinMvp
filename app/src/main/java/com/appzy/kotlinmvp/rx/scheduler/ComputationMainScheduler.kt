package com.appzy.kotlinmvp.rx.scheduler

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
/**
 * Created by appzy on 2017/11/17.
 * desc:
 */


class ComputationMainScheduler<T> private constructor() : BaseScheduler<T>(Schedulers.computation(), AndroidSchedulers.mainThread())
