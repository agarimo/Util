package util;

import java.sql.ResultSet;
import javafx.application.Platform;
import javafx.scene.control.Alert;

/**
 *
 * @author Agarimo
 */
public class Query {
    private static Sql bd;
    private static ResultSet rs;
    
    private static void error(String aux) {
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("ERROR DE CONEXIÓN");
            alert.setContentText(aux);

            alert.showAndWait();
        });
    }
}
