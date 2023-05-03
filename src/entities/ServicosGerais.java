package entities;

import java.util.ArrayList;

public class ServicosGerais {

    public final int TAM = 60;
    private int tamAtual;
    private Aluno[] listaAlunos;
    private ArrayList<String> materias;

    public ServicosGerais() {
        listaAlunos = new Aluno[TAM];
        tamAtual = 0;
        this.materias = new ArrayList<>();
    }

    public Aluno[] getListaAlunos() {
        return listaAlunos;
    }
    
    public ArrayList<String> getMaterias() {
        return materias;
    }


    public int getTamAtual() {
        return tamAtual;
    }

    


    // método de cadastro de aluno
    public void cadastrarAluno(String nome, Long rgm) {
        int pos = 0;
        while (pos < tamAtual && listaAlunos[pos].getRgm() < rgm) {
            pos++;
        }
        for (int i = tamAtual; i > pos; i--) {
            listaAlunos[i] = listaAlunos[i - 1];
        }
        listaAlunos[pos] = new Aluno(rgm, nome);
        tamAtual++;
    }

    // busca indice do aluno 
    public int buscarIndiceAluno(Long rgm){

        for(int i=0; i<tamAtual;i++){
            if(listaAlunos[i].getRgm().equals(rgm))
            return i;
        }
        return-1;

    }

    // retornar indice do aluno 
    public Aluno retornaAluno(Long rgm){

        if(alunoExiste(rgm)){
            return listaAlunos[buscarIndiceAluno(rgm)];
        }
        return null;
    }

    // método para dizer se tem aluno existente ou nn 
    public boolean alunoExiste(Long rgm) {
        if(buscarIndiceAluno(rgm) == -1){
            return false;
        }else{
            return true;
        }
    }
    
    // métdodo para remover aluno 
    public void removerAlunoPorRgm(Long rgm) {
        for (int i = 0; i < tamAtual; i++) {
            if (listaAlunos[i] != null && listaAlunos[i].getRgm().equals(rgm)) {
                for (int j = i; j < tamAtual - 1; j++) {
                    listaAlunos[j] = listaAlunos[j + 1];
                }
                listaAlunos[tamAtual - 1] = null;
                tamAtual--;
                break;
            }
        }
    }

    public void cadastrarMateria(String materia){
        materias.add(materia);
    }

    public boolean materiaExiste(String materia){
        if(materias.contains(materia)){
            return true;
        }else{
            return false;
        }
    }

    public void adcionarMateriaAoAluno(Long rgm, String materia){
        if(alunoExiste(rgm)){
            if(!materiaExiste(materia)){
                cadastrarMateria(materia);
            }
            listaAlunos[buscarIndiceAluno(rgm)].adicionarMateria(materia);
        }
    }
}


       