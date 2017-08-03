package State;

public interface IWashingMachineState {

    void addPowder(WashingMachine washingMachine);

    void selectProgram(WashingMachine washingMachine, int program);

    void startMachine(WashingMachine washingMachine);

    void stopMachine(WashingMachine washingMachine);
}
