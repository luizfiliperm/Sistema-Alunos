package controllers;

import java.io.IOException;

import app.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CadastrarAlunoController {

    public ScreenMethods sm = new ScreenMethods();

    @FXML
    private Button btCadastrar;

    @FXML
    private Button btVoltar;

    @FXML
    private Label lMessagem;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfRGM;


    public void trocarMessagem(String mensagem) throws IOException{
        lMessagem.setText(mensagem);
    }

    public boolean validarCampos() throws IOException{
        
        // Campo vazio
        if(tfNome.getText().isEmpty() || tfRGM.getText().isEmpty()){
            trocarMessagem("Preencha todos os campos");
            return false;
        }

        // RGM não é um número
        try {
            Long.parseLong(tfRGM.getText());
        } catch (NumberFormatException e) {
            trocarMessagem("RGM Inválido");
            return false;
        }

        // Aluno já cadastrado
        if(Main.listaAlunos.alunoExiste(Long.parseLong(tfRGM.getText()))){
            trocarMessagem("Aluno já cadastrado");
            return false;
        }
        return true;
        
    }

    @FXML
    void TentarCadastrarAluno(ActionEvent event) throws IOException{
        if(!validarCampos()){
            return;
        }   
        Long rgm = Long.parseLong(tfRGM.getText()) ;
        String nome = tfNome.getText();

        Main.listaAlunos.cadastrarAluno(nome, rgm);
        trocarMessagem("Aluno cadastrado com sucesso");
    }

    @FXML
    void voltarParaOMenu(ActionEvent event) throws IOException{
        sm.changeScreen("Menu", event);
    }

}
