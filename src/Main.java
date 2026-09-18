import java.lang.Math.*;
import java.util.*;

public class Main {
  private static double e3(double x) {
    return Math.pow(
        2 / (0.5 - Math.pow(Math.exp(x) / 2, Math.pow(x * (0.5 - x), 3))), Math.exp(Math.cos(x)));
  }

  private static double eDedicated(double x) {
    return Math.log(Math.abs((0.5 + Math.exp(x)) / 2 / 3));
  }

  private static double eDefault(double x) {
    return Math.asin(
        Math.exp(Math.cbrt(-Math.pow(2 * Math.PI * Math.abs(x), 2) / (Math.abs(x) + 1))));
  }

  private static void printMatrix(double[][] e) {
    for (int i = 0; i < 12; i++) {
      for (int j = 0; j < 13; j++) {
        System.out.printf("% 9.4f", e[i][j]);
      }
      System.out.println();
    }
  }

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

    System.out.println(Arrays.toString(x) + "\n");

    double[][] e1 = new double[12][13];
    for (int i = 0; i < 12; i++) {
      for (int j = 0; j < 13; j++) {
        switch (e[i]) {
          case 3:
            e1[i][j] = e3(x[j]);
            break;

          case 7, 11, 15, 17, 19, 21:
            e1[i][j] = eDedicated(x[j]);
            break;
          default:
            e1[i][j] = eDefault(x[j]);
        }
      }
    }

    printMatrix(e1);
  }
}
