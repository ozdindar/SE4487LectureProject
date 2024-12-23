package org.live.chapter1.spellchecker;


import java.util.List;

public class SpellChecker {

    boolean isValid(String word)
    {
        return false;
    }

    boolean validate(List<String> lines)
    {
        for (String  line:lines)
        {
            for (String word:line.split(" "))
            {
                if (!isValid(word))
                    return false;
            }
        }
        return true;
    }
}
