package org.example;

import org.example.dailyChallenges.model.AddingSpacesToAString;
import org.example.dailyChallenges.model.CheckIfAWordOccursAsAPrefixOfAnyWord;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        //System.out.println(new CheckIfAWordOccursAsAPrefixOfAnyWord().isPrefixOfWord(" i love ham burger", "burg"));

        System.out.println(new AddingSpacesToAString().addSpaces("LeetcodeHelpsMeLearn", new int[]{8,13,15}));
    }
}