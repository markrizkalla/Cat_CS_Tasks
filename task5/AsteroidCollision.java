package leetcode;

import java.util.Arrays;
import java.util.Collection;
import java.util.Stack;

public class AsteroidCollision {

    public static void main(String[] args){
        int[] arr = {5,10,-5};
       int[] arr2 = new AsteroidCollision().asteroidCollision(arr);
        System.out.println(arr2);
    }

    public int[] asteroidCollision(int[] asteroids) {
        int j = 0;
        while(asteroids[j] <= 0){

            j++;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = j; i < asteroids.length; i++) {
            if (asteroids[i] > 0){
                stack.push(asteroids[i]);
            }else{
                int x = stack.pop();
                if (x > Math.abs(asteroids[i])){
                    stack.push(x);
                }else if (x < Math.abs(asteroids[i])){
                    while (!stack.empty()){
                        int z = stack.pop();
                        if (z > Math.abs(asteroids[i])){
                            stack.push(z);
                            break;
                        }
                    }
                }
            }
        }

        int[] arr = new int[stack.size() + j];
        for (int i = 0; i < j; i++) {
            arr[i] = asteroids[i];
        }
        int k = stack.size()-1 + j;
        while (!stack.empty()){
            arr[k--] = stack.pop();
        }

        return arr;
    }
}
