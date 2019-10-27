import java.util.HashMap;

public class ArgsParser {
    private HashMap<String, String> mapParametrs = new HashMap<>();

    public ArgsParser(String... args) {
        try {
            mapParametrs.put("SourceXml", args[0]);
            mapParametrs.put("SourceXsd", args[1]);
            mapParametrs.put("SourceXslt", args[2]);
            mapParametrs.put("resultXml", args[3]);

        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    public String getRes(String key) {
        return mapParametrs.getOrDefault(key, "null");
    }
}
