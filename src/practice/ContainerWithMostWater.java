package practice;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] array = new int[]{4,8,1,2,3,9};
        int[] array2 = new int[]{7,1,2,3,9};
        // area = min(a,b) * (bi-ai)
        System.out.println(getMaxWaterContainer(array2));
    }

    // o(n)
    private static int getMaxWaterContainer(int[] height) {
        int maxArea = 0;
        int p1 = 0;
        int p2 = height.length-1;
        while (p1 < p2){
            int linesHeight = Math.min(height[p1],height[p2]);
            int width = p2-p1;
            int newMaxArea = linesHeight * width;
            maxArea = Math.max(newMaxArea, maxArea);
            if (height[p1]  <= height[p2]){
                p1++;
            } else {
                p2--;
            }
        }
        return maxArea;
    }

    // o(n2)
    private static int getMaxWaterContainerBrutal(int[] height) {
        int maxArea = 0;
        for (int i = 0; i <height.length; i++){
            for (int j = i + 1; j <height.length; j++){
                int linesHeight = Math.min(height[i],height[j]);
                int width = j-i;
                int newMaxArea = linesHeight * width;
                if (newMaxArea > maxArea){
                    maxArea = newMaxArea;
                }
            }
        }
        return maxArea;
    }
}
