package app;


import entities.FilesServices;
import entities.ServicosGerais;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

public class Main extends Application{
    public static ServicosGerais sGerais = new ServicosGerais();

    @Override
    public void start(Stage primaryStage) throws Exception {
        String mainPath = "../views/Menu.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(mainPath));
        Scene scene = new Scene(root);

        // Icon do programa
        Image icon = new Image(getClass().getResourceAsStream("../views/img/logo.png")); 
        primaryStage.getIcons().add(icon);

        primaryStage.setResizable(false);
        primaryStage.setTitle("Colegio Corleone");
        primaryStage.setScene(scene);
        primaryStage.show();

        
    }
    public static void main(String[] args) throws Exception {
        // Ler os arquivos csv
        FilesServices fs = new FilesServices();
        fs.lerAlunosCsv();
        fs.lerMateriasCsv();


        // Executar o programa
        launch(args);
    }

    
}
