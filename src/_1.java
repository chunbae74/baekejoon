import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _1 {

   public static void main(String[] args) throws IOException{
      // TODO Auto-generated method stub
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      String str = br.readLine();
      String str_arr[] = str.split(" ");

      int k = Integer.parseInt(str_arr[0]); //보유 랜선 수 k
      int n = Integer.parseInt(str_arr[1]); //필요한 랜선의 수 n

      int arr[] = new int[k];
      for(int i=0; i<k; i++) {
         str = br.readLine();
         arr[i] = Integer.parseInt(str);
      }
      Arrays.sort(arr); //랜선 배열 오름차순 정렬

      int idx = 0; 
      int count = 0;
      
      for(int i=0; i<k; i++) {
         int length = arr[i];
         for(int j=0; j<k; j++) {
            count = count + arr[j]/length;
         }
         if(count > n) {
            count = 0;
         }
         else {//count <= n
            idx = i;
            count = 0;
            break;
         }
      }
      
      int hi = arr[idx]*2 + 1;
      int lo = -1;
      
      int result = 0;
      
      boolean checker = true;
      while(checker) {
         
         count = 0;
         
         int mid;
         if(hi+lo <= 1) {
            mid = 1;
         }
         else {
            mid = (hi+lo)/2;
         }
         System.out.println("hi = " + hi + " lo = " + lo + " mid = " + mid);
         for(int i=0; i<k; i++) {
            count = count + arr[i]/mid;
         }
         
         if(count < n) {
            hi = mid;
         }
         else if(count > n) {
            if(count/n >= 2) {
               lo = mid;
            }
            else {
               result = fucking_search(mid, hi, arr, n, lo);
               break;
            }
         }
         else {// count == n
            result = fucking_search(mid, hi, arr, n, lo);
            break;
         }
         
      }
      System.out.print(result);
      br.close();
   }
   public static int fucking_search(int mid, int hi, int arr[], int n, int lo) {
      
      lo = mid-1;
      
      while(lo + 1 < hi) {
         
         mid = (hi + lo)/2;
         int count = 0;
         
         System.out.println("count = " + count + " mid = " + mid);
         
         for(int i=0; i<arr.length; i++) {
            count = count + arr[i]/mid;
         }
         if(count < n) {
            hi = mid;
         }
         else { // count == n, count > n은 불가능
            lo = mid-1;
            count = 0;
            for(int i=0; i<arr.length; i++) {
               count += arr[i]/(mid+1);
            }
            if(count < n) {
               break;
            }
         }
         
      }
      return mid;
   }
   
}