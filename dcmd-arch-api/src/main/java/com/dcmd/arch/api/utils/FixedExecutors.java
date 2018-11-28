package com.dcmd.arch.api.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

/**
 * 多线程操作工具
 * @Author yy
 * @Date 2018-10-23
 */
public class FixedExecutors {

    private final static Logger LOGGER = LoggerFactory.getLogger(FixedExecutors.class);


    public final static int DEFAULT_FIXED_NUM = 100;
    /**默认初始化一个大小为100的定长线程池*/
    public final static FixedExecutors FIXED_EXECUTORS = new FixedExecutors(DEFAULT_FIXED_NUM);

    ExecutorService executor;

    private FixedExecutors(int fixedNum) {
        this.executor = Executors.newFixedThreadPool(fixedNum);
    }

    /**
     * 获取默认的线程执行器
     *
     * @return
     */
    public static FixedExecutors getDefaultFixedExecutors() {
        return FIXED_EXECUTORS;
    }

    /**
     * 获取一个执行器实例
     *
     * @return
     */
    public static FixedExecutors newInstance(int fixedNum) {
        return new FixedExecutors(fixedNum);
    }

    /**
     * 执行任务
     *
     * @param countDownLatch
     * @param runnable
     */
    public void execute(final CountDownLatch countDownLatch, final Runnable runnable) {
        this.executor.execute(() -> {
            try {
                runnable.run();
            } catch (Exception e) {
                LOGGER.error("子线程执行失败：", e);
            } finally {
                countDownLatch.countDown();
            }
        });
    }


    /**
     * 执行多个任务
     *
     * @param countDownLatch
     * @param runnables
     */
    public void execute(final CountDownLatch countDownLatch, final List<Runnable> runnables) {
        if (CollectionUtils.isEmpty(runnables)) {
            return;
        }
        for (Runnable runnable : runnables) {
            this.execute(countDownLatch, runnable);
        }
    }

    /**
     * 执行任务
     *
     * @param countDownLatch
     * @param runnable
     */
    public void execute(final CountDownLatch countDownLatch, final Runnable runnable, final boolean throwed) throws Exception {
        final List<Exception> es = new ArrayList<>();
        this.executor.execute(() -> {
            try {
                runnable.run();
            } catch (Exception e) {
                if (throwed) {
                    es.add(e);
                }
                LOGGER.error("子线程执行失败：", e);
            } finally {
                countDownLatch.countDown();
            }
        });
        if (!CollectionUtils.isEmpty(es)) {
            throw es.get(0);
        }
    }

    /**
     * 执行callable
     */
    public <T> Future<T> submit(Callable<T> task) {
        return this.executor.submit(task);
    }

    /**
     * 批量执行callable
     */
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws Exception {
        return this.executor.invokeAll(tasks);
    }
}
