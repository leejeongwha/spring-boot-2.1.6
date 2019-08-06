package org.next.mooc.main.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class MainManualCuration implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long groupId;
	private String title;
	private Long contId;
	private String contType;
	private Long contCourseId;
	private Long contLectureId;
	private String contTitle;
	private String contDescription;
	private String contImageUrl;
	private String contLinkUrl;
	private String contOpenDay;
	private String contEndDay;
	private String contIsBlank;
	private String contProfName;
	private String contPartnerName;
	private Integer contVoteCount;
}
