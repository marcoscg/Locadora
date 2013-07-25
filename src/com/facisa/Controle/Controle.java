package com.facisa.Controle;

import com.facisa.Command.Command;
import java.util.List;
import java.util.ArrayList;

public class Controle {
	private List<Command> history = new ArrayList<Command>();
	
    public Controle() {
    }	
    
    public void execute(Command cmd){
    	this.history.add(cmd);
    	cmd.execute();
    }	
	
}
