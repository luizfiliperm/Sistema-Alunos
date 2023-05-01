package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import app.Main;
import entities.Aluno;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListaAlunosController implements Initializable{

    ScreenMethods sc = new ScreenMethods();

    @FXML
    private ScrollPane SpNome;

    @FXML
    private ScrollPane SpRgm;

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
    void voltarParaOMenu(ActionEvent event) throws IOException{
        sc.changeScreen("Menu", event);
    }

    private ObservableList<Aluno> items = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resources) {

        SpRgm.vvalueProperty().bindBidirectional(SpNome.vvalueProperty());

        // Adcionando os alunos na tabela
        
        if(items.isEmpty()){
            for (int i = 0; i < Main.listaAlunos.getTamAtual(); i++) {
                items.add(Main.listaAlunos.getListaAlunos()[i]);
            }   

            cNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
            cRGM.setCellValueFactory(new PropertyValueFactory<>("rgm"));

            tvNome.setItems(items);
            tvRGM.setItems(items);

        }


    }


    
}
