package cianoman.GodTier;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import cianoman.GodTier.Commands.CreateBettingAccount;
import cianoman.GodTier.Commands.GetBalance;
import cianoman.GodTier.Commands.Roll;
import cianoman.GodTier.Commands.SetBet;
import cianoman.GodTier.Commands.Deathroll.Deathroll;
import cianoman.GodTier.Commands.Deathroll.SetPlayer1;
import cianoman.GodTier.Commands.Deathroll.SetPlayer2;
//import cianoman.GodTier.Commands.Roll;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;


//Can someone please comment this code for me so I understand what is going on?

//Why do we have a map and a collection for the commands?

public class Manager {
	
	//map containing all commands

	private final Map<String, Command> commands = new HashMap<>();
	
	//manager constructor (initialises commands)
	
	public Manager(){
		
		addCommand(new Roll());
		addCommand(new CreateBettingAccount());
		addCommand(new Deathroll());
		addCommand(new SetPlayer1());
		addCommand(new SetPlayer2());
		addCommand(new SetBet());
		addCommand(new GetBalance());	
	}
	
	//add command method - 
	
	private void addCommand(Command c) {
		
		if(!commands.containsKey(c.getCommand())) {
			
			commands.put(c.getCommand(), c);
			
		}
		
	}
	
	// gets all the commands
	
	public Collection<Command> getCommands() {
		
		return commands.values();
		
	}
	
	  // gets the command with the given name
	
	public Command getCommand(String commandName) {
		if(commandName==null){
			return null;
		}
		return commands.get(commandName);		
	}
	
	// runs the command
	
	public void run(GuildMessageReceivedEvent event) {
		
		final String msg = event.getMessage().getContentRaw();
		if(!msg.startsWith(Constants.GodTierPrefix)) {
			return;
		}
		// break the message in segments, so that we can identify the command
		final String[] split = msg.replaceFirst("(?i)" + Pattern.quote(Constants.GodTierPrefix), "").split("\\s+");
		 // gets the first word & converts it to lower case
		final String command = split[0].toLowerCase();
		// if it is a command, runs it
		if(commands.containsKey(command)) {
			final List<String> args = Arrays.asList(split).subList(1, split.length);
			commands.get(command).run(args, event);			
		}		
	}
}
