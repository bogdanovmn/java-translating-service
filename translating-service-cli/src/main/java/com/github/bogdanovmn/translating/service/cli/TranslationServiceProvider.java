package com.github.bogdanovmn.translating.service.cli;

import com.github.bogdanovmn.translating.service.core.TranslateService;
import com.github.bogdanovmn.translating.service.google.GoogleTranslate;
import com.github.bogdanovmn.translating.service.yandex.YandexTranslate;

enum TranslationServiceProvider {
	YANDEX(new YandexTranslate()),
	GOOGLE(new GoogleTranslate());

	private final TranslateService translateService;
	TranslationServiceProvider(TranslateService translateService) {
		this.translateService = translateService;
	}

	TranslateService translateService() {
		return translateService;
	}
}
