package com.ferchoo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

    public int comparisons;
    private int MAXARRAY = 50;

    public int howManyComparisons(int[] numbers){
        comparisons = 0;

        List a = new ArrayList(numbers.length);

        int index = 0;

        while (index < numbers.length) {
            a.add(numbers[index]);
            index++;
        }

        List b = mergeSort(a);

        // System.out.println("Sorted: " + b.toString());

        return comparisons;
    }

    public List merge (List b, List c) {
 /*       List merge(List b, List c)
        1. create an empty list a
        2. while both b and c are not empty, compare the first elements of b and c
        first(b) < first(c): remove the first element of b and append it to the end of a
        first(b) > first(c): remove the first element of c and append it to the end of a
        first(b) = first(c): remove the first elements of b and c and append them to the end of a
        3. if either b or c is not empty, append that non-empty list to the end of a
        4. return a
  */

        List b1 = new ArrayList<>();
        List c1 = new ArrayList<>();

        b1.addAll(b);
        c1.addAll(c);

        List a = new ArrayList<>();

        //System.out.printf("B Split %d, C Split %d \n",b1.size(),c1.size());

        while ( !b1.isEmpty() && !c1.isEmpty() ) {
            // comparison
            comparisons++;

            int valueB = (int)b1.get(0);
            int valueC = (int)c1.get(0);

            if (valueB < valueC) {
                a.add(b1.get(0));
                b1.remove(0);
            } else if (valueB > valueC) {
                a.add(c1.get(0));
                c1.remove(0);
            } else if (valueB == valueC) {
                a.add(b1.get(0));
                b1.remove(0);

                a.add(c1.get(0));
                c1.remove(0);
            }
        }

        // insert not empty B
        a.addAll(b1.subList(0,b1.size()));

        // insert not empty C
        a.addAll(c1.subList(0,c1.size()));

        //System.out.printf("Merge " + a.toString() + "\n");

        return a;
    }

    public List mergeSort (List a) {
        /*
List mergeSort(List a)
1. if size(a) <= 1, return a
2. split a into two sublists b and c
   if size(a) = 2*k, b contains the first k elements of a, c the last k elements
   if size(a) = 2*k+1, b contains the first k elements of a, c the last k+1 elements
3. List sb = mergeSort(b)
   List sc = mergeSort(c)
4. return merge(sb, sc)
         */
        int sizeListA = a.size();
        int kListA = a.size() / (int)2;
        List b;
        List c;
        List sb;
        List sc;

        //System.out.printf("List A Size %d, K %d\n",sizeListA,kListA);

        if (sizeListA <= 1) return a;
        else {
            b = a.subList(0,kListA);
            c = a.subList(kListA,sizeListA);
        }

        //System.out.printf("List A " + a.toString() + "\n");
        //System.out.printf("List B " + b.toString() + "\n");
        //System.out.printf("List C " + c.toString() + "\n");

        sb = mergeSort(b);
        sc = mergeSort(c);

        return merge(sb,sc);
    }

}
