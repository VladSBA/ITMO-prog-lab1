import java.lang.Math.*;
import java.util.*;

public class Main {
  public static void main(String[] args) {

    int[] e = new int[12];
    for (int i = 0; i < 12; i++) {
      e[i] = 23 - 2 * i;
    }

    System.out.println(Arrays.toString(e));

    double[] x = new double[13];
    for (int i = 0; i < 13; i++) {
      x[i] = Math.random() * 24 - 15;
    }

    System.out.println(Arrays.toString(x));

    double[][] e2 = new double[12][13];
    for (int i = 0; i < 12; i++) {
      for (int j = 0; j < 13; j++) {
        switch (e[i]) {
          case 3:
            e2[i][j] =
                Math.pow(
                    2 / (0.5 - Math.pow(Math.exp(x[j]) / 2, Math.pow(x[j] * (0.5 - x[j]), 3))),
                    Math.exp(Math.cos(x[j])));

            break;

          case 7, 11, 15, 17, 19, 21:
            e2[i][j] = Math.log(Math.abs((0.5 + Math.exp(x[j])) / 2 / 3));
            break;
          default:
            e2[i][j] =
                Math.asin(
                    Math.exp(
                        Math.cbrt(
                            -Math.pow(2 * Math.PI * Math.abs(x[j]), 2) / (Math.abs(x[j]) + 1))));
        }

        System.out.printf("%.4f  ", e2[i][j]);
      }
      System.out.println();
    }
  }
}
