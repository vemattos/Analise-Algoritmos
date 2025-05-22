package Merge;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BubbleSort {

    private static double convertTimeElapsed(long timeElapsed) {
        return ((double) timeElapsed) / 1_000_000;
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean trocou;

        for (int i = 0; i < n - 1; i++) {
            trocou = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    trocou = true;
                }
            }

            if (!trocou) {
                break;
            }
        }
    }

    public static void imprimirArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] conjuntoDados = new int[100000];
        int idx = 0;

        File myFile = new File("Merge/conjuntoDados1.txt");
        try {
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                conjuntoDados[idx] = Integer.parseInt(data);
                idx++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int[] dadosValidos = new int[idx];
        System.arraycopy(conjuntoDados, 0, dadosValidos, 0, idx);

        long timeElapsed = System.nanoTime();

        bubbleSort(dadosValidos);
        timeElapsed = System.nanoTime() - timeElapsed;

        imprimirArray(dadosValidos);
        System.out.println("TIME ELAPSED = " + convertTimeElapsed(timeElapsed) + " ms");

    }
}
