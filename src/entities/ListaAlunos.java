package entities;

import java.util.Scanner;

public class ListaAlunos {

    public final int TAM = 60;
    private int tamAtual;
    private Aluno[] listaAlunos;

    public ListaAlunos() {
        listaAlunos = new Aluno[TAM];
        tamAtual = 0;
    }

    public void cadastrarAluno(String nome, Long rgm){
    
        int pos = 0;
       while(pos<tamAtual && listaAlunos[pos].getRgm() < rgm){
        pos++;
       }
       for(int i=tamAtual;i>pos;i--){
        listaAlunos[i]=listaAlunos[i-1];
       }

       listaAlunos[pos]= new Aluno(rgm, nome);
       tamAtual++;

    }

    public void removerAluno(Long rgm) {
    }

}

       