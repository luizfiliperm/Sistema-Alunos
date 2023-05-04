package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import app.Main;
import entities.Aluno;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ListaAlunosController implements Initializable{

    ScreenMethods sm = new ScreenMethods();

    @FXML
    private ScrollPane SpNome;

    @FXML
    private ScrollPane SpRgm;

    @FXML
    private Button btExcluirAluno;

    @FXML
    private Button btListaAlunos;

    @FXML
    private Button btMaterias;

    @FXML
    private Button btRgm;

    @FXML
    private Button btVoltar;
    
    @FXML
    private TableColumn<Aluno, String> cNome;

    @FXML
    private TableColumn<Aluno, Long> cRGM;

    @FXML
    private TableView<Aluno> tvNome;

    @FXML
    private TableView<Aluno> tvRGM;

    @FXML
    void ExcluirAlunoSelecionado(ActionEvent event) {
        Aluno aluno = tvRGM.getSelectionModel().getSelectedItem();
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Confirmação");
        alerta.setHeaderText("Tem certeza que deseja excluir o aluno?");

        alerta.setContentText("RGM: " + aluno.getRgm() + "\nNome: " + aluno.getNome());
        Optional<ButtonType> resultado = alerta.showAndWait();
        
        if (resultado.get() == ButtonType.OK){
            Main.sGerais.removerAlunoPorRgm(aluno.getRgm());
            items.remove(aluno);
        }
    }

    @FXML
    void voltarParaOMenu(ActionEvent event) throws IOException{
        sm.changeScreen("Menu", event);
    }

    public void abrirCardAluno(MouseEvent event){
        try {
            sm.openPopup("CardAluno");
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    private ObservableList<Aluno> items = FXCollections.observableArrayList();

    // Aluno selecionado na tabela, envia para o card
    public static Aluno alunoSelecionado;

    @Override
    public void initialize(URL url, ResourceBundle resources){


        // Vinculando o scroll das duas tabelas
        SpRgm.vvalueProperty().bindBidirectional(SpNome.vvalueProperty());

        
        // Adcionando os alunos na tabela
        if(items.isEmpty()){
            for (int i = 0; i < Main.sGerais.getTamAtual(); i++) {
                items.add(Main.sGerais.getListaAlunos()[i]);
            }   

            cNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
            cRGM.setCellValueFactory(new PropertyValueFactory<>("rgm"));

            tvNome.setItems(items);
            tvRGM.setItems(items);

        }

        
        // Abrir card do aluno ao clicar duas vezes
        tvRGM.setOnMousePressed(event -> {
            if(event.getClickCount() == 2){
                alunoSelecionado = tvRGM.getSelectionModel().getSelectedItem();
                if(alunoSelecionado != null){
                    abrirCardAluno(event);
                }
            }
        });

        // Ativar botão de excluir aluno ao selecionar um aluno
        tvRGM.setOnMouseClicked(event -> {
            if(tvRGM.getSelectionModel().getSelectedItem() != null){
                btExcluirAluno.setDisable(false);
            }else{
                btExcluirAluno.setDisable(true);
            }
        });

    }


    
}
