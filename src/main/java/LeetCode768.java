public class LeetCode768 {
    public static void main(String[] args) {
        System.out.println(new LeetCode768().maxChunksToSorted(new int[]{2, 1, 3, 4, 4}));
    }

    public int maxChunksToSorted(int[] arr) {

        int max = arr[0];
        int res = 1;

        out:
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }


            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < max) {
                    continue out;
                }
            }
            res++;
        }

        return res;
    }
}
