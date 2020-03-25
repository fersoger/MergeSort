package com.ferchoo;

import java.util.Arrays;

public class MergeSort {

    public int comparisons;
    private int MAXARRAY = 50;

    public int howManyComparisons(int[] numbers){
        comparisons = 0;

        mergeSort(numbers);

        return comparisons;

    }

    public int[] merge (int[] b, int[] c) {
 /*       List merge(List b, List c)
        1. create an empty list a
        2. while both b and c are not empty, compare the first elements of b and c
        first(b) < first(c): remove the first element of b and append it to the end of a
        first(b) > first(c): remove the first element of c and append it to the end of a
        first(b) = first(c): remove the first elements of b and c and append them to the end of a
        3. if either b or c is not empty, append that non-empty list to the end of a
        4. return a
  */


        int lengthB = b.length;
        int lengthC = c.length;

        //System.out.printf("B Split %d, C Split %d \n",lengthB,lengthC);

        int[] a = new int[lengthB+lengthC];

        int indexA = 0;
        int indexB = 0;
        int indexC = 0;

        while ( indexB < lengthB && indexC < lengthC ) {
            // comparison
            comparisons++;
            if (b[indexB] < c[indexC]) {
                a[indexA] = b[indexB];
                indexA++;
                indexB++;
            } else if (b[indexB] > c[indexC]) {
                a[indexA] = c[indexC];
                indexA++;
                indexC++;
            } else if (b[indexB] == c[indexC]) {
                a[indexA] = b[indexB];
                indexA++;
                indexB++;

                a[indexA] = c[indexC];
                indexA++;
                indexC++;
            }
        }

        // insert not empty B
        while ( indexB < lengthB){
            a[indexA] = b[indexB];
            indexA++;
            indexB++;
        }

        // insert not empty C
        while ( indexC <  lengthC){
            a[indexA] = c[indexC];
            indexA++;
            indexC++;
        }

        //System.out.printf("Merge " + Arrays.toString(a) + "\n");

        return a;
    }

    public int[] mergeSort (int[] listA) {
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
        int sizeListA = listA.length;
        int kListA = listA.length / (int)2;
        int listB[];
        int listC[];
        int listSB[];
        int listSC[];

        //System.out.printf("List A Size %d, K %d\n",sizeListA,kListA);

        if (sizeListA <= 1) return listA;
        else {
            listB = Arrays.copyOfRange(listA,0,kListA);
            listC = Arrays.copyOfRange(listA,kListA,sizeListA);
        }
/*
        System.out.printf("List A " + Arrays.toString(listA) + "\n");
        System.out.printf("List B " + Arrays.toString(listB) + "\n");
        System.out.printf("List C " + Arrays.toString(listC) + "\n");
*/
        listSB = mergeSort(listB);
        listSC = mergeSort(listC);

        return merge(listSB,listSC);
    }

}
