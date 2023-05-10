package Esercizio2;
import java.util.Arrays;

import Threads.Thread1;
import Threads.Thread2;
import Threads.Thread3;

public class Esercizio2 {
    public static void main(String[] args) {
        int[] numbers = generateRandomNumbers(3000);
        int partitionSize = numbers.length / 3;

        int[] partialSums = new int[3]; // Array per memorizzare i risultati parziali

        // Creazione dei thread
        Thread thread1 = new Thread(new Thread1(numbers, 0, partitionSize - 1, partialSums, 0));
        Thread thread2 = new Thread(new Thread2(numbers, partitionSize, 2 * partitionSize - 1, partialSums, 1));
        Thread thread3 = new Thread(new Thread3(numbers, 2 * partitionSize, numbers.length - 1, partialSums, 2));

        // Avvio dei thread
        thread1.start();
        thread2.start();
        thread3.start();

        // Attesa della terminazione dei thread
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Calcolo della somma totale
        int totalSum = Arrays.stream(partialSums).sum();

        // Stampa della somma totale
        System.out.println("Somma totale: " + totalSum);
    }

    private static int[] generateRandomNumbers(int count) {
        int[] numbers = new int[count];
        for (int i = 0; i < count; i++) {
            numbers[i] = (int) (Math.random() * 100);
        }
        return numbers;
    }
}
