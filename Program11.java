import java.io.*;
import java.util.*;
public class Program11 {
    // merge the two sorted array
    // the given two arrays are either ascending or descending
    // the resultant array should be ascending order
    public static boolean isAscending(int[] ar){
        for(int i=0; i<ar.length-1; i++){
            if(ar[i]>ar[i+1]) return false;
        }
        return true;
    }
    public static final Scanner sn = new Scanner(System.in);
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        int n = sn.nextInt();
        int[] A = new int[n];
        for(int i=0; i<n; i++){
            A[i] = sn.nextInt();
        }
        int m = sn.nextInt();
        int[] B = new int[m];
        for(int i=0; i<m; i++){
            B[i] = sn.nextInt();
        }
        int[] C = new int[n+m];
        int signA = 1, signB = 1;
        // if(!isAscending(A)){
        //     signA = -1;
        // }
        // if(!isAscending(B)){
        //     signB = -1;
        // }
        // int i = signA==1?0:n-1, j = signB==1?0:m-1, k=0;
        // while((i<n||i>=0)&&(j<m||j>=0)){
        //     if(A[i]<=B[j]){
        //         if(k>0&&C[k-1]!=A[i]){
        //             C[k++] = A[i];
        //         }
        //         i += signA;
        //     }else{
        //         if(k>0&&C[k-1]!=B[j]){
        //             C[k++] = B[j];
        //         }
        //         j += signB;
        //     }
        // }
        // while(i<n||i>=0){
        //     if(k>0&&C[k-1]!=A[i]){
        //         C[k++] = A[i];
        //     }
        //     i+=signA;
        // }
        // while(j<n||j>=0){
        //     if(k>0&&C[k-1]!=B[j]){
        //         C[k++] = B[j];
        //     }
        //     j+=signB;
        // }
        int i=0, j=0, k=0, lenA = n-1, lenB = m-1;
        while(i<=lenA&&j<=lenB){
            if(A[i]<=A[lenA]&&A[i]<=B[j]&&A[i]<=B[lenB]){
                if(k>0&&C[k-1]!=A[i]){
                    C[k++] = A[i];
                }else if(k==0) C[k++] = A[i];
                i++;
            }else if(A[lenA]<=A[i]&&A[lenA]<=B[j]&&A[lenA]<=B[lenB]){
                if(k>0&&C[k-1]!=A[lenA]){
                    C[k++] = A[lenA];
                }else if(k==0) C[k++] = A[lenA];
                lenA--;
            }else if(B[j]<=A[i]&&B[j]<=A[lenA]&&B[j]<=B[lenB]){
                if(k>0&&C[k-1]!=B[j]){
                    C[k++] = B[j];
                }else if(k==0) C[k++] = B[j];
                j++;
            }else if(B[lenB]<=A[i]&&B[lenB]<=A[lenA]&&B[lenB]<=B[j]){
                if(k>0&&C[k-1]!=B[lenB]){
                    C[k++] = B[lenB];
                }else if(k==0) C[k++] = B[lenB];
                lenB--;
            }
        }
        while(i<=lenA){
            if(k>0&&C[k-1]!=A[i])
                C[k++] = A[i];
            i++;
        }
        while(j<=lenB){
            if(k>0&&C[k-1]!=B[j])
                C[k++] = B[j];
            j++;
        }

        for(i=0; i<k; i++){
            System.out.print(C[i]+" ");
        }

    }
    // 9 9 6 3 , 5 7 8 9
}
