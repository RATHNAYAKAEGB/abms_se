package lk.abms.se.abms_se_pro.util;

import javafx.animation.TranslateTransition;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

import javafx.scene.image.ImageView;
import org.springframework.stereotype.Component;

@Component
public class ViewTravaler {

    public  void showScreen(ImageView img, Parent parent){
        Scene subScene = new Scene(parent);
        System.out.println(img);
        Stage primaryStage = (Stage) img.getScene().getWindow();
        primaryStage.setScene(subScene);
        primaryStage.centerOnScreen();
        TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
        tt.setFromX(-subScene.getWidth());
        tt.setToX(0);
        tt.play();
    }

}
