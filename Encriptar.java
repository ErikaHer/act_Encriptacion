package encriptar;

import java.util.Base64;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author eri
 */
public class Encriptar extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        Label palabra = new Label("PALABRA");
        TextField caja = new TextField();
        Button btn2 = new Button();
        btn2.setDisable(true);
        
        Button btn = new Button();
        btn.setText("ENCRIPTAR");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                byte[] pal = caja.getText().getBytes();
                String palabraEncriptada = Base64.getEncoder().encodeToString(pal);
                caja.setText(palabraEncriptada);
                btn2.setDisable(false);
            }
        });
        
        btn2.setText("DESENCRIPTAR");
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try{
                    byte[] pal2 = Base64.getDecoder().decode(caja.getText());
                    String palabraDesencriptada = new String(pal2);
                    caja.setText(palabraDesencriptada);
                    btn2.setDisable(true);
                }
                catch(Exception e){
                    Alert dialogoAlerta = new Alert(Alert.AlertType.ERROR); //Se crea el tipo de dialogoAlerta Simple
                    dialogoAlerta.setTitle("¡ERROR!");
                    dialogoAlerta.setHeaderText(null); //Sin título interno
                    dialogoAlerta.setContentText("Contenido en el campo no aceptado.");
                    dialogoAlerta.initStyle(StageStyle.UTILITY);
                    dialogoAlerta.showAndWait(); //Se muestra la ventana
                }
            }
        });
        
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.add(palabra, 0, 0);
        grid.add(caja, 2, 0);
        grid.add(btn, 2, 1);
        grid.add(btn2, 2, 2);
        
        Scene scene = new Scene(grid, 300, 250);
        
        primaryStage.setTitle("¡ENCRIPTAR!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
