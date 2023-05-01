package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import entities.Aluno;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class CardAlunoController implements Initializable{
    
    @FXML
    private Label lbNome;
    
    @FXML
    private Label lbRgm;
    
    Aluno aluno = ListaAlunosController.alunoSelecionado;

    @Override
    public void initialize(URL url, ResourceBundle resource) {

        // Seta os valores do aluno selecionado nos labels
        lbNome.setText(aluno.getNome());
        lbRgm.setText(aluno.getRgm().toString());
    }
}
