import java.util.Scanner;

public class clink {

    /* =========  AUXILIARES  ========= */

    public static String[] copiarLinha(String[] linha){
        String[] novo = new String[linha.length];
        for (int i = 0; i < linha.length; i++) {
            novo[i] = linha[i];
        }
        return novo;
    }

    /* =========  CONTATOS  ========= */

    public static String[][] aumentarMatrizContatos(String[][] contatos) {
        String[][] novoContato = new String[contatos.length + 1][5];
        for (int i = 0; i < contatos.length; i++) {
            if (contatos[i][0] != null) {
                novoContato[i] = copiarLinha(contatos[i]);
            }
        }
        return novoContato;
    }

    /* =========  MAIN  ========= */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [][] contatos = new String[5][5];
    }
}
