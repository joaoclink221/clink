import java.util.Scanner;

public class clink {

    /* =========  AUXILIARES  ========= */

    public static String[] copiarLinha(String[] linha){
        String[] novo = new String[linha.length];
        for (int i = 0; i < linha.length; i++) {
            novo[i] = linha[i];
        }
        return novo;
    } // Essa função será usada futuramente para aumentar o tamanho da matriz no aumentarMatrizContatos ou aumentarMatrizClientes, copiando a linha.

    /* =========  CONTATOS  ========= */

    public static String[][] aumentarMatrizContatos(String[][] contatos) {
        String[][] novoContato = new String[contatos.length + 1][5];
        for (int i = 0; i < contatos.length; i++) {
            if (contatos[i][0] != null) {
                novoContato[i] = copiarLinha(contatos[i]);
            }
        }
        return novoContato;
    } // Essa função vai servir para aumentar o tamanho da matriz de contatos, adicionando uma nova linha

    public static int proximoCodigoContato(String[][] contatos) {
        int maior = 0;
        for (int i = 0; i < contatos.length; i++) {
            if (contatos[i][0] != null) {
                int cod = Integer.parseInt(contatos[i][0]);
                if (cod > maior) maior = cod;
            }
        }
        return maior + 1;
    } // Essa função vai servir para gerar o código de contato automaticamente.

    /* =========  MAIN  ========= */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [][] contatos = new String[5][5];

    }
}
