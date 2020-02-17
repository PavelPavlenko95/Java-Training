package by.pavelpavlenko.Task1_CompositeLight.service.parser;

import by.pavelpavlenko.Task1_CompositeLight.beans.Character;

import java.util.ArrayList;
import java.util.List;

public class CharacterParser extends Parser {

    @Override
    public List handleRequest(final String text) {
        ArrayList<Character> list = new ArrayList<>();
        for (char c : text.toCharArray()) {
            list.add(new Character(c + ""));
        }
        return list;
    }

}
