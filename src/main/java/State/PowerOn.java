package State;

public class PowerOn implements IWashingMachineState {

    WashingMachine washingMachine;

    public PowerOn(WashingMachine washingMachine) {
        this.washingMachine = washingMachine;
    }

    public void addPowder(WashingMachine washingMachine) {
        washingMachine.setMonitorString("You have already added powder");
        System.out.println("You have already added powder");
    }


    public void selectProgram(WashingMachine washingMachine, int program) {
        washingMachine.setMonitorString("You have already selected program");
        System.out.println("You have already selected program");
    }

    public void startMachine(WashingMachine washingMachine) {
        washingMachine.setMonitorString("Washing machine power on");
        System.out.println("Washing machine power on");
        washingMachine.machinePowerOn = true;
        washingMachine.setState(washingMachine.getPowerOnSelected());
    }

    public void stopMachine(WashingMachine washingMachine) {
        washingMachine.setMonitorString("Washing machine in not running");
        System.out.println("Washing machine is not ON");
    }
}
