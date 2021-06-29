package donkey;

import javafx.stage.WindowEvent;
import java.util.Random;
import javafx.scene.media.MediaPlayer;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.control.Button;
import javafx.application.Application;

public class Main extends Application
{
    String s;
    Button btn1;
    Button btn2;
    Media noise;
    Image donkeyIcon;
    Image donkeyPhoto;
    
    public static void main(final String[] args) {
        launch(args);
    }
    
    public void start(final Stage primaryStage) throws Exception {
        final Stage window1 = primaryStage;
        window1.setOnCloseRequest(e -> e.consume());
        window1.setTitle("DONKEY");
        System.out.println(System.getProperty("user.dir"));
        this.donkeyIcon = new Image(this.getClass().getResourceAsStream("donkey.png"));
        //window1.getIcons().add((Object)this.donkeyIcon);
        window1.getIcons().add(this.donkeyIcon);
        final Button insert = new Button("ENTER");
        final Button exit = new Button("EXIT");
        final Label name = new Label("INPUT YOUR NAME: ");
        final TextField nameIn = new TextField();
        insert.setLayoutX(250.0);
        insert.setLayoutY(250.0);
        final BorderPane layout1 = new BorderPane();
        final VBox topBox = new VBox(new Node[] { (Node)name, (Node)nameIn, (Node)insert });
        final VBox bottomBox = new VBox(new Node[] { (Node)exit });
        topBox.setAlignment(Pos.CENTER);
        bottomBox.setAlignment(Pos.BOTTOM_CENTER);
        layout1.setCenter((Node)topBox);
        layout1.setBottom((Node)bottomBox);
        final Scene scene1 = new Scene((Parent)layout1, 300.0, 200.0);
        window1.setScene(scene1);
        final Stage window2 = new Stage();
        window2.setOnCloseRequest(e -> e.consume());
        //window2.getIcons().add((Object)this.donkeyIcon);
        window2.getIcons().add(this.donkeyIcon);
        final StackPane layout2 = new StackPane();
        insert.setOnAction(e -> {
            this.s = nameIn.getText();
            if (this.s.equals("")) {
                window1.show();
            }
            else {
                System.out.println(this.s);
                window1.close();
                window2.setTitle(this.s + " IS A DONKEY");
                this.btn1 = new Button(this.s + ", YOU ARE A FUCKING DONKEY");
                this.btn2 = new Button("EXIT ;)");
                final ImageView layoutImg = new ImageView();
                layoutImg.setImage(this.donkeyPhoto = new Image(this.getClass().getResourceAsStream("you.jpg")));
                this.noise = new Media(this.getClass().getResource("donkeyNoise.mp3").toString());
                final MediaPlayer media = new MediaPlayer(this.noise);
                media.setAutoPlay(true);
                media.setVolume(1.0);
                //layout2.getChildren().addAll((Object[])new Node[] { (Node)layoutImg, (Node)this.btn1, (Node)this.btn2 });
                layout2.getChildren().addAll(new Node[] { (Node)layoutImg, (Node)this.btn1, (Node)this.btn2 });
                StackPane.setAlignment((Node)this.btn2, Pos.BOTTOM_CENTER);
                final Scene scene2 = new Scene((Parent)layout2, 1280.0, 720.0);
                window2.setScene(scene2);
                window2.show();
                this.btn1.setOnAction(e1 -> {
                    final Random rand = new Random();
                    final MediaPlayer media1 = new MediaPlayer(this.noise);
                    media1.setAutoPlay(true);
                    media1.setVolume(1.0);
                    final Stage loop = new Stage();
                    loop.setOnCloseRequest(ec -> ec.consume());
                    loop.setTitle(this.s + " IS A DONKEY");
                    //loop.getIcons().add((Object)this.donkeyIcon);
                    loop.getIcons().add(this.donkeyIcon);
                    loop.setScene(scene2);
                    loop.setX((double)rand.nextInt(800));
                    loop.setY((double)rand.nextInt(300));
                    loop.show();
                });
                this.btn2.setOnAction(e2 -> {
                    final Random rand = new Random();
                    final MediaPlayer media2 = new MediaPlayer(this.noise);
                    media2.setAutoPlay(true);
                    media2.setVolume(1.0);
                    while (true) {
                        final Stage loop = new Stage();
                        loop.setOnCloseRequest(ec -> ec.consume());
                        loop.setTitle(this.s + " IS A DONKEY");
                        //loop.getIcons().add((Object)this.donkeyIcon);
                        loop.getIcons().add(this.donkeyIcon);
                        loop.setScene(scene2);
                        loop.setX((double)rand.nextInt(800));
                        loop.setY((double)rand.nextInt(300));
                        loop.show();
                    }
                });
            }
        });
        exit.setOnAction(e -> {
            System.out.println(this.s);
            window1.close();
        });
        window1.show();
    }
}