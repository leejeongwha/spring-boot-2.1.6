package org.next.mooc.main.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class MainTimeLine implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String title;
	private Boolean isExposure;
	private Boolean isDeleted;
	private Date modYmdt;
	private Long contId;
	private String contContent;
	private String contWriterName;
	private String contCourseName;
	private String contContentTitle;
	private String contContentType;
	private String contContentUrl;
	private String contWriteYmdt;
	private Long contOrderNum;
	private Boolean contIsExposure;
}
