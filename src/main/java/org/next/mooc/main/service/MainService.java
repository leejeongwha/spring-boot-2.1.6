package org.next.mooc.main.service;

import java.util.List;

import org.next.mooc.main.model.MainAutoCuration;
import org.next.mooc.main.model.MainKeyVisual;
import org.next.mooc.main.model.MainManualCuration;
import org.next.mooc.main.model.MainNewsBlog;
import org.next.mooc.main.model.MainResponse;
import org.next.mooc.main.model.MainTimeLine;
import org.next.mooc.main.repository.MainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MainService {
	@Autowired
	private MainRepository mainRepository;

	@Cacheable(cacheNames = "mainPageCache", key = "#partnerCode")
	public MainResponse getMainList(String partnerCode) {
		MainResponse res = new MainResponse();
		res.setMainKeyVisualList(getMainKeyVisualList(partnerCode));
		res.setMainAutoCurationList(getMainAutoCurationList(partnerCode));
		res.setMainManualCurationList(getMainManualCurationList(partnerCode));
		res.setMainNewsBlogList(getMainNewsBlogList(partnerCode));
		res.setMainTimeLineList(getMainTimeLineList(partnerCode));

		return res;
	}

	private List<MainKeyVisual> getMainKeyVisualList(String partnerCode) {
		return mainRepository.selectMainKeyVisualList(partnerCode);
	}

	private List<MainManualCuration> getMainManualCurationList(String partnerCode) {
		return mainRepository.selectMainManualCurationList(partnerCode);
	}

	private List<MainAutoCuration> getMainAutoCurationList(String partnerCode) {
		return mainRepository.selectMainAutoCurationList(partnerCode);
	}

	private List<MainNewsBlog> getMainNewsBlogList(String partnerCode) {
		return mainRepository.selectMainNewsBlogList(partnerCode);
	}

	private List<MainTimeLine> getMainTimeLineList(String partnerCode) {
		return mainRepository.selectMainTimeLineList(partnerCode);
	}
}
