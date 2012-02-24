package fishpickle.converter;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomDateBinder extends PropertyEditorSupport {

    private final List<String> formats;

    public CustomDateBinder(List formats) {
        List<String> formatList = new ArrayList<String>(formats.size());
        for (Object format : formats) {
            formatList.add(format.toString()); // Force String values (eg. for GStrings)
        }
        this.formats = Collections.unmodifiableList(formatList);
    }

    @Override
    public void setAsText(String s) throws IllegalArgumentException {
        if (s != null && s.length() >= 10)
            for (String format : formats) {
                // Need to create the SimpleDateFormat every time, since it's not thead-safe
                SimpleDateFormat df = new SimpleDateFormat(format);
                try {
                	Object parsed = df.parse(s.substring(0, 10) + " " +  s.substring(11, 19));
                    setValue(parsed);
                    return;
                } catch (ParseException e) {
                    // Ignore
                }
            }
    }
}

