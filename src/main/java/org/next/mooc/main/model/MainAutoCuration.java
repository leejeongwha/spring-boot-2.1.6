package org.next.mooc.main.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class MainAutoCuration implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String type;
	private String title;
	private Long contId;
	private String contType;
	private String contImageUrl;
	private String contLinkUrl;
	private String contTagTitle;
	private String contCourseTitle;
	private String contLectureTitle;
	private String contOpenDay;
	private String contEndDay;
	private String contProfName;
	private String contPartnerName;
	
}
