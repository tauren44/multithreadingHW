package multithreading.executors;

import java.util.concurrent.*;

public class TestApp {
    public static void main(String[] args) throws Exception {
        Callable<Integer> callable = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());


        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(futureTask);
        System.out.println(futureTask.get());
        executorService.shutdown();

        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(2);
        scheduledExecutorService.schedule(futureTask, 3, TimeUnit.SECONDS);
        System.out.println(futureTask.get());
        scheduledExecutorService.shutdown();

        ThreadPoolExecutor es =
                new ThreadPoolExecutor(3, 6,
                        1, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

        for (int i = 0; i < 5; i++) {
            Callable<Integer> mc = new MyCallable();
            es.submit(mc);
        }

        es.shutdown();
    }
}
