package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("붐힐 마을의 크기 N과 물풍선의 범위 M을 입력하세요: ");
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[][] village = new int[N][N];

        System.out.println("붐힐 마을을 나타내는 배열의 N개 줄에 각 행의 N개 칸에 존재하는 모기의 수를 입력하세요:");
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

        System.out.println("퇴치할 수 있는 모기 수의 최댓값: " + maxMosquitoes);

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
