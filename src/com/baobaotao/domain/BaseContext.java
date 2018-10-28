package com.baobaotao.domain;

import java.util.Map.Entry;

public class BaseContext {
	
	private Class<?> clazz;
	
	private Entry entry;

	public Class<?> getClazz() {
		return clazz;
	}

	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}

	public Entry getEntry() {
		return entry;
	}

	public void setEntry(Entry entry) {
		this.entry = entry;
	}
	
	
	

}
