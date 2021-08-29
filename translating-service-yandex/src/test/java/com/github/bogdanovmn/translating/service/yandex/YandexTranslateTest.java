package com.github.bogdanovmn.translating.service.yandex;

import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class YandexTranslateTest {
	@Test
	public void parseServiceRawAnswer() throws Exception {
		String html = new String(
			Files.readAllBytes(
				Paths.get(
					getClass().getResource("/translate--bar--html").toURI()
				)
			),
			StandardCharsets.UTF_8
		);

		String translate = new YandexTranslate().parsedServiceResponse(html);

		assertNotNull(translate);
		assertEquals("бар", translate);
	}
}