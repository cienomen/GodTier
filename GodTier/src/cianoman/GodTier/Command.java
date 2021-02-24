package cianoman.GodTier;

import java.util.List;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public interface Command {
	
	void run(List<String> args, GuildMessageReceivedEvent event);
	
	String getCommand();
	String getHelp();
	
	

}
