package org.next.mooc.test.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TestService {
	public String dbService() throws InterruptedException {
		log.info("dbService start");
		Thread.sleep(1000);
		log.info("dbService end");
		return "ok";
	}
	
	public String httpService() throws InterruptedException {
		log.info("httpService start");
		Thread.sleep(1000);
		log.info("httpService end");
		return "ok";
	}
	
	@Async
	public ListenableFuture<String> dbAsyncService() throws InterruptedException {
		log.info("dbService start");
		Thread.sleep(1000);
		log.info("dbService end");
		return new AsyncResult<>("ok");
	}
	
	@Async
	public ListenableFuture<String> httpAsyncService() throws InterruptedException {
		log.info("httpService start");
		Thread.sleep(1000);
		log.info("httpService end");
		return new AsyncResult<>("ok");
	}
}
