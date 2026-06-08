import java.util.Scanner;

public class clink {

    /* ========= AUXILIARES ========= */

    public static String[] copiarLinha(String[] linha) {
        String[] novo = new String[linha.length];
        for (int i = 0; i < linha.length; i++) {
            novo[i] = linha[i];
        }
        return novo;
    } // Essa função será usada futuramente para aumentar o tamanho da matriz no
      // aumentarMatrizContatos ou aumentarMatrizClientes, copiando a linha.

    public static int compararNomeCharPorChar(String nome1, String nome2) {
        //Converte os dois nomes para maiúsculo para ignorar diferença entre maiúsculas e minúsculas
        String a = nome1.toUpperCase();
        String b = nome2.toUpperCase();

        // Pega o tamanho do menor nome para não passar do limite na comparação
        int menor = a.length();
        if (b.length() < menor) menor = b.length();

        // Compara letra por letra até encontrar uma diferença
        for (int i = 0; i < menor; i++) {
            if (a.charAt(i) < b.charAt(i)) return -1; // nome1 vem antes
            if (a.charAt(i) > b.charAt(i)) return 1;  // nome1 vem depois
        }

        // Se todas as letras foram iguais, o nome mais curto vem primeiro
        if (a.length() < b.length()) return -1;
        if (a.length() > b.length()) return 1;
        return 0; // nomes são iguais
    }

    static void limparLinha(String[] linha) {
        for (int i = 0; i < linha.length; i++) {
            linha[i] = null;
        }
    }

    static void trocarLinhas(String[][] matriz, int i, int j) {
        String[] troca = copiarLinha(matriz[i]);
        for (int k = 0; k < matriz[i].length; k++) {
            matriz[i][k] = matriz[j][k];
        }
        for (int k = 0; k < matriz[j].length; k++) {
            matriz[j][k] = troca[k];
        }
    }

    /* ========= VALIDAÇÕES DE CLIENTE ========= */

    public static String validarNome(Scanner sc) {
        while (true) {
            System.out.print("Informe o nome: ");
            String nome = sc.nextLine().trim();

            if (nome.isEmpty()) {
                System.out.println("  Erro: o nome não pode ser vazio.");
                continue;
            }

            boolean soLetras = true;
            for (int i = 0; i < nome.length(); i++) {
                char c = nome.charAt(i);

                if (!Character.isLetter(c) && c != ' ') {
                    soLetras = false;
                    break;
                }
            }

            if (!soLetras) {
                System.out.println("  Erro: o nome deve conter apenas letras e espaços.");
                continue;
            }

            return nome;
        }
    }

    public static String validarCpfCnpj(Scanner sc) {
        while (true) {
            System.out.print("Informe o CPF (11 dígitos) ou CNPJ (14 dígitos): ");
            String valor = sc.nextLine().trim();


            String apenasDigitos = "";
            for (int i = 0; i < valor.length(); i++) {
                char c = valor.charAt(i);
                if (c >= '0' && c <= '9') {
                    apenasDigitos += c;
                }
            }

            if (apenasDigitos.length() == 11) {
                return apenasDigitos;
            } else if (apenasDigitos.length() == 14) {
                return apenasDigitos;
            } else {
                System.out.println("  Erro: CPF deve ter 11 dígitos e CNPJ deve ter 14 dígitos.");
                System.out.println("  Você digitou " + apenasDigitos.length() + " dígito(s).");
            }
        }
    }

