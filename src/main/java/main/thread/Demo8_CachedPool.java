package main.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Demo8_CachedPool {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors.newCachedThreadPool();
		ThreadPoolExecutor service1 = new ScheduledThreadPoolExecutor(4);
		System.out.println(service);
		
		for (int i = 0; i < 2; i++) {
			service.execute(()->{
				try {
					TimeUnit.MILLISECONDS.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName());
			});
		}
		
		System.out.println(service);
		
		TimeUnit.SECONDS.sleep(60);
		System.out.println(service);

		TimeUnit.SECONDS.sleep(1);
		System.out.println(service);
	}
}
