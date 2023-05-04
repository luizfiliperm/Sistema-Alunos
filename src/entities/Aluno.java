package entities;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private Long rgm;
    private String nome;
    private List<String> materias;

    public Aluno(Long rgm, String nome, List<String> materias) {
        this.rgm = rgm;
        this.nome = nome;
        this.materias = materias;
    }

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
