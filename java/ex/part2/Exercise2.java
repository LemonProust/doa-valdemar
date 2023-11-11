import java.util.Scanner;

public class Exercise2 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        CoackGame newCoackGame = new CoackGame();

        /*
         *
         * Número Primo
         *
         * */

        System.out.println("\n\n##### Número Primo #####");
        System.out.println("\nPor favor, digite o número que deseja saber se é Primo ou não.");
        int num = input.nextInt();

        if (isPrime(num)) {
            System.out.println("O número " + num + " é primo. Obrigado!");
        } else {
            System.out.println("O número " + num + " não é primo.");
        }

        /*
         *
         * Matrix of Prime
         *
         * */

        System.out.println("\n\n##### Matriz de Primos #####");
        System.out.println("\nPor favor, digite o número de Linhas que deseja para a Matriz.");
        int row = input.nextInt();
        System.out.println("\nPor favor, digite o número de Colunans que deseja para a Matriz.");
        int column = input.nextInt();

        System.out.println();// Deixar uma linha em branco

        int[][] matrix = matrixOfPrime(row, column);
        printMatrix(matrix);

        /*
        *
        * Jogo do Galo
        *
        * */
        System.out.println("\n\n##### Jogo do Galo #####");
        System.out.println("\n\n##### Quadro de jogo inicial #####");


        // Imprime em tela o Quadro de jogo inicial
        char[][] board = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        char nowPlaying = 'X';// Jogador corrente
        boolean runningGame = true; // Jogo em andamento

        // Enquanto joga, exibe o quadro de jogo em cada jogada
        while (runningGame) {
            newCoackGame.printBoard(board); // Exibe o quadro
            newCoackGame.playGame(board, nowPlaying);
            runningGame = !newCoackGame.verifyEndOfGame(board, nowPlaying); // Verifica o estado do jogo
            nowPlaying = (nowPlaying == 'X') ? 'O' : 'X';
        }

        newCoackGame.printBoard(board); // Imprime o quadro
    }

    // Método responsável por criar a matrix de números primos
    public static int[][] matrixOfPrime(int row, int column) {
        int[][] matrix = new int[row][column];

        int numPrime = 2; // Inicia com o primeiro número primo

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                while (!isPrime(numPrime)) {
                    numPrime++;
                }
                matrix[i][j] = numPrime;
                numPrime++;
            }
        }

        return matrix;
    }

    // Método responsável por verificar se o número é primo
    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    // Método responsável por imprimir a matris de números primos
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
