package org.next.mooc.service;

import java.util.List;

import org.next.mooc.model.AAA;
import org.next.mooc.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TestService {
	@Autowired
	private TestRepository testRepository;
	
	public List<AAA> getTestAll() {
		return testRepository.selectAll();
	}
}
