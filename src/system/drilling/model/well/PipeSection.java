package system.drilling.model.well;

public class PipeSection {
    private PipeType pipeType;
    private float length;

    public PipeSection() {

    }

    public PipeType getPipeType() {
        return pipeType;
    }

    public void setPipeType(PipeType pipeType) {
        this.pipeType = pipeType;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }


}
