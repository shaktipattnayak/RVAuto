package com.raptor.util;

import ru.yandex.qatools.properties.PropertyLoader;
import ru.yandex.qatools.properties.annotations.Property;
import ru.yandex.qatools.properties.annotations.Resource;


@Resource.Classpath("app.properties")
public class PropertyReader {
	
	
    @Property("BaseURL")
    private String baseURL;
	
	
	
    public String getBaseURL() {
		return baseURL;
	}



	public void setBaseURL(String baseURL) {
		this.baseURL = baseURL;
	}


	/**
     * Instantiates a new portal properties.
     */
    public PropertyReader() {
    	PropertyLoader.populate(this);
    }

}
