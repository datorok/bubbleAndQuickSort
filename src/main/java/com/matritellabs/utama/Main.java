package com.matritellabs.utama;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static ArrayList bubblesort(ArrayList<Integer> list) {

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    int temp = list.get(j + 1);
                    list.set(j + 1, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        return list;
    }

    // function quicksort(array)
    //     var list less, equal, greater
    //     if length(array) ≤ 1
    //         return array
    //     select a pivot value pivot from array
    //     for each x in array
    //         if x < pivot then append x to less
    //         if x = pivot then append x to equal
    //         if x > pivot then append x to greater
    //     return concatenate(quicksort(less), equal, quicksort(greater))

    public static ArrayList<Integer> quicksort(ArrayList<Integer> list) {

        List<Integer> less = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();

        if (list.size() <= 1) {
            return list;
        }

        int pivotValue = list.get(list.size() / 2);
        //System.out.println("pivotValue = " + pivotValue);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < pivotValue) {
                less.add(list.get(i));
            } else if (list.get(i) == pivotValue) {
                equal.add(list.get(i));
            } else if (list.get(i) > pivotValue) {
                greater.add(list.get(i));
            }
        }

        List <Integer> returnlist = new ArrayList<>();
        returnlist.addAll(quicksort((ArrayList<Integer>) less));
        returnlist.addAll(equal);
        returnlist.addAll(quicksort((ArrayList<Integer>) greater));

        return (ArrayList<Integer>) returnlist;
    }

    public static void main(String[] args) {

        List<Integer> testlistForBubbleSorting = new ArrayList<>();
        testlistForBubbleSorting.add(58);
        testlistForBubbleSorting.add(53);
        testlistForBubbleSorting.add(4);
        testlistForBubbleSorting.add(58);
        testlistForBubbleSorting.add(1004);
        testlistForBubbleSorting.add(8);
        testlistForBubbleSorting.add(58);
        testlistForBubbleSorting.add(0);
        testlistForBubbleSorting.add(58);
        testlistForBubbleSorting.add(-5);
        testlistForBubbleSorting.add(39);

        bubblesort((ArrayList<Integer>) testlistForBubbleSorting);
        System.out.println("Bubble: ");
        for (Integer i : testlistForBubbleSorting) {
            System.out.print(i + ", ");
        }
        System.out.println();

        List<Integer> testlistFoQuickSorting = new ArrayList<>();
        testlistFoQuickSorting.add(58);
        testlistFoQuickSorting.add(53);
        testlistFoQuickSorting.add(4);
        testlistFoQuickSorting.add(58);
        testlistFoQuickSorting.add(1004);
        testlistFoQuickSorting.add(8);
        testlistFoQuickSorting.add(58);
        testlistFoQuickSorting.add(0);
        testlistFoQuickSorting.add(58);
        testlistFoQuickSorting.add(-5);
        testlistFoQuickSorting.add(39);

        List <Integer> quickesorted = quicksort((ArrayList<Integer>) testlistFoQuickSorting);
        System.out.println("Quick: ");
        for (Integer i : quickesorted) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}
