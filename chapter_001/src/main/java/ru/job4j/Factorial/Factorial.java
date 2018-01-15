package ru.job4j.Factorial;

public class Factorial {
    public int calc(int n) {
        int s=1;
      for (int i=1;i<=n;i++){
        s=s*i;
    }
    return s;
}
}