    public static String validarData(Scanner sc) {
        while (true) {
            System.out.print("Informe a data de nascimento (dd/mm/aaaa): ");
            String data = sc.nextLine().trim();

            if (data.length() != 10 || data.charAt(2) != '/' || data.charAt(5) != '/') {
                System.out.println("  Erro: use o formato dd/mm/aaaa (ex: 25/03/1990).");
                continue;
            }

            String diaStr  = data.substring(0, 2);
            String mesStr  = data.substring(3, 5);
            String anoStr  = data.substring(6, 10);

            boolean tudoDigito = true;
            String completo = diaStr + mesStr + anoStr;
            for (int i = 0; i < completo.length(); i++) {
                if (completo.charAt(i) < '0' || completo.charAt(i) > '9') {
                    tudoDigito = false;
                    break;
                }
            }
            if (!tudoDigito) {
                System.out.println("  Erro: a data deve conter apenas números e barras.");
                continue;
            }

            int dia = Integer.parseInt(diaStr);
            int mes = Integer.parseInt(mesStr);
            int ano = Integer.parseInt(anoStr);

            if (dia < 1 || dia > 31) {
                System.out.println("  Erro: dia inválido (deve ser entre 01 e 31).");
                continue;
            }
            if (mes < 1 || mes > 12) {
                System.out.println("  Erro: mês inválido (deve ser entre 01 e 12).");
                continue;
            }
            if (ano < 1900 || ano > 2025) {
                System.out.println("  Erro: ano inválido (deve ser entre 1900 e 2025).");
                continue;
            }

            return data;
        }
    }

    public static String validarSexo(Scanner sc) {
        while (true) {
            System.out.print("Informe o sexo (M = Masculino / F = Feminino / O = Outro): ");
            String sexo = sc.nextLine().trim().toUpperCase();

            if (sexo.equals("M") || sexo.equals("F") || sexo.equals("O")) {
                return sexo;
            }

            System.out.println("  Erro: digite apenas M, F ou O.");
        }
    }

    public static String validarCidadeOuEstado(Scanner sc, String campo) {
        while (true) {
            System.out.print("Informe " + campo + ": ");
            String valor = sc.nextLine().trim();

            if (valor.isEmpty()) {
                System.out.println("  Erro: " + campo + " não pode ser vazio.");
                continue;
            }

            boolean soLetras = true;
            for (int i = 0; i < valor.length(); i++) {
                char c = valor.charAt(i);
                if (!Character.isLetter(c) && c != ' ') {
                    soLetras = false;
                    break;
                }
            }

            if (!soLetras) {
                System.out.println("  Erro: " + campo + " deve conter apenas letras.");
                continue;
            }

            return valor;
        }
    }

    public static String validarStatus(Scanner sc) {
        while (true) {
            System.out.print("Informe o status (ATIVO / INATIVO): ");
            String status = sc.nextLine().trim().toUpperCase();

            if (status.equals("ATIVO") || status.equals("INATIVO")) {
                return status;
            }

            System.out.println("  Erro: status deve ser ATIVO ou INATIVO.");
        }
    }

    /* ========= CONTATOS ========= */

    public static String[][] aumentarMatrizContatos(String[][] contatos) {
        String[][] novoContato = new String[contatos.length + 1][5];
        for (int i = 0; i < contatos.length; i++) {
            if (contatos[i][0] != null) {
                novoContato[i] = copiarLinha(contatos[i]);
            }
        }
        return novoContato;
    } // Essa função vai servir para aumentar o tamanho da matriz de contatos,
      // adicionando uma nova linha

    public static int proximoCodigoContato(String[][] contatos) {
        int maior = 0;
        for (int i = 0; i < contatos.length; i++) {
            if (contatos[i][0] != null) {
                int cod = Integer.parseInt(contatos[i][0]);
                if (cod > maior)
                    maior = cod;
            }
        }
        return maior + 1;
    } // Essa função vai servir para gerar o código de contato automaticamente.

    public static int contarContatos(String[][] contatos) {
        int total = 0;
        for (int i = 0; i < contatos.length; i++) {
            if (contatos[i][0] != null)
                total++;
        }

        return total;
    } // Contagem de quantos contatos o cliente colocou.

