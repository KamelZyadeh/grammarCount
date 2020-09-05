package com.zyadeh.kamel.command;

import com.zyadeh.kamel.command.impl.AnalysisCommand;
import com.zyadeh.kamel.command.impl.NextCommand;
import com.zyadeh.kamel.command.impl.PreviousCommand;

public class CommandFcatory {

    public static Command getCommand(String commandType) {

        switch (commandType) {
            case "command_analysis":
                return new AnalysisCommand();
            case "next_command":
                return new NextCommand();
            case "previous_command":
                return new PreviousCommand();
            default:
                return null;
        }
    }
}
