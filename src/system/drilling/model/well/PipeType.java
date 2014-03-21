package system.drilling.model.well;

public class PipeType {
    private float innerDiam;
    private float thickness;

    public PipeType(float innerDiam, float thickness) {
        this.innerDiam = innerDiam;
        this.thickness = thickness;
    }

    public float getInnerDiam() {
        return innerDiam;
    }

    public void setInnerDiam(float innerDiam) {
        this.innerDiam = innerDiam;
    }

    public float getThickness() {
        return thickness;
    }

    public void setThickness(float thickness) {
        this.thickness = thickness;
    }
}
