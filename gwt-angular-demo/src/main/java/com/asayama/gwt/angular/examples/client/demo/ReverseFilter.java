package com.asayama.gwt.angular.examples.client.demo;

import com.asayama.gwt.angular.client.AbstractFilter;


public class ReverseFilter extends AbstractFilter {

    @Override
    public String filter(String input) {
        if (input == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(input.length());
        for (int i = input.length() - 1; i >= 0; i--) {
            sb.append(input.charAt(i));
        }
        return sb.toString();
    }
}