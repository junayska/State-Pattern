package State;

public class WashingMachine {

    IWashingMachineState hasPowder;
    IWashingMachineState programSelected;
    IWashingMachineState powerOff;
    IWashingMachineState powerOn;

    IWashingMachineState iWashingMachineState;

    private String monitorString;
    int washingMachineProgram = 0;
    public boolean machinePowderInserted = false;
    public boolean machinePowerOn = false;
    public boolean machineProgramSelected = false;


    public WashingMachine(){
        hasPowder = new HasPowder(this);
        programSelected = new ProgramSelected(this);
        powerOn = new PowerOn(this);
        powerOff = new PowerOff(this);

        iWashingMachineState = hasPowder;
    }

    protected void setState(IWashingMachineState iWMS){
        iWashingMachineState = iWMS;
    }

    public void addPowder(){
        iWashingMachineState.addPowder(this);
    }

    public void selectProgram(int program){
        iWashingMachineState.selectProgram(this, program);
    }

    public void startMachine(){
        iWashingMachineState.startMachine(this);
    }

    public void stopMachine(){
        iWashingMachineState.stopMachine(this);
    }

    protected IWashingMachineState getPowderInserted(){return programSelected;}
    protected IWashingMachineState getProgramSelected(){return powerOn;}
    protected IWashingMachineState getPowerOnSelected(){return powerOff;}
    protected IWashingMachineState getPowerOffSelected(){return hasPowder;}

    public void setProgramState(int program){
        this.washingMachineProgram = program;
        switch (program){
            case 1:
                setMonitorString("Cotton 40c program selected");
                break;
            case 2:
                setMonitorString("Cotton 60c program selected");
                break;
            case 3:
                setMonitorString("Synthetic 30c program selected");
                break;
            case 4:
                setMonitorString("Fast program selected");
                break;
        }
    }

    protected void setMonitorString(String s){
        this.monitorString = s;
    }

    public String getMonitorString(){ return this.monitorString + "\n"; }

}
