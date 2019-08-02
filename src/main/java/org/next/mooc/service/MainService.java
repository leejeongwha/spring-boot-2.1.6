package org.next.mooc.service;

import java.util.List;

import org.next.mooc.model.MainKeyVisual;
import org.next.mooc.repository.MainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MainService {
	@Autowired
	private MainRepository mainRepository;
	
	@Cacheable(cacheNames="mainPageCache", key="#partnerCode")
	public List<MainKeyVisual> getMainKeyVisualList(String partnerCode) {
		log.info("getMainKeyVisualList service called!!!");
		
		return mainRepository.selectMainKeyVisualList(partnerCode);
	}
}
