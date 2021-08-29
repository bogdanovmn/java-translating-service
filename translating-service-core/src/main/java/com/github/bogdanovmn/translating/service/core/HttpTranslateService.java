package com.github.bogdanovmn.translating.service.core;


import com.github.bogdanovmn.httpclient.core.ExternalHttpService;
import com.github.bogdanovmn.httpclient.core.HttpClient;
import com.github.bogdanovmn.httpclient.core.HttpServiceException;
import com.github.bogdanovmn.httpclient.core.ResponseNotFoundException;

import java.io.IOException;
import java.util.Objects;

public abstract class HttpTranslateService extends ExternalHttpService<String> implements TranslateService {

	public HttpTranslateService(HttpClient httpClient, String urlPrefix) {
		super(httpClient, urlPrefix);
	}

	@Override
	public final String translate(String phrase) throws HttpServiceException {
		String htmlText;
		try {
			htmlText = httpClient.get(urlPrefix + phrase);
		}
		catch (IOException e) {
			throw new HttpServiceException(e);
		}

		String translatedValue = parsedServiceResponse(
			Objects.toString(htmlText, "")
		);

		if (translatedValue == null || translatedValue.isEmpty()) {
			throw new ResponseNotFoundException("Empty result. Something wrong...");
		}
		if (translatedValue.contains(phrase)) {
			throw new ResponseNotFoundException(
				String.format(
					"No translate for '%s'", phrase
				)
			);
		}

		return translatedValue;
	}
}
