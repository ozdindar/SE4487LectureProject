package org.live.chapter1.spellchecker.dependencyInjection;

public class CambridgeDictionary implements Dictionary{
    @Override
    public boolean isValid(String word) {
        return false;
    }

    @Override
    public String[] tokenize(String line) {
        return new String[0];
    }
}