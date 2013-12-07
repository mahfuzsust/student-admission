/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package student_admission;

import java.util.Random;

/**
 *
 * @author Mahfuz
 */
class K_Means {

    public double[] arr;
    public double[] arr_2;
    public double store[][];
    public double store_id[][];
    public double cls[];
    double flag[][];
    int x[];
    int i, p = 0;
    double dist = 999999999;
    double q;
    int t;
    double s[];

    public K_Means(String A[], String B[], int n, int N) {
        
        
        int j;

        //System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        arr = new double[n+5];
        arr_2 = new double[n+5];
        store = new double[N+5][n+5];
        store_id = new double[N+5][n+5];
        cls = new double[N+5];
        x = new int[N + 2];
        s = new double[N+5];
        
        for (i = 0; i < n; i++) {
            this.arr[i] = Double.parseDouble(A[i]);
        }
        
        for (i = 0; i < n; i++) {
            this.arr_2[i] = Double.parseDouble(B[i]);
        }
        
        Random r = new Random();
        for (i = 0; i < N; i++) {
            p = (r.nextInt(500000) + 0) % n;
            double xy = (double) (Math.floor(arr[p] * 100)) / 100;
            cls[i] = xy;
        }
        System.out.print("The centroid list ");
        for (i = 0; i < N; i++) {
            System.out.print(cls[i] + " ");
        }
        System.out.println();

        double temp;
        for (i = 1; i < N; i++) {
            int flagk = 0;
            for (j = i - 1; j >= 0 && flagk == 0; j--) {
                flagk = 1;
                if (cls[j + 1] > cls[j]) {
                    temp = cls[j + 1];
                    cls[j + 1] = cls[j];
                    cls[j] = temp;
                    flagk = 0;
                }
            }
        }
        System.out.print("The centroid list ");
        for (i = 0; i < N; i++) {
            System.out.print(cls[i] + " ");
        }
        System.out.println();


        double dum = 2000;

        while (dum > 0.00) {
            //System.out.println(n);
            for (i = 0; i < N; i++) {
                for (j = 0; store[i][j] != 0; j++) {
                    store[i][j] = 0;
                }
            }

            System.out.print("The centroid list updated ");
            for (i = 0; i < N; i++) {
                System.out.print(cls[i] + " ");
            }
            System.out.println();

            for (i = 0; i < n; i++) {
                dist = 999999;
                for (j = 0; j < N; j++) {
                    q = Math.abs(arr[i] - cls[j]);
                    if (q <= dist) {
                        dist = q;
                        p = j;
                    }
                }
                for (j = 0; j < store[p].length; j++) {
                    if (store[p][j] == 0) {
                        break;
                    }
                }
                store[p][j] = arr[i];
                store_id[p][j] = arr_2[i];

            }

            System.out.println("The clusters are");
            for (i = 0; i < N; i++) {
                for (j = 0; store[i][j] != 0; j++) {
                    System.out.print(store[i][j] + " ");
                }
                System.out.println();
            }

            for (i = 0; i < N; i++) {
                s[i] = cls[i];
            }

            double sum;
            double mean;
            for (i = 0; i < N; i++) {
                sum = 0;
                for (j = 0; store[i][j] != 0; j++) {
                    sum = sum + store[i][j];
                }
                x[i] = j;
                if (j != 0) {
                    mean = sum / j;
                } else {
                    mean = 0;
                }
                sum = mean;
                //sum = (double) (Math.floor(mean * 100)) / 100;
                cls[i] = sum;
            }

            dum = 0;
            double pq;
            for (i = 0; i < N; i++) {
                pq = Math.abs(s[i] - cls[i]);
                dum = dum + pq;
            }

            System.out.println("dum " + dum);


            double mark = 0.00000;
            if ((dum - mark) <= 0.005) {
                break;
            }

        }

        x[N] = n;

    }
}