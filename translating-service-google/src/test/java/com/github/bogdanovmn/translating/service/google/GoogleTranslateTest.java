package com.github.bogdanovmn.translating.service.google;

import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GoogleTranslateTest {
	@Test
	public void parseServiceRawAnswer() throws Exception {
		String html = new String(
			Files.readAllBytes(
				Paths.get(
					getClass().getResource("/translate--hello--html").toURI()
				)
			),
			StandardCharsets.UTF_8
		);

		String translate = new GoogleTranslate().parsedServiceResponse(html);

		assertNotNull(translate);
		assertEquals("Привет", translate);
	}
}