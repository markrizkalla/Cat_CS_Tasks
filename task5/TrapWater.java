package leetcode;

public class TrapWater {

    public static void main(String[] args){
        int[] arr = {4,2,0,3,2,5};
        new TrapWater().trap(arr);
    }


    public int trap(int[] height) {

        int[] maxLeft = new int[height.length];
        int[] maxright = new int[height.length];

        int maxLeftInt = 0;
        int maxRightInt = 0;
        for (int i = 0; i < height.length; i++) {

            if (height[i] > maxLeftInt){
                maxLeftInt = height[i];
                maxLeft[i] = maxLeftInt;
            }else{
                maxLeft[i] = maxLeftInt;
            }


            if (height[height.length - 1 - i] > maxRightInt){
                maxRightInt = height[height.length - 1 - i];
                maxright[height.length - 1 - i] = maxRightInt;
            }else{
                maxright[height.length - 1 - i] = maxRightInt;
            }

        }

        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int x = Math.min(maxLeft[i],maxright[i]) - height[i];
            if (x > 0)
                sum += x;
        }

        System.out.println(sum);
        return sum;
    }
}
