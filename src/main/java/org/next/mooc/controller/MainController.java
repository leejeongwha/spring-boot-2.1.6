package org.next.mooc.controller;

import java.util.List;

import org.next.mooc.model.MainKeyVisual;
import org.next.mooc.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MainController {
	@Autowired
	private MainService mainService;
	
	@GetMapping(value= {"/", "home"})
	public String home() throws Exception {
		log.info("home");
		return "home";
	}
	
	@GetMapping("/main")
	public List<MainKeyVisual> main() {
		return mainService.getMainKeyVisualList("NEXT");
	}
}
