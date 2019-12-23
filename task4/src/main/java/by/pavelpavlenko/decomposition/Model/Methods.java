package by.pavelpavlenko.decomposition.Model;

class Methods {

    int nod(int a, int b) {

        int tmp;
        while (a != 0 && b != 0) {
            a %= b;
            tmp = a;
            a = b;
            b = tmp;
        }
        return a + b;
    }

    private int nok(int a, int b) {
        return a / nod(a, b) * b;
    }

    int nok(int a, int b, int c) {
        return nok(a, nok(b, c));
    }

    int digitsInNumber(int a) {

        int counter = 0;
        a = Math.abs(a);
        if (a == 0) counter++;
        else {
            while (a >= 1) {
                a = a / 10;
                counter++;
            }
        }
        return counter;
    }

    long oddDigitsCount(int n) {
        long sum = 0;
        for (int i = (int) (Math.pow((double)10, (double)n-1) + 1); i < (int)Math.pow((double)10, (double)n); i += 2) {
            boolean flag = false;
            long b = i;
            for (int j = n; j > 0; j--) {
                if (b % 2 == 0) {
                    flag = true;
                }
                b = b / 10;
            }
            if (!flag) {
                sum += i;
            }
        }
        return sum;
    }

    int countEvenDigits(long counterSum) {
        int count = 0;
        while (counterSum > 10) {
            if (counterSum % 2 == 0) count++;
            counterSum /= 10;
        }
        return count;
    }
}
