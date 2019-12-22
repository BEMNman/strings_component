package com.epam.strings.text.sorter;

import com.epam.strings.text.copier.Copier;
import com.epam.strings.text.entity.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class ParagraphSorter implements Sorter {

    private static final Logger logger = LogManager.getLogger(ParagraphSorter.class.getName());

    @Override
    public Component sort(Component component) {
        Comparator<Component> comparator = Comparator.comparing(x -> x.getComponents().size());

        Copier copier = new Copier();
        Component copyComponent = copier.copy(component);
        copyComponent.getComponents().sort(comparator);

        logger.debug("Text was sorted by " + getClass().getName());

        return copyComponent;
    }
}
