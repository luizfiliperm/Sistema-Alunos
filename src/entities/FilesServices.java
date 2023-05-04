package entities;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import app.Main;


public class FilesServices {
    
    public void atualizarAlunosCsv(Aluno[] listAlunos, int tamAtual) {
        FileWriter writer = null;
        try {
            writer = new FileWriter("ListaGeral.csv");
            writer.write("rgm,nome,materias\n");

            for (int i = 0; i < tamAtual; i++) {
                writer.write(listAlunos[i].getRgm() + "," + listAlunos[i].getNome() + "," + String.join(";", listAlunos[i].getMaterias()) + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing to CSV file: " + e.getMessage());
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.out.println("Error closing CSV file: " + e.getMessage());
                }
            }
        }
    }
  
    
    
    
        public void lerAlunosCsv() {
            try {
                Scanner scanner = new Scanner(new File("ListaGeral.csv"));
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
                        for(String s : materias){
                            aluno.adicionarMateria(s);
                        }
                    }

                    Main.sGerais.cadastrarAluno(aluno);
                    
                }
            } catch (FileNotFoundException e) {
                System.out.println("Arquivo ListaGeral.csv não encontrado: " + e.getMessage());
            }
        }
    }
    

