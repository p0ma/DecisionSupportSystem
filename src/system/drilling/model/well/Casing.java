package system.drilling.model.well;

import org.springframework.stereotype.Component;

@Component
public class Casing {
    private float width;
    private float height;

    public Casing() {

    }

    public Casing(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}
