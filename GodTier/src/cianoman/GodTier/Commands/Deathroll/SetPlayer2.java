package cianoman.GodTier.Commands.Deathroll;

import java.util.List;

import cianoman.GodTier.BettingAccount;
import cianoman.GodTier.Command;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class SetPlayer2 implements Command {
	
	BettingAccount bet = new BettingAccount();

	@Override
	public void run(List<String> args, GuildMessageReceivedEvent event) {
		
		
		Long id = event.getAuthor().getIdLong();
		bet.setPlayer2(id, event);
		
	}

	@Override
	public String getCommand() {
		// TODO Auto-generated method stub
		return "drplayer2";
	}

	@Override
	public String getHelp() {
		// TODO Auto-generated method stub
		return null;
	}

}
