package com.pavlekuzevski.moviediscovery.utils.rx;

import io.reactivex.Scheduler;

public interface SchedulerProvider {
    Scheduler io();

    Scheduler ui();
}
