package entities;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class FilesServices {
    
    public void cadastrarAlunoscsv(Aluno[] listAlunos, int tamAtual) {
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
  
    
    
    
        public Aluno[] getListaGeral() {
            ArrayList<Aluno> listaGeral = new ArrayList<>();
            try {
                Scanner scanner = new Scanner(new File("ListaGeral.csv"));
                // pula a primeira linha (cabeçalho)
                scanner.nextLine();
                while (scanner.hasNextLine()) {
                    String linha = scanner.nextLine();
                    String[] campos = linha.split(",");
                    String rgm = campos[0];
                    String nome = campos[1];
                    String[] materias = campos[2].split(";");
                    Aluno aluno = new Aluno();
                    listaGeral.add(aluno);
                }
            } catch (FileNotFoundException e) {
                System.out.println("Arquivo ListaGeral.csv não encontrado: " + e.getMessage());
            }
            return listaGeral.toArray(new Aluno[listaGeral.size()]);
        }
    }
    

