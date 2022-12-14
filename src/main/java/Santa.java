import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Screen;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class Santa extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        final int COUNT = 12;
        final int COLUMNS = 12;
        final int OFFSET_X = 0;
        final int OFFSET_Y = 0;
        final int WIDTH = 240;
        final int HEIGHT = 80;

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        final double screenWidth = screenBounds.getWidth();
        final double screenHeight = screenBounds.getHeight();

        Image image = new Image("santa-sprite.png", WIDTH * COLUMNS, HEIGHT, true, true);
        ImageView imageView = new ImageView(image);
        imageView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));
        imageView.setScaleX(-1);

        final Animation animation = new SpriteAnimation(
                imageView,
                Duration.millis(1000),
                COUNT, COLUMNS,
                OFFSET_X, OFFSET_Y,
                WIDTH, HEIGHT
        );
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();

        Group root = new Group(imageView);

        Path path = new Path();
        path.getElements().add(new MoveTo(-WIDTH / 2, screenHeight / 2 + HEIGHT));
        path.getElements().add(new ArcTo(
                screenWidth + 2 * WIDTH,
                screenWidth + 2 * WIDTH,
                0,
                screenWidth + WIDTH / 2,
                screenHeight / 2 + HEIGHT,
                false,
                true));
        PathTransition pathTransition = new PathTransition();
        pathTransition.setPath(path);
        pathTransition.setNode(imageView);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setDuration(Duration.millis(6000));
        pathTransition.setInterpolator(Interpolator.LINEAR);
        pathTransition.setOnFinished((ActionEvent arg0) -> {
            Platform.exit();
            System.exit(0);
        });
        pathTransition.play();

        Scene scene = new Scene(root, screenWidth, screenHeight, Color.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.sizeToScene();
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
    }
}
