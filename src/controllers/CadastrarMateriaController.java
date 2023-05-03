package controllers;

import java.io.IOException;

import app.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CadastrarMateriaController {
    ScreenMethods sm = new ScreenMethods();

    @FXML
    private Button btCadastrar;

    @FXML
    private Button btVoltar;

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
            if(Main.listaAlunos.materiaExiste(tfNome.getText())){
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

        Main.listaAlunos.cadastrarMateria(tfNome.getText());
        trocarMessagem(tfNome.getText() + " cadastrada com sucesso");
    }

    @FXML
    void voltarParaOMenu(ActionEvent event) throws IOException{
        sm.changeScreen("Menu", event);
    }

}
