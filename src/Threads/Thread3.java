package Threads;

public class Thread3 implements Runnable {
    private int[] numbers;
    private int start;
    private int end;
    private int[] partialSums;
    private int index;

    public Thread3(int[] numbers, int start, int end, int[] partialSums, int index) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
        this.partialSums = partialSums;
        this.index = index;
    }


    @Override
    public void run() {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += numbers[i];
        }
        partialSums[index] = sum;

        System.out.println("Risultato parziale del Thread1: " + sum);
    }
}
