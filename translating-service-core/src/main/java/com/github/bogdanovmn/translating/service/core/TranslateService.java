package com.github.bogdanovmn.translating.service.core;


import com.github.bogdanovmn.httpclient.core.HttpServiceException;

public interface TranslateService {
	String translate(String phrase) throws HttpServiceException;
}
