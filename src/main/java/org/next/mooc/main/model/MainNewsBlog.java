package org.next.mooc.main.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class MainNewsBlog implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String title;
	private String imageUrl;
	private Boolean isBlank;
	private Boolean isExposure;
	private String linkUrl;
	private Long orderNum;
	private Date exposureStrtYmdt;
	private Date exposureEndtYmdt;
}
