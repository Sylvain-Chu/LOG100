package labo6.src;

public class GateScreen extends Observer{
    private Gate gate;

    public GateScreen(Gate gate) {
        this.gate = gate;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    @Override
    public void update() {

    }
}
