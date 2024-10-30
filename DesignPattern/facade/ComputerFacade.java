package DesignPattern.facade;

public class ComputerFacade {
    private CPU cpu;
    private HardDrive hardDrive;
    private Memory memory;

    ComputerFacade(){
        this.cpu = new CPU();
        this.hardDrive = new HardDrive();
        this.memory = new Memory();

    }

    public void start(){
        System.out.println("Computer facade, Starting the computer");
        cpu.freeze();
        memory.load(0, hardDrive.read(0, 1024));
        cpu.jump(0);
        cpu.execute();
        System.out.println("ComputerFacade: Computer has started");

    }

}
