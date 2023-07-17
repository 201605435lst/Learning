package com;

public class TestContniue {
    public static void main(String[] args) {
        aa:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(j + ", ");
                if (j == 3) {
                    break aa;
                }
                System.out.println("----11");
            }
        }
    }
}
