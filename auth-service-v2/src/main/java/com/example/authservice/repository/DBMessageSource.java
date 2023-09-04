package com.example.authservice.repository;

import com.example.authservice.model.LanguageEntity;
import org.springframework.context.support.AbstractMessageSource;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.Locale;

@Component
public class DBMessageSource extends AbstractMessageSource {
    private final LanguageRepository languageRepository;
    private static final String DEFAULT_LOCALE_CODE = "en";


    public DBMessageSource(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    protected MessageFormat resolveCode(String key, Locale locale) {
        LanguageEntity message = languageRepository.findByMessageKeyAndLocale(key,locale.getLanguage()).orElse(null);
        if (message == null) {
            message = languageRepository.findByMessageKeyAndLocale(key,DEFAULT_LOCALE_CODE).orElse(null);
        }
        return new MessageFormat(message.getMessageContent(), locale);
    }
}
