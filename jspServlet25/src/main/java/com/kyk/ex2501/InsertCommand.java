package com.kyk.ex2501;

import com.kyk.ex2501.command.MyCommand;

public class InsertCommand implements MyCommand {

	@Override
	public void execute() {
		System.out.println("command���� insert��û ó��");
	}

}
