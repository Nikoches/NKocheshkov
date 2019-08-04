package ru.job4j.SolidPrinc.Tdd;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public class SimpleGenerator implements Template {
    private final Pattern KEYS = Pattern.compile("\\$\\{(.*?)\\}");

    public static void main(String[] args) throws Exception {
        SimpleGenerator sm = new SimpleGenerator();
        Map<String, String> testmap = new HashMap<>();
        testmap.put("sss", "OOO");
        testmap.put("aaaa", "OOO");
        System.out.println(sm.generate("something ${sss} unus99al ${aaaa}56ff", testmap));

    }

    /**
     * @param template Строка для обработки
     * @param regmap   Карта ключей.
     * @return Возврат преобразованной строки.
     * Преобразует входящую строку по регулярному выражению соответствуя ключам в переданной карте.
     */
    @Override
    public String generate(String template, Map<String, String> regmap) throws Exception {
        Matcher matcher = KEYS.matcher(template);
        String res = template;
        if (keyCheck(regmap,template));
            while (matcher.find()) {
                if (extCheck(matcher.group(1), regmap)) {
                    res = (res.replace(matcher.group(0), regmap.get(matcher.group(1))));
                }
            }
        return res;
    }

    /**
     * @param patt   Полученный по регулярному выражению ключ.
     * @param regmap Карта ключей.
     * @return True если соответствует, если нет кидает исключение.
     * @throws Exception Проверяет наличие конкретного ключа в карте.
     */
    private boolean extCheck(String patt, Map<String, String> regmap) throws Exception {
        if (regmap.containsKey(patt)) {
            return true;
        } else throw new Exception("Keys does not exist!");
    }

    /**
     * @param regmap  Карта ключей.
     * @return True если соответствует, если нет кидает исключение.
     * @throws Exception Проверка соответствия количества ключей.
     */
    private boolean keyCheck(Map<String, String> regmap,String template) throws Exception {
        Matcher matcher = KEYS.matcher(template);
        int capacity = 0;
        while (matcher.find()) {
            capacity++;
        }
        if (regmap.size() == capacity) {
            return true;
        } else throw new Exception("Number of keys does not match!");
    }
}
