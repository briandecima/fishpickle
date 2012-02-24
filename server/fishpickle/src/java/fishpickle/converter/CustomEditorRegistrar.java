package fishpickle.converter;

import grails.util.GrailsConfig;

import java.util.Date;
import java.util.List;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

public class CustomEditorRegistrar implements PropertyEditorRegistrar {
    public void registerCustomEditors(PropertyEditorRegistry reg) {
        reg.registerCustomEditor(Date.class, new CustomDateBinder(GrailsConfig.get("grails.date.formats", List.class)));
    }
}
