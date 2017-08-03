package State;

public class ProgramSelected implements IWashingMachineState {

    WashingMachine washingMachine;

    public ProgramSelected(WashingMachine washingMachine) {
        this.washingMachine = washingMachine;
    }

    public void addPowder(WashingMachine washingMachine) {
        washingMachine.setMonitorString("You have already inserted detergent");
        System.out.println("You have already inserted powder");
    }

    public void selectProgram(WashingMachine washingMachine, int program) {
        System.out.println("Program " + program + " selected");
        washingMachine.machineProgramSelected = true;
        washingMachine.setProgramState(program);
        washingMachine.setState(washingMachine.getProgramSelected());
    }

    public void startMachine(WashingMachine washingMachine) {
        washingMachine.setMonitorString("You have to select program first");
        System.out.println("You have to select program first");
    }

    public void stopMachine(WashingMachine washingMachine) {
        washingMachine.setMonitorString("You have to select program and turn on the machine first");
        System.out.println("You have to select program and turn on the machine first");
    }
}
