package entities;

import java.util.Scanner;

public class ListaAlunos {
    public static void main(String[] args) {
        String[] nomes = new String[60];
        int[] rgms = new int[60];
        int tamanho = 0;

        try (Scanner entrada = new Scanner(System.in)) {
            while (true) {
                System.out.println("A lista atual tem " + tamanho + " cadastros.");
                System.out.println("O que você deseja fazer?");
                System.out.println("1 - Adicionar um Aluno");
                System.out.println("2 - Remover um aluno");
                System.out.println("3 - Mostrar lista de alunos");
                System.out.println("4 - Sair");

                int opcao = entrada.nextInt();

                if (opcao == 1) {
                    if (tamanho >= nomes.length) {
                        System.out.println("A lista está cheia, não é possível adicionar mais alunos.");
                    } else {
                        System.out.println("Digite o nome do aluno:");
                        String nome = entrada.next();
                        System.out.println("Digite o rgm do aluno (máximo 8 dígitos):");
                        int rgm = entrada.nextInt();
                        nomes[tamanho] = nome;
                        rgms[tamanho] = rgm;
                        tamanho++;
                        System.out.println("Aluno adicionado com sucesso.");
                    }
                } else if (opcao == 2) {
                    if (tamanho <= 0) {
                        System.out.println("A lista está vazia, não é possível remover alunos.");
                    } else {
                        System.out.println("Digite a posição do aluno a ser removido (de 1 a " + tamanho + "):");
                        int posicao = entrada.nextInt();
                        if (posicao < 1 || posicao > tamanho) {
                            System.out.println("Posição inválida.");
                        } else {
                            for (int i = posicao-1; i < tamanho-1; i++) {
                                nomes[i] = nomes[i+1];
                                rgms[i] = rgms[i+1];
                            }
                            tamanho--;
                            System.out.println("Aluno removido com sucesso.");
                        }
                    }
                } else if (opcao == 3) {
                    System.out.println("Lista de alunos cadastrados:");
                    for (int i = 0; i < tamanho; i++) {
                        System.out.println("Nome: " + nomes[i] + " | RGM: " + rgms[i]);
                    }
                } else if (opcao == 4) {
                    break;
                } else {
                    System.out.println("Opção inválida.");
                }
            }
        }

        System.out.println("Lista final:");
        for (int i = 0; i < tamanho; i++) {
            System.out.println("Nome: " + nomes[i] + " | RGM: " + rgms[i]);
        }
    }
}
