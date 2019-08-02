package org.next.mooc.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.next.mooc.model.MainKeyVisual;

@Mapper
public interface MainRepository {
	List<MainKeyVisual> selectMainKeyVisualList(String partnerCode);
}
