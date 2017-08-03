package State;

public class PowerOff implements IWashingMachineState {

    WashingMachine washingMachine;

    public PowerOff(WashingMachine washingMachine) {
        this.washingMachine = washingMachine;
    }

    public void addPowder(WashingMachine washingMachine) {
        washingMachine.setMonitorString("Washing machine is running");
        System.out.println("Washing machine is running");
    }


    public void selectProgram(WashingMachine washingMachine, int program) {
        washingMachine.setMonitorString("Washing machine is running");
        System.out.println("Washing machine is running");
    }

    public void startMachine(WashingMachine washingMachine) {
        washingMachine.setMonitorString("Washing machine is running");
        System.out.println("Washing machine is running");
    }

    public void stopMachine(WashingMachine washingMachine) {
        washingMachine.setMonitorString("Stopping Washing machine");
        System.out.println("Stopping Washing machine");
        washingMachine.setState(washingMachine.getPowerOffSelected());
        washingMachine.machinePowerOn = false;
        washingMachine.machinePowderInserted = false;
        washingMachine.washingMachineProgram = 0;
        washingMachine.machineProgramSelected = false;
    }
}
