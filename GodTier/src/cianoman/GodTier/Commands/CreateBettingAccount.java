package cianoman.GodTier.Commands;

import java.util.List;

import cianoman.GodTier.Command;
import cianoman.GodTier.BettingAccount;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CreateBettingAccount extends ListenerAdapter implements Command {
	


	@Override
	public void run(List<String> args, GuildMessageReceivedEvent event) {
		
		Long userInput = event.getAuthor().getIdLong();
		MessageChannel channel = event.getChannel();
		BettingAccount bet = new BettingAccount();
		
		
		if(!bet.accountExistence(userInput)) {
		bet.setBalance(userInput, 1000);
		channel.sendMessage("You have created an account! Your balance is: "+ bet.getBalance(userInput)).queue();
		System.out.println("User Balance " + bet.getBalance(userInput));
		} else if (bet.accountExistence(userInput)) {
			
			channel.sendMessage("Oh no! Account already exists.").queue();
		}		
	}

	@Override
	public String getCommand() {
		
		return "createbettingaccount";
	}

	@Override
	public String getHelp() {
		// TODO Auto-generated method stub
		return "Creates a betting account with 1000 points! \n"
				+ "Usage: type !createbettingaccount to create an account.";
	}

}
