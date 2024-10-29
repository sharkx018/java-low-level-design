package DesignPattern.command;

import java.util.ArrayList;
import java.util.List;

public class RemoteControlWithUndo {
    private List<Command> commands = new ArrayList<>();
    private List<Command> undoCommands = new ArrayList<>();

    public void addCommands(Command command){
        this.commands.add(command);
    }

    public void executeCommand(){
        for(Command command: commands){
            command.execute();
            undoCommands.add(command);
        }

        commands.clear();
    }

    public void undoCommand(){
        if(!undoCommands.isEmpty()){
            Command lastCommand = undoCommands.remove(undoCommands.size()-1);
            lastCommand.undo();
        }

    }



}