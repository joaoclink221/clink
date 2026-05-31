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


    /* =========  RELATÓRIOS  ========= */

    public static void menuRelatorios(String[][] clientes, String[][] contatos, Scanner ler) {
        int opcao = 0;

        while (opcao != 3) {
            System.out.println("===== MENU DE RELATÓRIOS =====");
            System.out.println("1 - Listar clientes e total de contatos");
            System.out.println("2 - Sumarização de dados");
            System.out.println("3 - Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(ler.nextLine());

            switch (opcao) {
                case 1:
                    listarClientesCContatos(clientes, contatos);
                    break;
                case 2:
                    sumarizarDados(clientes, contatos);
                    break;
                case 3:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
        }
    }

    public static void listarClientesCContatos(String[][] clientes, String[][] contatos) {
        System.out.println("---Clientes e o Total dos Contatos---");
        System.out.println("Código | Nome             | Total de Contatos");
        System.out.println("-----------------------");

        int totalDeClientes = 0;
        int totalDeContatos = 0;

        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i][0] != null) {
                int totalDoCliente = 0;

                for (int j = 0; j < contatos.length; j++) {
                    if (contatos[j][0] != null && contatos[j][1].equals(clientes[i][0])) {
                        totalDoCliente++;
                    }
                }
                System.out.println(clientes[i][0] + "      | " + clientes[i][1] + " | " + totalDoCliente);
                totalDeClientes++;
                totalDeContatos += totalDoCliente;
            }
        }

        System.out.println("-----------------------");
        System.out.println("Total de clientes: " + totalDeClientes);
        System.out.println("Total de contatos: " + totalDeContatos);
    }

    public static void sumarizarDados(String[][] clientes, String[][] contatos) {
        System.out.println("---Sumarização de dados---");

        int totalCliente = 0;
        int totalContatos = 0;
        int clientesSemContato = 0;

        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i][0] != null) {
                totalCliente++;
                int totalDoCliente = 0;

                for (int j = 0; j < contatos.length; j++) {
                    if (contatos[j][0] != null && contatos[j][1].equals(clientes[i][0])) {
                        totalDoCliente++;
                    }
                }

                totalContatos += totalDoCliente;

                if (totalDoCliente == 0) {
                    clientesSemContato++;
                }
            }
        }

        double media = 0;
        if (totalCliente > 0) {
            media = (double) totalContatos / totalCliente;
        }

        System.out.println("Total de clientes:          " + totalCliente);
        System.out.println("Total de contatos:          " + totalContatos);
        System.out.println("Média de contatos/cliente:  " + media);
        System.out.println("Clientes sem contato:       " + clientesSemContato);
    }





    /* =========  MAIN  ========= */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [][] contatos = new String[5][5];



    }
}

