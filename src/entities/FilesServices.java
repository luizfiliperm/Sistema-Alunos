package entities;

import java.io.FileWriter;
import java.io.IOException;

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
   
    public Aluno[] getListaGeral(Aluno[] listAlunos, int tamAtual) {
        Aluno[] listaGeral = new Aluno[tamAtual];
        for (int i = 0; i < tamAtual; i++) {
            listaGeral[i] = listAlunos[i];
        }
        return listaGeral;
    }
    
}
