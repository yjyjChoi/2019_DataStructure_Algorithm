package quickSort;

import java.util.Arrays;

public class QuickSort {
    public void quickSort(int[] data, int b, int e){
        int f = b;
        int r = e;
        int pivot = data[(b + e)/2];
        System.out.println(Arrays.toString(data));

        do {
            while(data[f] < pivot) 
              f++;
            while(data[r] > pivot) 
              r--;
            if(f <= r){    
                int tmp = data[f];
                data[f] = data[r];
                data[r] = tmp;
                f++;
                r--;
            }
        } while (f <= r);
        
        // 왼쪽 정렬
        if(b < r) 
          quickSort(data, b, r); 
      
        // 오른쪽 정렬 
        if(e > f) 
          quickSort(data, f, e); 
    }
    
    public static void main(String[] args) {
        int data[] = {6, 5, 1, 4, 7, 2, 3};
        QuickSort quick = new QuickSort();
        quick.quickSort(data, 0, data.length - 1);
        System.out.println("fianl: " + Arrays.toString(data));
    }
}
