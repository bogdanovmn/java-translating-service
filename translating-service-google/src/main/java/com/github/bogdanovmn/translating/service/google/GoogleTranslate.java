package com.github.bogdanovmn.translating.service.google;

import com.github.bogdanovmn.httpclient.phantomjs.SeleniumPhantomJsHttpClient;
import com.github.bogdanovmn.translating.service.core.HttpTranslateService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class GoogleTranslate extends HttpTranslateService {

	public GoogleTranslate() {
		super(
			new SeleniumPhantomJsHttpClient(2000),
			"https://translate.google.ru/?sl=en&tl=ru&text="
		);
	}

	@Override
	protected String parsedServiceResponse(String htmlText) {
		Document doc = Jsoup.parse(htmlText);
		Element resultBox = doc
			.select("span[data-language-to-translate-into][data-language-for-alternatives] span[jsaction]")
			.first();

		return resultBox == null
			? null
			: resultBox.text();
	}
}
