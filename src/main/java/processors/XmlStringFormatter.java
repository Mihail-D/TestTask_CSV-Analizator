package processors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XmlStringFormatter {

    public static String formatXmlString(String xmlString) {
        StringBuilder result = new StringBuilder();
        Pattern pattern = Pattern.compile("\"([^\"]*)\"");
        Matcher matcher = pattern.matcher(xmlString);
        while (matcher.find()) {
            if (!result.isEmpty()) {
                result.append(";");
            }
            result.append(matcher.group(1));
        }

        return result.toString();
    }
}