    public static String[][] incluirContato(String[][] contatos, String[][] clientes, Scanner scanner) {
        int codCli;

        System.out.println("=== INCLUIR CONTATO ===");
        System.out.print("Digite o código de cliente: ");
        try { codCli = Integer.parseInt(scanner.nextLine().trim()); }
        catch (NumberFormatException e) {
            System.out.println("Código inválido."); return contatos;
        }

        int idxCli = buscarClientePorCodigo(clientes, String.valueOf(codCli));
        if (idxCli == -1) {
            System.out.println("Cliente não encontrado."); return contatos;
        }

        System.out.println("Cliente encontrado: " + clientes[idxCli][1]);

        System.out.println("\nTipos sugeridos: Telefone | WhatsApp | Email | Instagram | Site | LinkedIn | Outro");
        System.out.print("Digite o tipo do contato: ");
        String tipo = scanner.nextLine().trim();
        System.out.print("Digite o valor do contato: ");
        String valor = scanner.nextLine().trim();

        // Verificador de espaço dentro da matriz

        boolean temEspaco = false;
        for (int i = 0; i < contatos.length; i++) {
            if (contatos[i][0] == null) {
                temEspaco = true; break;
            }
        }
        if (!temEspaco) contatos = aumentarMatrizContatos(contatos);

        int codigo = proximoCodigoContato(contatos);
        for (int i = 0; i < contatos.length; i++) {
            if (contatos[i][0] == null) {
                contatos[i][0] = String.valueOf(codigo);
                contatos[i][1] = String.valueOf(codCli);
                contatos[i][2] = tipo;
                contatos[i][3] = valor;
                contatos[i][4] = "ATIVO";
                break;
            }
        }
        System.out.println("Contato cadastrado com código: " + codigo);
        return contatos;
    }

