package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[][] village = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                village[i][j] = scanner.nextInt();
            }
        }

        int maxMosquitoes = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 십자 모양 물풍선 터트리기
                int mosquitoes = bombCross(village, N, M, i, j);
                maxMosquitoes = Math.max(maxMosquitoes, mosquitoes);

                // 엑스 자 모양 물풍선 터트리기
                mosquitoes = bombX(village, N, M, i, j);
                maxMosquitoes = Math.max(maxMosquitoes, mosquitoes);
            }
        }

        System.out.println(maxMosquitoes);

        scanner.close();
    }

    // 십자 모양 물풍선 터트리기
    private static int bombCross(int[][] village, int N, int M, int x, int y) {
        int mosquitoes = village[x][y];

        for (int i = 1; i <= M; i++) {
            if (x - i >= 0) {
                mosquitoes += village[x - i][y];
            }
            if (x + i < N) {
                mosquitoes += village[x + i][y];
            }
            if (y - i >= 0) {
                mosquitoes += village[x][y - i];
            }
            if (y + i < N) {
                mosquitoes += village[x][y + i];
            }
        }

        return mosquitoes;
    }

    // 엑스 자 모양 물풍선 터트리기
    private static int bombX(int[][] village, int N, int M, int x, int y) {
        int mosquitoes = village[x][y];

        for (int i = 1; i <= M; i++) {
            if (x - i >= 0 && y - i >= 0) {
                mosquitoes += village[x - i][y - i];
            }
            if (x - i >= 0 && y + i < N) {
                mosquitoes += village[x - i][y + i];
            }
            if (x + i < N && y - i >= 0) {
                mosquitoes += village[x + i][y - i];
            }
            if (x + i < N && y + i < N) {
                mosquitoes += village[x + i][y + i];
            }
        }

        return mosquitoes;
    }
}
