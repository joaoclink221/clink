import java.util.Scanner;

public class Relatorios {
    public static void menurelatorios(String[][] clientes, String[][] contatos, Scanner ler) {

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
    //Primeiro Relatorio Cliente para contatos

    public static void listarClientesCContatos(String[][] clientes, String[][] contatos) {
        System.out.println("---Clientes e o Total dos Contatos---");
        System.out.println("Código | Nome             | Total de Contatos");
        System.out.println("-----------------------");

        int TotaldeClientes = 0;
        int TotalDeContatos = 0;

        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i][0] != null) {
                int TotalDoClientes = 0;

                for (int j = 0; j < contatos.length; j++) {
                    if (contatos[j][0] != null && contatos[j][1].equals(clientes[i][0])) {
                        TotalDoClientes++;


                    }
                }
                System.out.println(clientes[i][0] + "      | " + clientes[i][1] + " | " + TotalDoClientes);
                TotaldeClientes++;
                TotalDeContatos += TotalDoClientes;

            }
        }
    }
    //Relatorio 2 para sumarizar os dados
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

}
