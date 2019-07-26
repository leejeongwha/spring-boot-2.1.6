package org.next.mooc.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.next.mooc.model.AAA;

@Mapper
public interface TestRepository {
	List<AAA> selectAll();
}
