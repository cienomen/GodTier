package cianoman.GodTier.Commands;

import java.util.List;

import cianoman.GodTier.BettingAccount;
import cianoman.GodTier.Command;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class GetBalance implements Command {
	
	BettingAccount bet = new BettingAccount();

	@Override
	public void run(List<String> args, GuildMessageReceivedEvent event) {
		
		System.out.println("Started");
    	Long userID = event.getAuthor().getIdLong();
    	MessageChannel channel = event.getChannel();
		
		userID = event.getAuthor().getIdLong();
		
		bet.getBalance(userID);
		
		channel.sendMessage("Balance: "+bet.getBalance(userID)).queue();
		
		System.out.println("Complete");
		
	}

	@Override
	public String getCommand() {
		// TODO Auto-generated method stub
		return "balance";
	}

	@Override
	public String getHelp() {
		// TODO Auto-generated method stub
		return null;
	}

}
