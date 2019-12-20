package com.epam.strings.text.sorter;

import com.epam.strings.text.copier.Copier;
import com.epam.strings.text.entity.Component;
import com.epam.strings.text.entity.TextComposite;
import com.epam.strings.text.exception.NotCopyObjectException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Sorter {

    public Component sortParagraph(Component text) {
        Comparator<Component> comparator = Comparator.comparing(x -> x.getComponents().size());

        List<Component> paragraphs = text.getComponents();
        List<Component> copyParagraph = new ArrayList<>(paragraphs);
        copyParagraph.sort(comparator);
        return new TextComposite(copyParagraph);
    }

    public Component sortWordsByLength(Component text) {
        Comparator<Component> comparator = Comparator.comparing(x -> x.getValue().length());


        Copier<Component> copier = new Copier<>();
        Component copyText = null;
        try {
            copyText = copier.copy(text);
        } catch (NotCopyObjectException e) {
//            e.printStackTrace();          logger
        }
        for (Component paragraph : copyText.getComponents()) {
            for(Component sentence : paragraph.getComponents()) {
                List<Component> words = sentence.getComponents();
                Component markSentence = words.remove(words.size() - 1);
                words.sort(comparator);
                words.add(markSentence);
            }
        }
        return copyText;

//        List<Component> copyParagraphs = new ArrayList<>(text.getComponents());
//        List<Component> copyParagraphsSortedWords = new ArrayList<>();
//        for (Component paragraph : copyParagraphs) {
//
//            List<Component> copySentences = new ArrayList<>(paragraph.getComponents());
//            List<Component> copySentencesSortedWords = new ArrayList<>();
//            for(Component sentence : copySentences) {
//
//                List<Component> copyWords = new ArrayList<>(sentence.getComponents());
//                Component markSentence = copyWords.remove(copyWords.size() - 1);
//                copyWords.sort(comparator);
//                copyWords.add(markSentence);
//                copySentencesSortedWords.add(new TextComposite(copyWords));
//            }
//            copyParagraphsSortedWords.add(new TextComposite(copySentencesSortedWords));
//        }
//        return new TextComposite(copyParagraphsSortedWords);

    }

    public Component sortWordsBySymbol(Component text, char symbol) {
        return null;
    }
}
