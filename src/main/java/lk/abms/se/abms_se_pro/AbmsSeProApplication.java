package lk.abms.se.abms_se_pro;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static javafx.application.Application.launch;

@SpringBootApplication
public class AbmsSeProApplication extends Application {

	public static ConfigurableApplicationContext ctx;
	private Parent  root;

	public static void main(String[] args) {

		Application.launch(args);
	}


	@Override
	public void init() throws Exception {
		ctx=SpringApplication.run(AbmsSeProApplication.class);

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Main_Page.fxml"));
		fxmlLoader.setControllerFactory(ctx::getBean);
		root =fxmlLoader.load();
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setScene(new Scene(root));
		stage.show();
	}
}