    static String buscarNomeCliente(String[][] clientes, int codCli) {
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i][0] != null && Integer.parseInt(clientes[i][0]) == codCli) {
                return clientes[i][1];
            }
        }
        return "Desconhecido";
    }

    public static void listarContatosTabela(String[][] contatos, String[][] clientes) {
        System.out.println("\nCodCont | CodCli | Nome Cliente         | Tipo        | Valor                | Status");
        System.out.println("========================================================================================");
        boolean algum = false;
        for (int i = 0; i < contatos.length; i++) {
            if (contatos[i][0] != null) {
                algum = true;
                String nomeCli = buscarNomeCliente(clientes, Integer.parseInt(contatos[i][1]));
                System.out.printf("%-7s | %-7s| %-21s| %-12s| %-21s| %s%n",
                        contatos[i][0],
                        contatos[i][1],
                        nomeCli,
                        contatos[i][2],
                        contatos[i][3],
                        contatos[i][4]);
            }
        }
        if (!algum) System.out.println("Nenhum contato cadastrado.");
    }

    static void listarContatosPorCliente(String[][] contatos, String[][] clientes, Scanner sc) {
        listarContatosTabela(contatos, clientes);
        System.out.print("\nSelecione o cliente que quer listar os contatos => ");
        int codCli;
        try { codCli = Integer.parseInt(sc.nextLine().trim()); }
        catch (NumberFormatException e) { System.out.println("Código inválido."); return; }

        System.out.println("\nCodCont | CodCli | Nome Cliente         | Tipo        | Valor                | Status");
        System.out.println("======================================================================================");
        boolean algum = false;
        for (int i = 0; i < contatos.length; i++) {
            if (contatos[i][0] != null && Integer.parseInt(contatos[i][1]) == codCli) {
                algum = true;
                String nomeCli = buscarNomeCliente(clientes, codCli);
                System.out.printf("%-7s | %-7s| %-21s| %-12s| %-21s| %s%n",
                        contatos[i][0],
                        contatos[i][1],
                        nomeCli,
                        contatos[i][2],
                        contatos[i][3],
                        contatos[i][4]);
            }
        }
        if (!algum) System.out.println("Nenhum contato encontrado para este cliente.");
    }

    static void alterarContato(String[][] contatos, String[][] clientes, Scanner sc) {
        listarContatosTabela(contatos, clientes);
        System.out.print("\nQual contato deseja alterar => ");
        int codigo;
        try { codigo = Integer.parseInt(sc.nextLine().trim()); }
        catch (NumberFormatException e) { System.out.println("Código inválido."); return; }

        int idx = -1;
        for (int i = 0; i < contatos.length; i++) {
            if (contatos[i][0] != null && Integer.parseInt(contatos[i][0]) == codigo) {
                idx = i; break;
            }
        }
        if (idx == -1) { System.out.println("Contato não encontrado."); return; }

        System.out.println("\nContato encontrado:");
        System.out.println("CodCont | CodCli | Tipo        | Valor                | Status");
        System.out.println("===============================================================");
        System.out.printf("%-7s | %-7s| %-12s| %-21s| %s%n",
                contatos[idx][0],
                contatos[idx][1],
                contatos[idx][2],
                contatos[idx][3],
                contatos[idx][4]);

        System.out.print("\nDeseja alterar este contato? (S/N): ");
        String alterar = sc.nextLine().trim().toUpperCase();
        if (!alterar.equals("S")) { System.out.println("Alteração cancelada."); return; }

        System.out.println("\nDigite os novos dados:");
        System.out.print("Tipo [" + contatos[idx][2] + "]: ");
        String tipo = sc.nextLine().trim();
        if (!tipo.isEmpty()) contatos[idx][2] = tipo;

        System.out.print("Valor [" + contatos[idx][3] + "]: ");
        String valor = sc.nextLine().trim();
        if (!valor.isEmpty()) contatos[idx][3] = valor;

        contatos[idx][4] = "ATIVO";
        System.out.println("Contato alterado com sucesso.");
    }

    static String[][] apagarContato(String[][] contatos, String[][] clientes, Scanner sc) {
        listarContatosTabela(contatos, clientes);
        System.out.print("\nQual contato deseja apagar => ");
        int codigo;
        try { codigo = Integer.parseInt(sc.nextLine().trim()); }
        catch (NumberFormatException e) { System.out.println("Código inválido."); return contatos; }

        int idx = -1;
        for (int i = 0; i < contatos.length; i++) {
            if (contatos[i][0] != null && Integer.parseInt(contatos[i][0]) == codigo) {
                idx = i; break;
            }
        }
        if (idx == -1) { System.out.println("Contato não encontrado."); return contatos; }

        System.out.println("\nContato encontrado:");
        System.out.println("CodCont | CodCli | Tipo        | Valor                | Status");
        System.out.println("----------------------------------------------------------------");
        System.out.printf("%-7s | %-7s| %-12s| %-21s| %s%n",
                contatos[idx][0], contatos[idx][1], contatos[idx][2],
                contatos[idx][3], contatos[idx][4]);

        System.out.print("\nConfirma exclusão? (S/N): ");
        String exclusao = sc.nextLine().trim().toUpperCase();
        if (!exclusao.equals("S")) { System.out.println("Exclusão cancelada."); return contatos; }

        int total = contarContatos(contatos);
        String[][] nova = new String[total > 0 ? total - 1 : 0][5];
        int j = 0;
        for (int i = 0; i < contatos.length; i++) {
            if (contatos[i][0] != null && Integer.parseInt(contatos[i][0]) != codigo) {
                nova[j] = copiarLinha(contatos[i]);
                j++;
            }
        }
        System.out.println("Contato removido com sucesso.");
        return nova;
    }

    //MENU CONTATO

    static String[][] menuContatos(String[][] contatos, String[][] clientes, Scanner sc) {
        int opcao;
        do {
            System.out.println("\n========== GERENCIAR CONTATOS ==========");
            System.out.println("1 - Incluir contato");
            System.out.println("2 - Listar contatos (todos)");
            System.out.println("3 - Listar contatos de um cliente");
            System.out.println("4 - Alterar contato");
            System.out.println("5 - Apagar contato");
            System.out.println("0 - Voltar");
            System.out.print("Opção: ");
            try { opcao = Integer.parseInt(sc.nextLine().trim()); }
            catch (NumberFormatException e) { opcao = -1; }

            switch (opcao) {
                case 1:
                    contatos = incluirContato(contatos, clientes, sc);
                    break;
                case 2:
                    listarContatosTabela(contatos, clientes);
                    break;
                case 3:
                    listarContatosPorCliente(contatos, clientes, sc);
                    break;
                case 4:
                    alterarContato(contatos, clientes, sc);
                    break;
                case 5:
                    contatos = apagarContato(contatos, clientes, sc);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
        return contatos;
    }

    // MENU CLIENTE

    static String[][] menuClientes(String[][] clientes, String[][] contatos, Scanner sc) {
        int opcao;
        do {
            System.out.println("\n========== GERENCIAR CLIENTES ==========");
            System.out.println("1 - Incluir cliente");
            System.out.println("2 - Listar clientes");
            System.out.println("3 - Consultar cliente por código");
            System.out.println("4 - Alterar cliente");
            System.out.println("5 - Apagar cliente");
            System.out.println("6 - Ordenar por nome");
            System.out.println("0 - Voltar");
            System.out.print("Opção: ");
            try { opcao = Integer.parseInt(sc.nextLine().trim()); }
            catch (NumberFormatException e) { opcao = -1; }

            switch (opcao) {
                case 1:
                    clientes = incluirCliente(clientes, sc);
                    break;
                case 2:
                    listarClientesTabela(clientes);
                    break;
                case 3:
                    System.out.print("Digite o código do cliente: ");
                    try {
                        int cod = Integer.parseInt(sc.nextLine().trim());
                        int idx = buscarClientePorCodigo(clientes, String.valueOf(cod));
                        if (idx == -1) {
                            System.out.println("Cliente não encontrado.");
                        } else {
                            System.out.println("\nCódigo | Nome                | CPF/CNPJ   | Nascimento | Sexo | Cidade              | Estado | Status");
                            System.out.println("--------------------------------------------------------------------------------------------------------------");
                            System.out.printf("%-6s | %-20s| %-11s| %-11s| %-5s| %-20s| %-7s| %s%n",
                                    clientes[idx][0], clientes[idx][1], clientes[idx][2],
                                    clientes[idx][3], clientes[idx][4], clientes[idx][5],
                                    clientes[idx][6], clientes[idx][7]);
                        }
                    } catch (NumberFormatException e) { System.out.println("Código inválido."); }
                    break;
                case 4:
                    alterarCliente(clientes, sc);
                    break;
                case 5:
                    clientes = apagarCliente(clientes, contatos, sc);
                    break;
                case 6:
                    ordenarClientesPorNome(clientes);
                    listarClientesTabela(clientes);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
        return clientes;
    }



    /* ========= Clientes ========= */

    public static String[][] aumentarMatrizClientes(String[][] clientes) {
        String[][] novoCliente = new String[clientes.length + 1][8];
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i][0] != null) {
                novoCliente[i] = copiarLinha(clientes[i]);
            }
        }
        return novoCliente;
    } // Essa função vai servir para aumentar o tamanho da matriz de clientes,
      // adicionando uma nova linha.

    public static String[][] incluirCliente(String[][] clientes, Scanner sc) {
        int maiorCodigo = 0;

        boolean cheio = true;

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
                if (codigo > maiorCodigo)
                    maiorCodigo = codigo;
            }
        }
        int novoCodigo = maiorCodigo + 1;

        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i][0] == null) {
                clientes[i][0] = String.valueOf(novoCodigo);
                clientes[i][1] = validarNome(sc);
                clientes[i][2] = validarCpfCnpj(sc);
                clientes[i][3] = validarData(sc);
                clientes[i][4] = validarSexo(sc);
                clientes[i][5] = validarCidadeOuEstado(sc, "a cidade");
                clientes[i][6] = validarCidadeOuEstado(sc, "o estado");
                clientes[i][7] = validarStatus(sc);
                System.out.println("Cliente cadastrado com sucesso! Código: " + novoCodigo);
                break;
            }
        }

        return clientes;
    }

    public static void listarClientesTabela(String[][] clientes) {
        System.out.println("Código | Nome | CPF/CNPJ | Nascimento | Sexo | Cidade | Estado | Status");
        System.out.println(
                "--------------------------------------------------------------------------------------------");

        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i][0] != null) {
                System.out.println(
                        clientes[i][0] + " | " + clientes[i][1] + " | " + clientes[i][2] + " | " + clientes[i][3]
                                + " | " + clientes[i][4] + " | " + clientes[i][5] + " | " + clientes[i][6] + " | "
                                + clientes[i][7]);
            }
        }
    }

    public static int buscarClientePorCodigo(String[][] clientes, String codigo) {
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i][0] != null && clientes[i][0].equals(codigo)) {
                return i;
            }
        }
        return -1;
    }

    public static String[][] alterarCliente(String[][] clientes, Scanner sc) {
        listarClientesTabela(clientes);
        System.out.println("qual cliente deseja alterar?");
        String codigo = sc.nextLine();
        int indice = buscarClientePorCodigo(clientes, codigo);

        if (indice == -1) {
            System.out.println("cliente não encontrado");
        } else {
            listarClientesTabela(clientes);
            System.out.println("Deseja alterar este cliente? (S/N)");
            String confirmacao = sc.nextLine();

            if (confirmacao.toUpperCase().equals("S")) {
                System.out.println("informe o nome:");
                clientes[indice][1] = sc.nextLine();

                System.out.println("informe o CPF ou CNPJ:");
                clientes[indice][2] = sc.nextLine();

                System.out.println("informe o Data de nascimento:");
                clientes[indice][3] = sc.nextLine();

                System.out.println("informe o Sexo:");
                clientes[indice][4] = sc.nextLine();

                System.out.println("informe o Cidade:");
                clientes[indice][5] = sc.nextLine();

                System.out.println("informe o Estado:");
                clientes[indice][6] = sc.nextLine();

                System.out.println("informe o Status:");
                clientes[indice][7] = sc.nextLine();
            }
        }
        return clientes;
    }

    public static String[][] apagarCliente(String[][] clientes, String[][] contatos, Scanner sc) {
        listarClientesTabela(clientes);

        System.out.println("informe o código do cliente que deseja apagar");
        String codigo = sc.nextLine();
        int indice = buscarClientePorCodigo(clientes, codigo);

        if (indice == -1) {
            System.out.println("cliente não encontrado");
        } else {
            listarClientesTabela(clientes);
            System.out.println("Deseja apagar este cliente? (S/N)");
            String confirmacao = sc.nextLine();

            if (confirmacao.toUpperCase().equals("S")) {
                String[][] novaMatriz = new String[clientes.length - 1][8];
                int j = 0;
                for (int i = 0; i < clientes.length; i++) {
                    if (i != indice) {
                        novaMatriz[j] = copiarLinha(clientes[i]);
                        j++;
                    }
                }
                return novaMatriz;
            }

        }
        return clientes;
    }

    static void ordenarClientesPorNome(String[][] clientes) {
        int n = clientes.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (clientes[j][0] != null && clientes[j+1][0] != null) {
                    if (compararNomeCharPorChar(clientes[j][1], clientes[j+1][1]) > 0) {
                        trocarLinhas(clientes, j, j + 1);
                    }
                } else if (clientes[j][0] == null && clientes[j+1][0] != null) {
                    trocarLinhas(clientes, j, j + 1);
                }
            }
        }
        System.out.println("Clientes ordenados por nome.");
    }

    /* ========= RELATÓRIOS ========= */

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

    /* ========= MAIN ========= */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] contatos = new String[5][5];
        String[][] clientes = new String[5][8];

        int opcao;
        do {
            System.out.println("\n============================================");
            System.out.println("   SISTEMA DE CADASTRO DE CLIENTES E CONTATOS");
            System.out.println("============================================");
            System.out.println("1 - Gerenciar clientes");
            System.out.println("2 - Gerenciar contatos");
            System.out.println("3 - Relatórios");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            try { opcao = Integer.parseInt(scanner.nextLine().trim()); }
            catch (NumberFormatException e) { opcao = -1; }

            switch (opcao) {
                case 1:
                    clientes = menuClientes(clientes, contatos, scanner);
                    break;
                case 2:
                    contatos = menuContatos(contatos, clientes, scanner);
                    break;
                case 3:
                    menuRelatorios(clientes, contatos, scanner);
                    break;
                case 0:
                    System.out.println("Encerrando o sistema. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

    }
}