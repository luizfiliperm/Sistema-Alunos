package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import app.Main;
import entities.Aluno;
import entities.FilesServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class CardAlunoController implements Initializable{
    FilesServices fs = new FilesServices();
    @FXML
    private Button btAdcionarMateria;

    @FXML
    private ComboBox<String> cbMaterias;

    @FXML
    private Label lbNome;

    @FXML
    private Label lbRgm;

    
    @FXML
    private ListView<String> lvMaterias;


    Aluno alunoSelecionado = ListaAlunosController.alunoSelecionado;

    ObservableList<String> materiasAluno = FXCollections.observableArrayList();
    ObservableList<String> materiasDisponiveis = FXCollections.observableArrayList();

    public void atualizarLv(){
        // Atualiza a lista de matérias do aluno
        materiasAluno = FXCollections.observableArrayList(Main.sGerais.retornaAluno(alunoSelecionado.getRgm()).getMaterias());
        lvMaterias.setItems(materiasAluno); // seta a lista de matérias no ListView
    }

    public void atualizarCB(String materiaRemovida){
        materiasDisponiveis.remove(materiaRemovida); // remove a matéria selecionada da lista
        cbMaterias.getSelectionModel().clearSelection(); // limpa a seleção do ComboBox
        cbMaterias.setPromptText("Selecione uma matéria"); // seta o texto padrão do ComboBox
        cbMaterias.setItems(materiasDisponiveis); // atualiza o ComboBox com a lista atualizada
    }

    @FXML
    void adcionarMateriaAoAluno(ActionEvent event) {
        // Salva a materia a ser adcionada
        String materia = cbMaterias.getSelectionModel().getSelectedItem();

        // Adciona a matéria ao aluno direto na lista
        Main.sGerais.adcionarMateriaAoAluno(alunoSelecionado.getRgm(), materia);

        atualizarCB(materia);
        atualizarLv();
        fs.atualizarAlunosCsv(Main.sGerais.getListaAlunos(), Main.sGerais.getTamAtual());
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle resource) {

        // Seta os valores do aluno selecionado nos labels
        lbNome.setText(alunoSelecionado.getNome());
        lbRgm.setText(alunoSelecionado.getRgm().toString());

        // Cria uma lista de matérias que o aluno não está matriculado
        for(String materia : Main.sGerais.getMaterias()){
            if(!alunoSelecionado.getMaterias().contains(materia)){
                materiasDisponiveis.add(materia);
            }
        }

        // Seta a lista de matérias no combobox
        cbMaterias.getItems().addAll(materiasDisponiveis);


        // Desativar botão se não tiver Matéria selecionada
        btAdcionarMateria.disableProperty().bind(cbMaterias.getSelectionModel().selectedItemProperty().isNull());

        // Atualiza a lista de matérias do aluno
        atualizarLv();
    }
}
