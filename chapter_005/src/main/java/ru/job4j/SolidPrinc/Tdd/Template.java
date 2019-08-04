package ru.job4j.SolidPrinc.Tdd;

import java.util.Map;

public interface Template {
    String generate(String template, Map<String,String> regmap) throws Exception;
}
