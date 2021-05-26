package com.pollfishqa.quality.common;

import org.slf4j.LoggerFactory;

import java.text.MessageFormat;

public interface LocatorAccessor {

    String getLocator();

    default String get() {
        logUsage();
        return getLocator();
    }

    default String getWithParams(Object... params){
        logUsage();
        return MessageFormat.format(getLocator(), params);
    }

    default void logUsage() {
        LoggerFactory.getLogger(this.getClass()).info("Using {}", getLocator());
    }

}
