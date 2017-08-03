package State;

import org.junit.Test;
import static org.junit.Assert.*;

public class WashingMachineTest {

    @Test
    public void testPowderInserting() throws Exception {
        WashingMachine wm = new WashingMachine();
        wm.addPowder();
        assertEquals(wm.machinePowderInserted, true);
    }

    @Test
    public void testProgramSelecting() throws Exception {
        WashingMachine wm = new WashingMachine();
        wm.addPowder();
        wm.selectProgram(3);
        assertEquals(wm.machinePowderInserted, true);
        assertEquals(wm.washingMachineProgram,3);
    }

    @Test
    public void testStartingWashingMachine() throws Exception {
        WashingMachine wm = new WashingMachine();
        wm.addPowder();
        wm.selectProgram(3);
        wm.startMachine();
        assertEquals(wm.machinePowderInserted, true);
        assertEquals(wm.washingMachineProgram,3);
        assertEquals(wm.machinePowerOn, true);
    }

    @Test
    public void testStoppingWashingMachine() throws Exception {
        WashingMachine wm = new WashingMachine();
        wm.addPowder();
        wm.selectProgram(3);
        wm.startMachine();
        wm.stopMachine();

        assertEquals(1,wm.washingMachineProgram);
        assertEquals(false, wm.machinePowerOn);
        assertEquals(false, wm.machinePowderInserted);
    }

}