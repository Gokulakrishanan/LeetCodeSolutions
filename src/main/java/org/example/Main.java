package org.example;

import org.example.dailyChallenges.model.FirstCompletelyPaintedRowOrColumns;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        //System.out.println(new CheckIfAWordOccursAsAPrefixOfAnyWord().isPrefixOfWord(" i love ham burger", "burg"));

        //System.out.println(new AddingSpacesToAString().addSpaces("LeetcodeHelpsMeLearn", new int[]{8,13,15}));
        // System.out.println(new MakeStringASubsequenceUsingCyclicIncrements().isSubSequence("abc", "ad"));
        // System.out.println(new TrappingRainWater().solve((new int[] {0,1,0,2,1,0,1,3,2,1,2,1})));


        //System.out.println(new MovePiecesToObtainAString().canChange("_L__R__RL", "L_____RLR"));
        //System.out.println(new MovePiecesToObtainAString().canWork("_L__R__RL", "L_____RLR"));

        //  System.out.println(new MaxNoOfIntegersToChooseFromRangeI().maxCount(new int[]{11},7,50));


        //  System.out.println(new TrappingRainWater().solve(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        //System.out.println(new MinLimitOfBallsInABag().minimumSize(new int[] {9}, 2));

        //System.out.println(new UniqueLength3PalindromicSubsequences().countPalindrome("aabca"));

        String[] words = {"mass", "as", "hero", "superhero"};

        //System.out.println(new StringMatchingInAnArray().stringMatching(new String[]{"mass", "as", "hero", "superhero"}));

        //System.out.println(new CountPrefixAndSuffixPairsI().countPairs(new String[]{"a", "aba", "ababa", "aa"}));
        //System.out.println(new CountingWordsWithAGivenPrefix().prefixCount(new String[]{"pay", "attention", "practice", "attend"}, "at"));
        //System.out.println(Arrays.toString(new MinNumberOfOpsToMoveBallsToEachBox().minOperations("001011")));
        System.out.println(new FirstCompletelyPaintedRowOrColumns().firstCompleteIndex(new int[]{1, 4, 5, 2, 6, 3}, new int[][]{{4, 3, 5}, {1, 2, 6}}));
    }
}