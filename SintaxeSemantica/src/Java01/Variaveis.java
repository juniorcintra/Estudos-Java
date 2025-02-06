package Java01;

public class Variaveis {
    public static void main(String[] args) {
        final String NOME_AUTOR = "Junior";
        int idade = 23;
        double altura = 1.62;
        int quantidade;


        // declaracoes invalidas
        // int numero&um = 1; //Os únicos símbolos permitidos são _ e $
        // int 1numero = 1; //Uma variável não pode começar com numérico
        // int numero um = 1; //Não pode ter espaço no nome da variável
        // int long = 1; //long faz parte das palavras reservadas da linguagem

        // declaracoes validas
        int numero$um = 1;
        int numero1 = 1;
        int numeroum = 1; //ou numeroUm
        int longo = 1;

    }
}
