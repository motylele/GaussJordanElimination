import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> change = new ArrayList<>();
        double r;
        int n;
        System.out.println("Podaj stopień n macierzy");
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        double[][] A = new double[n][n];
        double[][] I = new double[n][n];
        for (int i=0; i<n; i++){
            System.out.println("Podaj " + (i+1) +" wiersz");
            for(int j=0; j<n; j++){
                A[i][j]=scanner.nextDouble();
            }
        }
        for(int i=0; i<n; i++){
            System.out.print(Arrays.toString(A[i]));
            Arrays.fill(I[i], 0);
            I[i][i] = 1;
            System.out.println(Arrays.toString(I[i]));
        }
        for(int i=0; i<n; i++){
            if(A[i][i] == 0){
                for(int j=0; j<n; j++){
                    if(j!=i){
                        if(A[j][i] != 0 && A[i][j] != 0){
                            swap(i,j,n,A);
                            change.add(i);
                            change.add(j);
                            break;
                        }
                    }
                }
            }
        }
        for(int i=0; i<n; i++){
            if(A[i][i] == 0){
                System.out.println("Macierz odwrotna nie istnieje");
                System.exit(0);
            }
            for(int j=0; j<n; j++){
                if(i!=j){
                    r = A[j][i]/A[i][i];
                    for(int k=0; k<n; k++){
                        A[j][k] = A[j][k] - r * A[i][k];
                        I[j][k] = I[j][k] - r * I[i][k];
                    }
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                I[i][j] = I[i][j]/A[i][i];
                I[i][j] = Math.round(I[i][j]*100000)/100;
                I[i][j] /= 1000;
            }
        }

        double buf;
        while(change.size() != 0){
            for(int k=0; k<n; k++){
                buf = I[k][change.get(change.size()-1)];
                I[k][change.get(change.size()-1)] = I[k][change.get(change.size()-2)];
                I[k][change.get(change.size()-2)] = buf;
            }
            change.remove(change.size()-1);
            change.remove(change.size()-1);
        }

        System.out.println();

        for(int i=0; i<n; i++) {
            System.out.println(Arrays.toString(I[i]));
        }
    }

    public static void swap(int i, int j, int n, double[][] A) {
        double buf;
        for(int k=0; k<n; k++){
            buf = A[i][k];
            A[i][k] = A[j][k];
            A[j][k] = buf;
        }
    }
}