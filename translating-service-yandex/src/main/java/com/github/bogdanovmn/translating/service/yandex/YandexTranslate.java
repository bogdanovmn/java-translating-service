package com.github.bogdanovmn.translating.service.yandex;

import com.github.bogdanovmn.httpclient.core.ResponseParseException;
import com.github.bogdanovmn.httpclient.phantomjs.SeleniumPhantomJsHttpClient;
import com.github.bogdanovmn.translating.service.core.HttpTranslateService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class YandexTranslate extends HttpTranslateService {
	public YandexTranslate() {
		super(
			new SeleniumPhantomJsHttpClient(2000),
			"https://translate.yandex.ru/?lang=en-ru&text="
		);
	}

	@Override
	protected String parsedServiceResponse(String htmlText) throws ResponseParseException {
		System.out.println(htmlText);
		Document doc = Jsoup.parse(htmlText);
		Element resultBox = doc
			.select("div[class=translation-container] pre[id=translation]")
			.first();

		return resultBox == null
			? null
			: resultBox.text();
	}
}
