class Solution {
    public boolean canAliceWin(int n) {
        int x = 10;
        int count = 0;

        while (n >= x) {
            n = n - x;
            x--;
            count++;
        }

        return count % 2 == 1;
    }
}