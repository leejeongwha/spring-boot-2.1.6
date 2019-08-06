package org.next.mooc.main.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class MainResponse {
	private List<MainKeyVisual> mainKeyVisualList = new ArrayList<>();
	private List<MainManualCuration> mainManualCurationList = new ArrayList<>();
	private List<MainAutoCuration> mainAutoCurationList = new ArrayList<>();
	private List<MainNewsBlog> mainNewsBlogList = new ArrayList<>();
	private List<MainTimeLine> mainTimeLineList = new ArrayList<>();
}
