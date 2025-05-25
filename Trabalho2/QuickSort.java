package Merge;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class QuickSort {

    // Partition function
    static int partition(int[] arr, int low, int high) {
        
        // Choose the pivot
        int pivot = arr[high];
        
        // Index of smaller element and indicates 
        // the right position of pivot found so far
        int i = low - 1;

        // Traverse arr[low..high] and move all smaller
        // elements to the left side. Elements from low to 
        // i are smaller after every iteration
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        
        // Move pivot after smaller elements and
        // return its position
        swap(arr, i + 1, high);  
        return i + 1;
    }

    // Swap function
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // The QuickSort function implementation
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            
            // pi is the partition return index of pivot
            int pi = partition(arr, low, high);

            // Recursion calls for smaller elements
            // and greater or equals elements
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    
    private static double convertTimeElapsed(long timeElapsed) {
		return ((double) timeElapsed) / 1_000_000;
	}

    public static void main(String[] args) {
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
    	
        //int[] arr = {10, 7, 8, 9, 1, 5};
        //int n = arr.length;
		int n = conjuntoDados.length;
		
		long timeElapsed = System.nanoTime();
      
        //quickSort(arr, 0, n - 1);
		quickSort(conjuntoDados, 0, n - 1);
		
		timeElapsed = System.nanoTime() - timeElapsed;
        
        for (int val : conjuntoDados) {
            System.out.println(val);  
        }
        
        System.out.println("IDX = " + idx);
        System.out.println("TIME ELAPSED = " + convertTimeElapsed(timeElapsed) + " ms");
    }
}
