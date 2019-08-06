package org.next.mooc.main.controller;

import org.next.mooc.main.model.MainResponse;
import org.next.mooc.main.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MainController {
	@Autowired
	private MainService mainService;

	@GetMapping(value = { "/", "home" })
	public String home() throws Exception {
		log.info("home");
		return "home";
	}

	@CrossOrigin
	@GetMapping("/main")
	public MainResponse main(@RequestParam(required = false, defaultValue = "NEXT") String partnerCode) {
		return mainService.getMainList(partnerCode);
	}
}
