class Pair implements Comparable<Pair> {
    int idx;
    int sum;

    public Pair(int idx, int sum) {
        this.idx = idx;
        this.sum = sum;
    }

    @Override
    public int compareTo(Pair other) {
        if (this.sum != other.sum) {
            return Integer.compare(this.sum, other.sum);
        }
        return Integer.compare(this.idx, other.idx);
    }

}

class Solution {
    public int minimumPairRemoval(int[] nums) {
        int pair = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums)
            list.add(num);
        while (!checkSorted(list)) {
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            for (int i = 1; i < list.size(); i++) {
                int num1 = list.get(i - 1);
                int num2 = list.get(i);
                pq.add(new Pair(i, num1 + num2));
            }
            Pair temp = pq.poll();
            list.remove(temp.idx);
            list.set(temp.idx - 1, temp.sum);
            pair++;

        }

        return pair;
    }

    private static boolean checkSorted(ArrayList<Integer> list) {
        int n = list.size();
        System.out.println(list);
        if (n == 1)
            return true;
        for (int i = 0; i < n - 1; i++) {
            if (list.get(i) > list.get(i + 1))
                return false;
        }
        return true;
    }
}
