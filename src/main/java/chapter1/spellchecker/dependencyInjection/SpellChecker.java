package chapter1.spellchecker.dependencyInjection;



import java.util.List;

public class SpellChecker {

    Dictionary dictionary;

    private SpellChecker(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    boolean validate(List<String> lines)
    {
        for (String  line:lines)
        {
            for (String word:dictionary.tokenize(line))
            {
                if (!dictionary.isValid(word))
                    return false;
            }
        }
        return true;
    }

    static SpellChecker withDictionary(Dictionary dictionary)
    {
        return new SpellChecker(dictionary);
    }
    public static void main(String[] args) {
        SpellChecker spellChecker = SpellChecker.withDictionary(new OxfordDictionary());


        List<String> text = null;
        if (spellChecker.validate(text))
            System.out.println("Valid");
    }


}
