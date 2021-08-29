package com.github.bogdanovmn.translating.service.cli;


import com.github.bogdanovmn.cmdline.CmdLineAppBuilder;
import com.github.bogdanovmn.translating.service.core.TranslateService;

public class App {
	public static void main(String[] args) throws Exception {
		new CmdLineAppBuilder(args)
			.withJarName("translate")
			.withDescription("Translate service CLI")
			.withRequiredArg("term", "Term to translate")
			.withArg("provider", "Translation service provider: google, yandex")
			.withEntryPoint(
				cmdLine -> {
					TranslateService translateService = (cmdLine.hasOption("provider")
						? TranslationServiceProvider.valueOf(
							cmdLine.getOptionValue("provider")
						)
						: TranslationServiceProvider.GOOGLE
					).translateService();

					System.out.println(
						translateService.translate(
							cmdLine.getOptionValue("term")
						)
					);
				}
			).build().run();
	}
}
