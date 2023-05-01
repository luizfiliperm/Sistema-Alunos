package app;


import entities.ListaAlunos;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application{
    public static ListaAlunos listaAlunos = new ListaAlunos();

    @Override
    public void start(Stage primaryStage) throws Exception {
        String mainPath = "../views/Menu.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(mainPath));
        Scene scene = new Scene(root);

        // Adcionar o ícone depois
        // Image icon = new Image(getClass().getResourceAsStream("path")); 
        // primaryStage.getIcons().add(icon);

        primaryStage.setResizable(false);
        primaryStage.setTitle("Colegio Corleone");
        primaryStage.setScene(scene);
        primaryStage.show();

        
    }
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    
}
