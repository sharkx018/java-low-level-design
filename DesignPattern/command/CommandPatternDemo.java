package DesignPattern.command;

public class CommandPatternDemo {

    public static void main(String[] args) {

        // receiver
        Light livingRoomLight = new Light("Living Room");
        Light kitchenRoomLight = new Light("Kitchen Room");

        // command
        Command livingRoomLightOnCommand = new LightOnCommand(livingRoomLight);
        Command livingRoomLightOffCommand = new LightOffCommand(livingRoomLight);
        Command kitchenRoomLightOnCommand = new LightOnCommand(kitchenRoomLight);
        Command kitchenRoomLightOffCommand = new LightOffCommand(kitchenRoomLight);


        // // Set up the invoker/remote
        RemoteControl remoteControl = new RemoteControl();

        remoteControl.setCommand(livingRoomLightOnCommand);
        remoteControl.pressButton();
        remoteControl.setCommand(livingRoomLightOffCommand);
        remoteControl.pressButton();
        remoteControl.setCommand(kitchenRoomLightOnCommand);
        remoteControl.pressButton();
        remoteControl.setCommand(kitchenRoomLightOffCommand);
        remoteControl.pressButton();

        remoteControl.setCommand(livingRoomLightOnCommand);
        remoteControl.pressButton();
        remoteControl.pressUndoButton();

        RemoteControlWithUndo advancedControlWithUndo = new RemoteControlWithUndo();

        advancedControlWithUndo.addCommands(livingRoomLightOnCommand);
        advancedControlWithUndo.addCommands(kitchenRoomLightOnCommand);
        advancedControlWithUndo.executeCommand();
        advancedControlWithUndo.undoCommand();
        advancedControlWithUndo.undoCommand();

    }

}