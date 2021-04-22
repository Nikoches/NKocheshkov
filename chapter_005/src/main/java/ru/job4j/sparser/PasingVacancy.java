package ru.job4j.sparser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashSet;
import java.util.Set;

public class PasingVacancy {
    String lldate = "";
    Set<Vacancy> list = new HashSet<>();

    public Set<Vacancy> parse(String date) {
        int page = 0;
        while (!lldate.equals(date)) {
            try {

                Document doc = Jsoup.connect("https://www.sql.ru/forum/job-offers/" + page).get(); //получает html-код страницы
                Element table = doc.select("table").get(2); //находим первую таблицу в документе
                //если надо вторую, третью или т.д. используем .get(номер)
                Elements rows = table.select("tr"); // разбиваем нашу таблицу на строки по тегу
                for (int i = 1; i < rows.size(); i++) {
                    Element row = rows.get(i); //по номеру индекса получает строку
                    Elements cols = row.select("td"); // разбиваем полученную строку по тегу  на столбы
                    if (cols.get(1).text().contains("Java") && !cols.get(1).text().contains("JavaScript")) {
                        Document docdesc = Jsoup.connect(cols.get(1).select("a").attr("href")).get();
                        System.out.print(cols.get(1).text()); // название
                        System.out.println(cols.get(5).text()); //дата
                        lldate = cols.get(5).text();
                        System.out.print(cols.get(1).select("a").attr("href") + "  \n "); //ссылка
                        //описание
                        System.out.println(docdesc.select("table").get(1).select("tr").get(1).select("td").get(1).text());
                        list.add(new Vacancy(cols.get(1).text(),
                                docdesc.select("table").get(1).select("tr").get(1).select("td").get(1).text(),
                                cols.get(5).text(),
                                cols.get(1).select("a").attr("href")));
                    }
                }
                page++;
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
        return list;
    }

}