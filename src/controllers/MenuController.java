package controllers;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuController {
    ScreenMethods sm = new ScreenMethods();

    @FXML
    private Button btCadastrarAluno;

    @FXML
    private Button btCadastrarMateria;

    @FXML
    private Button btListaAlunos;

    @FXML
    private Button btSair;

    @FXML
    void ListaAlunos(ActionEvent event) throws IOException{
        sm.changeScreen("ListadeAlunos", event);
    }

    @FXML
    void cadastrarAluno(ActionEvent event) throws IOException{
        sm.changeScreen("CadastrarAluno", event);
    }

    @FXML
    void cadastrarMateria(ActionEvent event) throws IOException {
        sm.changeScreen("CadastrarMateria", event);
    }

    @FXML
    void sair(ActionEvent event) {
        Platform.exit();
    }

}
