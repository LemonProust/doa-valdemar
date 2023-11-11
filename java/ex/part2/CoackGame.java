import java.util.Scanner;

public class CoackGame {


    // Método responsável por imprimir em tela as jogadas
    public static void printBoard(char[][] board) {
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("  -----");
            }
        }
        System.out.println();
    }

    // Método responsável por manter o jogo ativo
    public static void playGame(char[][] board, char nowPlaing) {
        Scanner scanner = new Scanner(System.in);
        int row, column;

        do {
            System.out.print("Jogador " + nowPlaing + ", insira a linha (0, 1, 2): ");
            row = scanner.nextInt();
            System.out.print("Jogador " + nowPlaing + ", insira a column (0, 1, 2): ");
            column = scanner.nextInt();
        } while (row < 0 || row >= 3 || column < 0 || column >= 3 || board[row][column] != ' ');

        board[row][column] = nowPlaing;
    }

    // Método responsável por verificar se existe um vencedor
    public static boolean verifyEndOfGame(char[][] board, char nowPlaying) {
        // Verificar por linhas e colunas
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == nowPlaying && board[i][1] == nowPlaying && board[i][2] == nowPlaying) ||
                    (board[0][i] == nowPlaying && board[1][i] == nowPlaying && board[2][i] == nowPlaying)) {
                System.out.println("Jogador " + nowPlaying + " venceu!");
                return true;
            }
        }

        // Verificar pelas diagonais
        if ((board[0][0] == nowPlaying && board[1][1] == nowPlaying && board[2][2] == nowPlaying) ||
                (board[0][2] == nowPlaying && board[1][1] == nowPlaying && board[2][0] == nowPlaying)) {
            System.out.println("Jogador " + nowPlaying + " venceu!");
            return true;
        }

        // Verificar empate
        boolean draw = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    draw = false;
                    break;
                }
            }
            if (!draw) {
                break;
            }
        }

        if (draw) {
            System.out.println("O jogo terminou empatado!");
            return true;
        }

        return false;
    }
}
