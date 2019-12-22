package com.epam.strings.text.copier;

import com.epam.strings.text.entity.Component;
import com.epam.strings.text.entity.TextComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class Copier {

    private static final Logger logger = LogManager.getLogger(Copier.class.getName());

    public Component copy(Component original) {

        logger.debug("Start copy object");

        List<Component> listCopyParagraph = new ArrayList<>();
        for (Component paragraph : original.getComponents()) {

            List<Component> listCopySentence = new ArrayList<>();
            for(Component sentence : paragraph.getComponents()) {
                List<Component> copyWords = new ArrayList<>(sentence.getComponents());
                Component copySentence = new TextComposite(copyWords);
                listCopySentence.add(copySentence);
            }
            Component copyParagraph = new TextComposite(listCopySentence);
            listCopyParagraph.add(copyParagraph);

        }
        return new TextComposite(listCopyParagraph);
    }
}
