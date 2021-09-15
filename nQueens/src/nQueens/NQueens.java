package nQueens;

import java.util.Scanner;

public class NQueens {
    static int n;
    static int counter = 1;
    static double totalnum = 0;
    static int[] x;
    static int[] a;
 
    public static void getnext(int k){
        int i;
        int l = n;
        for(i=0; i<=n; i++){
            if(a[i]==x[k]) break;
        }
 
        int m = l;
        totalnum = (Math.pow(m,n+1)-1)/(m-1);
 
        while(i<l){
            i++;
            x[k] = a[i];
            ++counter;
            if(bound(k) == true) return;
        }
        if(i == l){
            x[k] = 0;
        }
    }
 
    public static boolean bound(int k){
        for(int i=1; i<k; i++){
            if(x[k] == x[i] || (k-i) == Math.abs(x[k]-x[i]) ) return false;
        }
        return true;
    }
 
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("input : ");
        n = scanner.nextInt();
        x = new int[n+1];
 
        int k = 1;
 
        for(int i=1; i<=n; i++){
            x[i] = 0;
        }
        a = new int[n+1];
 
        for(int i=0; i<=n; i++){
            a[i] = i;
        }
 
        while(0<k && k<=n){
            getnext(k);
            if(x[k] == 0)
                k--;
            else{
                if(k==n) {
                    for(int i=1; i<=n; i++)
                        System.out.print(x[i] + " ");
                    System.out.println();
                }
                else k++;
            }
        }
        scanner.close();
    }
}

