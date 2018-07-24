package com.home24.task.utils.rx;

import io.reactivex.Scheduler;

/**
 * Created by Alaeddine Khoudi .
 */

public interface SchedulerProvider {

    Scheduler ui();

    Scheduler computation();

    Scheduler io();
}
