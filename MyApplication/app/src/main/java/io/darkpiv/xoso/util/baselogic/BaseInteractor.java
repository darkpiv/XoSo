package io.darkpiv.xoso.util.baselogic;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import io.darkpiv.xoso.util.PreConditions;

/**
 * Created by darkpiv on 19/12/2016.
 */

public class BaseInteractor {

    private static final int NUMBER_OF_THREADS = 5;

    private ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(NUMBER_OF_THREADS);
    private ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    private Handler handler = new Handler(Looper.getMainLooper());

    private ScheduledFuture<?> scheduledFuture;

    public void runOnUiThread(@NonNull Runnable runnable) {
        PreConditions.checkNotNull(runnable, "runnable shouldn't be null");

        handler.post(runnable);
    }

    public void runOnUiThreadAfter(@NonNull Runnable runnable, long time) {
        PreConditions.checkNotNull(runnable, "runnable shouldn't be null");

        handler.postDelayed(runnable, time);
    }

    public void runOnBackground(@NonNull Runnable runnable) {
        PreConditions.checkNotNull(runnable, "runnable shouldn't be null");

        if (executor.isShutdown()) {
            executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        }

        final Future<?> task = executor.submit(runnable);

        if (task.isDone()) {
            executor.shutdown();
        }
    }

    public void runScheduledTaskOnBackground(@NonNull Runnable runnable, @NonNull Long time, @NonNull TimeUnit unit) {
        PreConditions.checkNotNull(runnable, "runnable shouldn't be null");
        PreConditions.checkNotNull(time, "time shouldn't be null");
        PreConditions.checkNotNull(unit, "unit shouldn't be null");

        scheduledFuture = scheduledExecutor.schedule(runnable, time, unit);
    }

    public void cancelScheduledTask() {
        if (null != scheduledFuture) {
            scheduledFuture.cancel(true);
        }
    }

    public void removeAllCallbackAndMessages() {
        handler.removeCallbacksAndMessages(null);
    }
}
