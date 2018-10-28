package com.baobaotao.domain;

public class BaseResult {
	
	private final String NOT_SEARCH_DATE_WORD = "未提取出时间词语";
	
	private String startTime;
	
	private String endTime;
	
	private Boolean isSearched = false;
	
	private String errorMessage = NOT_SEARCH_DATE_WORD;

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Boolean getIsSearched() {
		return isSearched;
	}

	public void setIsSearched(Boolean isSearched) {
		this.isSearched = isSearched;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	

}
