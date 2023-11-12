import java.util.Scanner;

public class Exercise1 {

        public static void main(String[] args) throws Exception {


            Scanner input = new Scanner(System.in);// Prompt

            System.out.println("Exercícios - Parte 1 (II)\n\n");

            // Método que não recebe nada, e retorna a soma de dois números inteiros
            System.out.println("Exercício 1.1 \nR: 2 + 2 = " + somaValor());

            // Metodo responsável por receber concatenar uma String, um Inteiro e imprimir o resultado na consola
            stringInteiro("test", 1);

            // Método responsável por comparar doi números
            saoIguais(7, 8);


            System.out.println("\nDigite o Primeiro número: ");
            int num = input.nextInt();// Recebe o Primeiro Número
            System.out.println("\nDigite o Segundo número: ");
            int num2 = input.nextInt(); // Recebe o Segundo Número

            // Método responsável por imprimir uma lista ordenada em consola
            ordNumb(num, num2);
        }

    // Exercício
    // Método responsável por retornar a soma de dois números inteiros
    public static int somaValor(){
        return 2 + 2;
    }

    // Método responsável por receber uma String e um inteiro, concatenar ambos e imprimir o resultado na consola
    public static void stringInteiro( String valor, int num){
        String var = valor + num;
        System.out.println("\nExercício 1.2\nR: " + var);
    }

    // Método responsável por receber dois números inteiros e verificar se eles são iguais,
    // imprime a seguinte mensagem na consola:
    // a. Se iguais: "são iguais"
    // b. Caso contrário: "são diferentes"
    public static void saoIguais(int x, int y){
        if(x == y){
            System.out.println("\nExercício 1.3\nR: São iguais");
        }
        else {
            System.out.println("\nExercício 1.3\nR: São diferentes");
        }
    }

    // Método responsável por receber dois números do usuário e os imprimir em série separados por vírgula
    public static void ordNumb(int x, int y){
        System.out.println("\n\nSequencia de números!!");

        int maior = Math.max(x, y);// Compara e retorna o maior entre dois números
        int menor = Math.min(x, y);// Compara e retorna o menor entre dois números

        for(int i = menor; i <= maior * 2; i++ ) {
            System.out.print(i);
            if(i < maior * 2){
                System.out.print(", ");
            }
        }
    }
}
