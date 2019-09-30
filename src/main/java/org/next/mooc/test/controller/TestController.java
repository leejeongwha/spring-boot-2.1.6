package org.next.mooc.test.controller;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import org.next.mooc.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("test")
@Slf4j
public class TestController {
	@Autowired
	private TestService testService;
	
	@GetMapping("sync-blocking")
	public String syncBlocking() throws InterruptedException {
		log.info("sync-blocking start");
		
		testService.dbService();
		testService.httpService();
		
		return "ok";
	}
	
	@GetMapping("async-blocking")
	public Callable<String> asyncBlocking() throws InterruptedException {
		log.info("servlet thread start");
		
		Callable<String> callable = () -> {
			log.info("woker threadWT start");
			testService.dbService();
			testService.httpService();
			return "ok";
		};
		
		log.info("servlet thread end");
		
		return callable;
	}
	
	@GetMapping("sync-nonBlocking")
	public String syncNonBlocking() throws InterruptedException, ExecutionException {
		log.info("sync-nonBlocking start");
		
		ListenableFuture<String> dbResult = testService.dbAsyncService();
		dbResult.addCallback(s -> log.info(s), e-> log.info(e.getMessage()));
        
        ListenableFuture<String> httpResult = testService.httpAsyncService();
        httpResult.addCallback(s -> log.info(s), e-> log.info(e.getMessage()));
        
        String allResult = dbResult.get() + httpResult.get();
        
        log.info("sync-nonBlocking end");
        
		return allResult;
	}
}
