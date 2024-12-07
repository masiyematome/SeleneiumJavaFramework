package com;

import java.util.Arrays;

public class Main {
    public static void main(String... args){
        int target = 7;
        int[] numbers = {2, 4, 7, 10, 15, 20, 25};
        HandleResult hs = new HandleResult();
        hs.printResult(new BinarySearch(), target,numbers);
        hs.printResult(new LinearSearch(), target,numbers);
    }

}

interface Search{
    int searchForTarget(int target, int... numbers);
}

class LinearSearch implements Search{
    @Override
    public int searchForTarget(int target, int... numbers){
        System.out.println("Using linear");
        for(int i = 0; i < numbers.length - 1; i++){
            if(numbers[i] == target){
                return i;
            }
        }
        return -1;
    }
}

class BinarySearch implements Search{
    @Override
    public int searchForTarget(int target, int... numbers){
        System.out.println("Using binary");
        int start = 0, end = numbers.length - 1;
        while(start <= end){
            int midPoint = start + (end - start) / 2;
            if(target == numbers[midPoint]){
                return midPoint;
            }else if(target > numbers[midPoint]){
                start = midPoint + 1;
            }else{
                end = midPoint - 1;
            }
        }
        return -1;
    }
}

class HandleResult{
    public void printResult(Search search, int target, int... numbers){
        int returnedIndex = search.searchForTarget(target, numbers);
        if(returnedIndex != -1){
            System.out.println("Found " + target + " at index " + returnedIndex);
        }else{
            System.out.println(target + " not found in " + Arrays.toString(numbers));
        }
    }
}