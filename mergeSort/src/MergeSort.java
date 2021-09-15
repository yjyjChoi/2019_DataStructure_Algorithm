import java.util.Arrays;
 
public class MergeSort {
    static int[] sorted = new int[8];
    
    public static void merge(int a[], int m, int middle, int n) {
        int i = m;             
        int j = middle+1;    
        int k = m;          
        
        while(i<=middle && j<=n) {
            if(a[i]<=a[j]) {
                sorted[k] = a[i];
                i++;
            }else {
                sorted[k] = a[j];
                j++;
            }
            k++;
        }
        if(i>middle) {
            for(int t=j;t<=n;t++,k++) {
                sorted[k] = a[t];
            }
        }else {
            for(int t=i;t<=middle;t++,k++) {
                sorted[k] = a[t];
            }
        }
        
        for(int t=m;t<=n;t++) {
            a[t] = sorted[t];
        }
        System.out.println("after MergeSort: "+Arrays.toString(a));
    }
    
    public static void mergeSort(int a[], int m, int n) {
        int middle;
        if(m<n) {
            middle = (m+n)/2;
            mergeSort(a, m, middle);    
            mergeSort(a, middle+1, n);   
            merge(a, m, middle, n);      
        }
    }
    public static void main(String[] args) {
        int[] data = {124,17,65,10,24,2,81,55};
        int size = data.length;
        System.out.println("before starting: "+Arrays.toString(data));
        System.out.println("---------------MergeSort start----------------");
        mergeSort(data, 0, size-1);
    }
}