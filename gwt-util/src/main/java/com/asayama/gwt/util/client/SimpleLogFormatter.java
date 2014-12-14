package com.asayama.gwt.util.client;

import java.util.logging.LogRecord;

import com.google.gwt.logging.impl.FormatterImpl;

/**
 * Log formatter that only prints out the message.
 * @author kyoken74
 */
public class SimpleLogFormatter extends FormatterImpl {

    @Override
    public String format(LogRecord record) {
        return record.getMessage();
    }
}
