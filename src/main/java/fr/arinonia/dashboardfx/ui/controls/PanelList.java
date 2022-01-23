package fr.arinonia.dashboardfx.ui.controls;

import fr.arinonia.dashboardfx.Main;
import fr.arinonia.dashboardfx.ui.transitions.SmoothsTransition;
import javafx.animation.Interpolator;
import javafx.event.EventHandler;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.*;

public class PanelList extends ScrollPane {
    private final VBox layout = new VBox();
    private final static double BASE_MODIFIER = 1;

    public PanelList() {
        this.setHbarPolicy(ScrollBarPolicy.NEVER);
        this.setBackground(Background.EMPTY);
        //this.setBorder(null);
        this.setStyle("-fx-padding: 20px 0 0 0; -fx-background-insets: 0; -fx-border-width:0; -fx-border-insets:0; -fx-background-color: transparent");
        this.layout.setOnScroll(new EventHandler<ScrollEvent>() {

            private SmoothsTransition transition;

            @Override
            public void handle(final ScrollEvent event) {
                double deltaY = BASE_MODIFIER * event.getDeltaY();
                double width = getContent().getBoundsInLocal().getWidth();
                double vvalue = getVvalue();
                Interpolator interp = Interpolator.LINEAR;
                this.transition = new SmoothsTransition(this.transition, deltaY) {
                    @Override
                    protected void interpolate(double frac) {
                        double x = interp.interpolate(vvalue, vvalue + -deltaY * getMod() / width, frac);
                        setVvalue(x);
                    }
                };
                this.transition.play();
            }
        });
        this.setFitToWidth(true);
        this.setFocusTraversable(false);

        GridPane.setHgrow(this.layout, Priority.ALWAYS);
        GridPane.setVgrow(this.layout, Priority.ALWAYS);

        this.setContent(this.layout);
        this.getStylesheets().add(Main.class.getResource("/css/bar.css").toExternalForm());
    }

    public void add(final GridPane panel) {
        this.layout.getChildren().add(panel);
    }

    public VBox getLayout() {
        return this.layout;
    }
}