package chapter1.spellchecker.dependencyInjection;

public interface Dictionary {

    boolean isValid(String word);

    String[] tokenize(String line);
}
