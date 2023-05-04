package entities;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import app.Main;


public class FilesServices {
    
    // Salva os alunos em um arquivo csv
    public void atualizarAlunosCsv(Aluno[] listAlunos, int tamAtual) {
        FileWriter writer = null;
        try {
            // Cria o arquivo
            writer = new FileWriter("ListaAlunos.csv");

            // Escreve o cabeçalho
            writer.write("rgm,nome,materias\n");

            // Escreve os alunos
            for (int i = 0; i < tamAtual; i++) {
                writer.write(listAlunos[i].getRgm() + "," + listAlunos[i].getNome() + "," + String.join(";", listAlunos[i].getMaterias()) + "\n");
            }
        } catch (IOException e) {
            System.out.println("Erro ao escrever o arquivo: " + e.getMessage());
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.out.println("Error ao fechar o arquivo: " + e.getMessage());
                }
            }
        }
    }
  
    
    // Lê os alunos de um arquivo csv
    public void lerAlunosCsv() {
        try {
            Scanner scanner = new Scanner(new File("ListaAlunos.csv"));
            // pula a primeira linha (cabeçalho)
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                // lê uma linha do arquivo
                String linha = scanner.nextLine();

                // quebra a linha em campos
                String[] campos = linha.split(",");

                // cria um objeto aluno com os campos lidos
                Long rgm = Long.parseLong(campos[0]);
                String nome = campos[1];
                Aluno aluno = new Aluno(rgm, nome);

                // Checka se tem matérias
                if(campos.length > 2){
                    String[] materias = campos[2].split(";");
                    // Adiciona as matérias
                    for(String s : materias){
                        aluno.adicionarMateria(s);
                    }
                }

                Main.sGerais.cadastrarAluno(aluno);
                
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo ListaAlunos.csv não encontrado: " + e.getMessage());
        }
    }

    // Salva as matérias em um arquivo csv
    public void atualizarMateriasCSV(ArrayList<String> materias){
        FileWriter writer = null;
        try {
            writer = new FileWriter("ListaMaterias.csv");
            // Escreve o cabeçalho
            writer.write("materias\n");

            // Escreve as matérias
            for (String materia : materias) {
                writer.write(materia + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error ao escrever no arquivo=: " + e.getMessage());
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.out.println("Erro ao fechar o arquivo: " + e.getMessage());
                }
            }
        }
    }


    // Lê as matérias de um arquivo csv
    public void lerMateriasCsv(){
        try {
            Scanner scanner = new Scanner(new File("ListaMaterias.csv"));
            // pula a primeira linha (cabeçalho)
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                // lê uma linha do arquivo
                String linha = scanner.nextLine();

                // quebra a linha em campos
                String[] campos = linha.split(",");

                // cria um objeto aluno com os campos lidos
                String materia = campos[0];

                Main.sGerais.cadastrarMateria(materia);
                
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo ListaMaterias.csv não encontrado: " + e.getMessage());
        }
    }
}
    

