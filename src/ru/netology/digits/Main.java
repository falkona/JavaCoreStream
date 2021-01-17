package ru.netology.digits;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        int[] positive = new int[intList.size()];
        int j = 0;
        for (int i : intList) {
            if (i > 0) {
                positive[j] = i;
                j++;
            }
        }
        int[] even = new int[positive.length];
        j = 0;
        for (int i : positive) {
            if (i % 2 == 0) {
                even[j] = i;
                j++;
            }
        }
        bubbleSorter(even);
        for (int i : even) {
            if (i > 0) {
                System.out.println(i);
            }
        }
    }

    public static void bubbleSorter(int[] unsorted){
        int count = unsorted.length;
        for (int out = count - 1; out >= 1; out--){
            for (int in = 0; in < out; in++){
                if(unsorted[in] > unsorted[in + 1])
                    toSwap(unsorted, in, in + 1);
            }
        }
    }

    public static void toSwap(int[] unsorted, int first, int second){
        int dummy = unsorted[first];
        unsorted[first] = unsorted[second];
        unsorted[second] = dummy;
    }
}
