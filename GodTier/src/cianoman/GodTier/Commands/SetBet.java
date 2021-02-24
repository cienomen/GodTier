package cianoman.GodTier.Commands;

import java.util.List;

import cianoman.GodTier.BettingAccount;
import cianoman.GodTier.Command;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class SetBet implements Command {
	
	BettingAccount bet = new BettingAccount();

	@Override
	public void run(List<String> args, GuildMessageReceivedEvent event) {
		
		
		bet.setBet(event);
		
	}

	@Override
	public String getCommand() {
		// TODO Auto-generated method stub
		return "deathrollbet";
	}

	@Override
	public String getHelp() {
		// TODO Auto-generated method stub
		return null;
	}

}
