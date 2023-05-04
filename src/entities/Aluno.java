package entities;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    // Tem que ter 8 dígitos
    private Long rgm;
    private String nome;
    private List<String> materias;


    public Aluno(String rgm2, String nome2, String[] materias2){}

    public Aluno(Long rgm, String nome) {
        this.rgm = rgm;
        this.nome = nome;
        this.materias = new ArrayList<>();
    }

    public Aluno() {
    }

    public Long getRgm() {
        return rgm;
    }

    public String getNome() {
        return nome;
    }

    public List<String> getMaterias() {
        return materias;
    }
    public void adicionarMateria(String materia) {
        this.materias.add(materia);
    }
    


    
    
}
