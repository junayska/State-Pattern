package State;

public class HasPowder implements IWashingMachineState {

    WashingMachine washingMachine;

    public HasPowder(WashingMachine washingMachine) {
        this.washingMachine = washingMachine;
    }

    public void addPowder(WashingMachine washingMachine){
        System.out.println("Powder inserted");
        washingMachine.setMonitorString("Detergent inserted!");
        washingMachine.machinePowderInserted = true;
        washingMachine.setState(washingMachine.getPowderInserted());
    }

    public void selectProgram(WashingMachine washingMachine, int program) {

        System.out.println("Insert powder first");
        washingMachine.setMonitorString("Insert detergent first!");
    }

    public void startMachine(WashingMachine washingMachine) {
        washingMachine.setMonitorString("Insert detergent and select program first");
        System.out.println("Insert detergent and select program first");
    }

    public void stopMachine(WashingMachine washingMachine) {
        washingMachine.setMonitorString("Insert detergent, select program first and start a machine first");
        System.out.println("Insert detergent, select program first and start a machine first");
    }



}
