package cianoman.GodTier.Commands;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import cianoman.GodTier.Command;
import cianoman.GodTier.Constants;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class Roll implements Command {

	@Override
	public void run(List<String> args, GuildMessageReceivedEvent event) {

        Random rand = ThreadLocalRandom.current();
        int roll = rand.nextInt(100) + 1; //This results in 1 - 6 (instead of 0 - 5)
        event.getChannel().sendMessage("Your roll: " + roll)
               .queue();
		
	}

	@Override
	public String getCommand() {
		// TODO Auto-generated method stub
		return "roll";
	}

	@Override
	public String getHelp() {
		// TODO Auto-generated method stub
		return "Rolls from 1-100!\n"
				+ "Usage: " + Constants.GodTierPrefix + getCommand() + "\n"
						+ "Hint: Play higher or lower! Best of 5";
	}
	
}

