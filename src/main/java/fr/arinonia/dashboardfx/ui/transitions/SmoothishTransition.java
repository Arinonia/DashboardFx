package fr.arinonia.dashboardfx.ui.transitions;

import javafx.animation.Transition;
import javafx.util.Duration;

public abstract class SmoothishTransition extends Transition {

    private final double mod;
    private final double delta;
    private final static int TRANSITION_DURATION = 200;

    public SmoothishTransition(SmoothishTransition old, double delta) {
        this.setCycleDuration(Duration.millis(TRANSITION_DURATION));
        this.setCycleCount(0);
        if (old != null && this.sameSign(delta, old.delta) && this.playing(old)) {
            this.mod = old.getMod() + 1;
        } else {
            this.mod = 1;
        }
        this.delta = delta;
    }

    public double getMod() {
        return this.mod;
    }

    @Override
    public void play() {
        super.play();
        if (this.getMod() > 1) {
            this.jumpTo(this.getCycleDuration().divide(10));
        }
    }

    private boolean playing(Transition t) {
        return t.getStatus() == Status.RUNNING;
    }

    private boolean sameSign(double d1, double d2) {
        return (d1 > 0 && d2 > 0) || (d1 < 0 && d2 < 0);
    }
}
