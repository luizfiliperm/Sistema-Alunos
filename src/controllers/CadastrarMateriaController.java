package controllers;

import java.io.IOException;

import app.Main;
import entities.FilesServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CadastrarMateriaController {
    ScreenMethods sm = new ScreenMethods();
    FilesServices fs = new FilesServices();
    @FXML
    private Button btCadastrar;

    @FXML
    private Button btVoltar;

    @FXML
    private Button btListaAlunos;

    @FXML
    private Button btMaterias;

    @FXML
    private Button btRgm;


    @FXML
    private Label lMessagem;

    @FXML
    private TextField tfNome;

    public void trocarMessagem(String mensagem) {
        lMessagem.setText(mensagem);
    }

    public boolean validarCampos(){
            
            // Campo vazio
            if(tfNome.getText().isEmpty()){
                trocarMessagem("Preencha todos os campos");
                return false;
            }
            // Matéria já cadastrada
            if(Main.sGerais.materiaExiste(tfNome.getText())){
                trocarMessagem(tfNome.getText() + " já está cadastrada");
                return false;
            }
            return true;
            
    }

    @FXML
    void TentarCadastrarMateria(ActionEvent event) {
        if(!validarCampos()){
            return;
        }

        Main.sGerais.cadastrarMateria(tfNome.getText());
        trocarMessagem(tfNome.getText() + " cadastrada com sucesso");
        fs.atualizarMateriasCSV(Main.sGerais.getMaterias());
    }

    @FXML
    void voltarParaOMenu(ActionEvent event) throws IOException{
        sm.changeScreen("Menu", event);
    }

    @FXML
    void changeToListaAlunos(ActionEvent event) throws IOException{
        sm.changeScreen("ListadeAlunos", event);
    }

    @FXML
    void changeToMaterias(ActionEvent event) throws IOException{
        sm.changeScreen("CadastrarMateria", event);
    }

    @FXML
    void ChangeToRgm(ActionEvent event) throws IOException{
        sm.changeScreen("CadastrarAluno", event);
    }

}
