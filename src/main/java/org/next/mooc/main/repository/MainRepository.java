package org.next.mooc.main.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.next.mooc.main.model.MainAutoCuration;
import org.next.mooc.main.model.MainKeyVisual;
import org.next.mooc.main.model.MainManualCuration;
import org.next.mooc.main.model.MainNewsBlog;
import org.next.mooc.main.model.MainTimeLine;

@Mapper
public interface MainRepository {
	List<MainKeyVisual> selectMainKeyVisualList(String partnerCode);

	List<MainManualCuration> selectMainManualCurationList(String partnerCode);

	List<MainAutoCuration> selectMainAutoCurationList(String partnerCode);

	List<MainNewsBlog> selectMainNewsBlogList(String partnerCode);

	List<MainTimeLine> selectMainTimeLineList(String partnerCode);
}
