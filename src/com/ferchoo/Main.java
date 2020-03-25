package com.ferchoo;

import java.text.NumberFormat;
import java.util.Scanner;
import java.util.Arrays;
import com.ferchoo.MergeSort;

public class Main {

    public static void main(String[] args) {
	// write your code here
        MergeSort sorter = new MergeSort();

        int[] a = {1, 2, 3, 4};
        System.out.printf(Arrays.toString(a) + "Comparisons %d \n",sorter.howManyComparisons(a));
        int[] b = {2, 3, 2};
        System.out.printf(Arrays.toString(b) + "Comparisons %d \n",sorter.howManyComparisons(b));
        int[] c = {-17};
        System.out.printf(Arrays.toString(c) + "Comparisons %d \n",sorter.howManyComparisons(c));
        int[] d = {};
        System.out.printf(Arrays.toString(d) + "Comparisons %d \n",sorter.howManyComparisons(d));
        int[] e = {-2000000000,2000000000,0,0,0,-2000000000,2000000000,0,0,0};
        System.out.printf(Arrays.toString(e) + "Comparisons %d \n",sorter.howManyComparisons(e));
    }

}
/*
https://community.topcoder.com/stat?c=problem_statement&pm=1705

Problem Statement for MergeSort

Problem Statement

MergeSort is a classical sorting algorithm following the divide-and-conquer paradigm. Sorting n elements, it has a worst-case complexity of O(n*log(n)), which is optimal for sorting algorithms based on comparisons.

Basically, it sorts a list with more than one element the following way (a list containing only one element is always sorted):
1. divide the list into two sublists of about equal size (divide)
2. sort each of the two sublists (conquer)
3. merge the two sorted sublists into one sorted list (combine)

A pro of MergeSort is that it is stable, i.e. elements with the same key value keep their relative order during sorting. A con is that it is not in-place since it needs additional space for temporarily storing elements.

Given a int[] numbers, return the number of comparisons the MergeSort algorithm (as described in pseudocode below) makes in order to sort that list. In this context, a single comparison takes two numbers x, y (from the list to be sorted) and determines which of x < y, x = y and x > y holds.

List mergeSort(List a)
1. if size(a) <= 1, return a
2. split a into two sublists b and c
   if size(a) = 2*k, b contains the first k elements of a, c the last k elements
   if size(a) = 2*k+1, b contains the first k elements of a, c the last k+1 elements
3. List sb = mergeSort(b)
   List sc = mergeSort(c)
4. return merge(sb, sc)


List merge(List b, List c)
1. create an empty list a
2. while both b and c are not empty, compare the first elements of b and c
   first(b) < first(c): remove the first element of b and append it to the end of a
   first(b) > first(c): remove the first element of c and append it to the end of a
   first(b) = first(c): remove the first elements of b and c and append them to the end of a
3. if either b or c is not empty, append that non-empty list to the end of a
4. return a

Definition

Class:
MergeSort
Method:
howManyComparisons
Parameters:
int[]
Returns:
int
Method signature:
int howManyComparisons(int[] numbers)
(be sure your method is public)



Notes
-
Be sure to exactly follow the algorithm as described, as a different implementation of MergeSort might lead to a different number of comparisons.

Constraints
-
numbers contains between 0 and 50 elements, inclusive.
-
Each element of numbers is an int in its 'natural' (signed 32-bit) range from -(2^31) to (2^31)-1.

Examples
0)


{1, 2, 3, 4}
Returns: 4
{1, 2, 3, 4} is first split to {1, 2} and {3, 4}. {1, 2} is split to {1} and {2} and merging to {1, 2} takes one comparison. {3, 4} is split to {3} and {4} and merging to {3, 4} also takes one comparison. Merging {1, 2} and {3, 4} to {1, 2, 3, 4} takes two comparisons (first 1 is compared to 3 and then 2 is compared to 3). This makes a total of four comparisons.
1)


{2, 3, 2}
Returns: 2
{2, 3, 2} is split to {2} and {3, 2}. {3, 2} is split and then merged to {2, 3} making one comparison. {2} and {2, 3} are merged to {2, 2, 3} also making one comparison, which totals to two comparisons made.
2)


{-17}
Returns: 0

3)


{}
Returns: 0

4)


{-2000000000,2000000000,0,0,0,-2000000000,2000000000,0,0,0}
Returns: 19


This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2010, TopCoder, Inc. All rights reserved.



This problem was used for:
       Single Round Match 151 Round 1 - Division I, Level Two
       Single Round Match 151 Round 1 - Division II, Level Three


topcoder is also on
© 2015 topcoder. All Rights Reserved


public class Main {

    public static void main(String[] args) {
        long principal = 0;
        float annualInterestRate = (float)0.0;
        int periodYears = 0;
        double mortgage = 0;

        final int PERCENTAGE = 100;
        final int MONTHS_IN_YEAR = 12;

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter principal (1K to 1M): ");;
            principal = scanner.nextLong();
        } while (principal < 1_000 || principal > 1_000_000);

        do {
            System.out.println("Enter Annual Interest Rate: ");
            annualInterestRate = scanner.nextFloat();
            if (annualInterestRate <0 || annualInterestRate > 30)
                System.out.println("Value should be 0 to 30%");
            else
                break;
        } while (true);

        do {
            System.out.println("Enter period (Years): ");
            periodYears = scanner.nextInt();
            if (periodYears <1 || periodYears > 30)
                System.out.println("Emter a value between 0 to 30");
            else
                break;
        } while (true);

        mortgage = principal
                * annualInterestRate * Math.pow(1 + annualInterestRate, periodYears)
                / ( Math.pow(1+annualInterestRate, periodYears)- 1);

        System.out.println("Your mortgage is: " + NumberFormat.getCurrencyInstance().format(mortgage));

    }
}

*/