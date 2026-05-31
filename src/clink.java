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

    public static int contarContatos(String[][] contatos) {
        int total = 0;
        for (int i = 0; i < contatos.length; i++) {
            if (contatos[i][0] != null) total++;
        }
        
        return total;
    } // Contagem de quantos contatos o cliente colocou.

     /* =========  Clientes  ========= */

     public static String[][] aumentarMatrizClientes(String[][] clientes){
        String[][] novoCliente = new String[clientes.length + 1] [8];
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i][0] != null) {
                novoCliente[i] = copiarLinha(clientes[i]);
            }
        }
        return novoCliente;
     } // Essa função vai servir para aumentar o tamanho da matriz de clientes, adicionando uma nova linha.

     public static String [][] incluirCliente(String[][] clientes, Scanner sc){
        int maiorCodigo = 0;

        boolean cheio =true;

        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i][0] == null) {
                cheio = false;
                break;
            }
        }
        if (cheio) {
            clientes = aumentarMatrizClientes(clientes);
        }
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i][0] != null) {
                int codigo = Integer.parseInt(clientes[i][0]);
                if (codigo>maiorCodigo) maiorCodigo = codigo;
            }
        }
        int novoCodigo = maiorCodigo+1;

        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i][0] == null) {
                clientes[i][0] = String.valueOf(novoCodigo);
                System.out.println("informe o nome:");
                clientes[i][1] = sc.nextLine();

                System.out.println("informe o CPF ou CNPJ:");
                clientes[i][2] = sc.nextLine();

                System.out.println("informe o Data de nascimento:");
                clientes[i][3] = sc.nextLine();

                System.out.println("informe o Sexo:");
                clientes[i][4] = sc.nextLine();

                System.out.println("informe o Cidade:");
                clientes[i][5] = sc.nextLine();

                System.out.println("informe o Estado:");
                clientes[i][6] = sc.nextLine();

                System.out.println("informe o Status:");
                clientes[i][7] = sc.nextLine();
                break;
            }
        }
       return clientes;
     }

    /* =========  MAIN  ========= */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [][] contatos = new String[5][5];

    }
}
