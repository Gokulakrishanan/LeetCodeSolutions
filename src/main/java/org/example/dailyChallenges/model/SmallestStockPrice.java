package org.example.dailyChallenges.model;

/*
import java.util.*;
import java.lang.*;
import java.io.*;

public class solution
{
public static int smallestStockPrice(int[] stock, int valueK)
{
int answer =0 ;
// write the solution here
return answer;
}
public static void main(String[] args)
{
Scanner in = new Scanner(System.in);
//input for stock
//first line of input
int stock_size = in.nextInt();
//second line of input
int stock[] = new int[stock_size];
for(int idx = ;idx<stock_size;idx++)
{
stock[idx] = in.nextInt();
}
//input for valueK
it valueK = in.nextInt();
int result = smallestStockPrice(stock,valueK);
System.out.print(result);
}
the first line of the input consists of an integer- stock_size representing the number of selected stocks(N).
the second line consist of N space separated integers- stock,stock,....stockN-1, representing the relative stock prices of the selected stocks. the third consist of an integer - valueK,
representing the value K for which trader wants to find th stock price.
output: print an integer representing kth smallest stock price of selected N stocks. constraints: 0<valueK<=stock_size<=10^6; 0<=stocki<=10^6; 0<=i<stock_size example:
5
10 5 7 88 19
3

Output:
10*/
public class SmallestStockPrice {

    public int smallestStockPrice(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k - 1);
    }

    private int quickSelect(int[] nums, int left, int right, int value) {

        //return the smallestStock(int) using recursion
        if (left == right) {
            return nums[left];
        }

        int pivotIndex = partitionIndex(nums, left, right);

        if (value == pivotIndex) {
            return nums[value];
        }
        return (value < pivotIndex) ?
                quickSelect(nums, left, pivotIndex - 1, value) :
                quickSelect(nums, pivotIndex + 1, right, value);
    }

    private int partitionIndex(int[] nums, int left, int right) {
        //nums[] = {10 5 25 18 19}
        int pivot = nums[right];
        int partitionIndex = left;
        for (int i = left; i < right; i++) {
            if (nums[i] <= pivot) {
                //iter1:10
                swap(nums, i, partitionIndex);
                partitionIndex++;
            }
        }
        swap(nums, partitionIndex, right);
        return partitionIndex;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
