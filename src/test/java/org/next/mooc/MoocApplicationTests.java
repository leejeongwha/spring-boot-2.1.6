package org.next.mooc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
//@SpringBootTest
public class MoocApplicationTests {
	AtomicInteger counter = new AtomicInteger(0);
	//String url = "http://localhost:8080/test/sync-blocking";
	
	//core-size가 8이므로 동시에 8개만 처리
	//String url = "http://localhost:8080/test/async-blocking"; 
	
	//sync-blocking보다 수행시간 절반(서버작업 2개가 별도의 스레드로 동시에 작업 됨)
	String url = "http://localhost:8080/test/sync-nonBlocking";

	/**
	 * 동시에 100개의 요청을 call(톰캣의 max-threads 디폴트 값은 200)
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void test() throws InterruptedException {
		ExecutorService es = Executors.newFixedThreadPool(100);

		RestTemplate rt = new RestTemplate();

		StopWatch main = new StopWatch();
		main.start();

		for (int i = 0; i < 100; i++) {
			es.execute(() -> {
				int idx = counter.incrementAndGet();

				StopWatch sw = new StopWatch();
				sw.start();

				rt.getForObject(url, String.class);

				sw.stop();

				System.out.println("Elasped Time(" + idx + ") : " + sw.getTotalTimeSeconds());
			});
		}

		es.shutdown();
		es.awaitTermination(100, TimeUnit.SECONDS);

		main.stop();
		System.out.println("Main Elasped Time : " + main.getTotalTimeSeconds());
	}
}
