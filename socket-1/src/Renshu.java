class Renshu {

    // xを2倍にして返す関数
    public int doubleValue(int x) {
        return x * 2;
    }

    // ここに続きを実装していく。
    public int sumUpToN(int x) {
        int sum = 0;
        for (int i = 1; i <= x; i++) {
            sum += i;
        }
        return sum;
    }

    public int sumFromPtoQ(int x, int y) {
        int sum = 0;
        if (x > y) {
            return -1;
        } else {
            for (int i = x; i <= y; i++) {
                sum += i;
            }
            return sum;
        }
    }

    public int sumFromArrayIndex(int[] a, int index) {
        int sum = 0;

        if (0 <= index && index < a.length) {
            for (int i = index; i < a.length; i++) {
                sum += a[i];
            }
            return sum;
        } else {
            return -1;
        }
    }

    public int selectMaxValue(int[] a) {
        int max = a[0];
        for (int i : a) {
            if (max < i) {
                max = i;
            }
        }
        return max;
    }

    public int selectMinValue(int[] a) {
        int min = a[0];
        for (int i : a) {
            if (min > i) {
                min = i;
            }
        }
        return min;
    }

    public int selectMaxIndex(int[] a) {
        int max = a[0];
        int count = -1;
        int index = 0;

        for (int i : a) {
            count++;
            if (max < i) {
                max = i;
                index = count;
            }
        }
        return index;
    }

    public int selectMinIndex(int[] a) {
        int min = a[0];
        int count = -1;
        int index = 0;

        for (int i : a) {
            count++;
            if (min > i) {
                min = i;
                index = count;
            }
        }
        return index;
    }

    public void swapArrayElements(int[] a, int i, int j) {
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public boolean swapTwoArrays(int[] a, int[] b) {
        int[] temp = new int[a.length];

        if (a.length == b.length) {
            for (int i = 0; i < a.length; i++) {
                temp[i] = a[i];
                a[i] = b[i];
                b[i] = temp[i];
            }
            return true;
        }else{
            return false;
        }
    }
}