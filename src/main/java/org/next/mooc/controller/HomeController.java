package org.next.mooc.controller;

import java.util.List;

import org.next.mooc.model.AAA;
import org.next.mooc.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class HomeController {
	@Autowired
	private TestService testService;
	
	@GetMapping("/home")
	public String home() throws Exception {
		log.info("home");
		return "home";
	}
	
	@GetMapping("/aaa")
	public List<AAA> aaa() {
		return testService.getTestAll();
	}
}
