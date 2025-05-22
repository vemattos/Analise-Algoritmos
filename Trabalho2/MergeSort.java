package Merge;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class MergeSort {
    void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    void sort(int arr[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            sort(arr, l, m);
            sort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    private static double convertTimeElapsed(long timeElapsed) {
        return ((double) timeElapsed) / 1_000_000;
    }

    public static void main(String args[]) {
        int conjuntoDados[] = new int[100000];
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

        MergeSort ob = new MergeSort();
        long timeElapsed = System.nanoTime();

        ob.sort(conjuntoDados, 0, conjuntoDados.length - 1);

        timeElapsed = System.nanoTime() - timeElapsed;
        printArray(conjuntoDados);
        System.out.println("TIME ELAPSED = " + convertTimeElapsed(timeElapsed) + " ms");

    }
}