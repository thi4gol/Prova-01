package aplicativos;

import java.io.IOException;
import java.util.Scanner;
import Model.Pessoa;

public class AppPilotos {
    public static void main(String[] args) throws InterruptedException, IOException {
        int max_elementos = 20; 
        int opcao;
        int qtdCadastrados = 0;
        Pessoa[] pilotos = new Pessoa[max_elementos];
        Scanner in = new Scanner(System.in);
        int novo_elementos =0; 
        Pessoa[] novoArmazenamento = new Pessoa[max_elementos];

        do {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1 - Cadastrar piloto");
            System.out.println("2 - Listar pilotos cadastrados");
            System.out.println("3 - Localizar piloto pelo CPF");
            System.out.println("4 - Aumentar espaço de armazenamento");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = in.nextInt();
            in.nextLine();

            limpa();
            if (opcao == 1) {
                // Se não tem mais espaço no vetor, caio fora
                if (qtdCadastrados == max_elementos) {
                    System.out.println("\nNão há espaço para cadastrar novos pilotos.");
                    voltarMenu(in);
                    continue;
                }

                //Cadastre seu piloto aqui
                System.out.print("Digite o nome do Piloto: ");
                String nomePiloto = in.nextLine();
                System.out.print("Digite o CPF do Piloto: ");
                String cpf = in.nextLine();

                Pessoa pessoa = new Pessoa(nomePiloto, cpf);
                pilotos[qtdCadastrados] = pessoa; 
                qtdCadastrados++;

                System.out.println("\nPiloto cadastrado com sucesso.");
                voltarMenu(in);
            } else if (opcao == 2) {
                // Se não tem ninguém cadastrado no vetor, caio fora
                if (qtdCadastrados == 0) {
                    System.out.println("\nNão há Pilotos cadastrados para exibir.");
                }

                // Exiba os pilotos aqui
                for (int i = 0; i < max_elementos; i++) {
                    System.out.println(pilotos[i]);
                }
                voltarMenu(in);
            } else if (opcao == 3) {
                System.out.println("Digite o CPF do piloto que você deseja encontrar: ");
                String cpfPilotos = in.nextLine();

                for (int i = 0; i < qtdCadastrados; i++) {
                    if (pilotos[i].getCpf().equals(cpfPilotos)) {
                        System.out.println("Esse é o piloto que você procura: ");
                        System.out.println(pilotos[i]);
                    }
                    if (!pilotos[i].getCpf().equals(cpfPilotos) && i == qtdCadastrados -1) {
                        System.out.println("Piloto não encontrado!");
                    }
                    voltarMenu(in);
                }
            } else if (opcao == 4) {
                System.out.println("Digite a quantidade de armazenamento que voçê deseja aumentar: ");
                novo_elementos = in.nextInt();
                in.nextLine();

                for (int i = 0; i < max_elementos; i++) {
                    novoArmazenamento[i] = pilotos[i];
                }
                max_elementos = novo_elementos + max_elementos;
                pilotos = novoArmazenamento;
                
                System.out.println("Armazenamento aumentado com sucesso!");
                voltarMenu(in);
            }
        }while (opcao != 0);

        System.out.println("Fim do programa!");

        in.close();
    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
        
        System.out.flush();
    }

    private static void  limpa(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

}
