/*
* This code demonstrates the Facade design pattern in Java.
* The Facade pattern provides a simplified interface to a complex subsystem.
* Suppose we have an n number of classes or obects of this classes
* and we want to provide a simple interface to call the methods of these classes.
*
* We create a Facade class that wraps all the required functionality from these classes and bundle it in a single method.
* The client interacts with the Facade class and call one method and under the hood all these classes respective methods are called.
*
* Client need not to call every time the list of methods from these classes.
* The Facade class provides a simple interface to the client.
*
* */


// Complex Subsystems
class CPU { void start() { System.out.println("CPU started"); } }
class Memory { void load() { System.out.println("Memory loaded"); } }
class HardDrive { void read() { System.out.println("Hard Drive read"); } }

// Facade
class ComputerFacade {
    private CPU cpu = new CPU();
    private Memory memory = new Memory();
    private HardDrive hd = new HardDrive();

    public void startComputer() {
        cpu.start();
        memory.load();
        hd.read();
        System.out.println("Computer started successfully!");
    }
}

// Client
public class FacadeDemo {
    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade();
        computer.startComputer();
    }
}


