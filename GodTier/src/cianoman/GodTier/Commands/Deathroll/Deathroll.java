package cianoman.GodTier.Commands.Deathroll;

import java.util.List;
import java.util.Random;

import cianoman.GodTier.BettingAccount;
import cianoman.GodTier.Command;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class Deathroll implements Command {
	
	Long drP1;
	Long drP2;
	String drP1PlayerName;
	String drP2PlayerName;
	int betAmount;

	@Override
	public void run(List<String> args, GuildMessageReceivedEvent event) {

		MessageChannel channel = event.getChannel();
		BettingAccount bet = new BettingAccount();
		Random randomGenerator = new Random();
		String userName = event.getMember().getUser().getName();
		String msg = event.getMessage().getContentRaw();   
		long userID = event.getAuthor().getIdLong();
		
	    channel.sendMessage("The bet amount is " + betAmount).queue(); 	    
        int chosenNumber = Integer.parseInt(msg.split(" ")[1]);
		int roll = randomGenerator.nextInt(chosenNumber) + 1;
		channel.sendMessage(userName + " has rolled: "+roll).queue(); 
		
		if(roll == 1 && bet.isPlayer1(event)) {
			
			channel.sendMessage(drP2PlayerName + " has won! Their balance has increased by:" + betAmount + " ." + drP1PlayerName + " has lost: " + betAmount).queue(); 
			bet.changeBalance(drP2, betAmount);
			bet.changeBalance(drP1, -betAmount);
		}
		
		if(roll == 1 && bet.isPlayer2(event)) {
			
			channel.sendMessage(drP1PlayerName + " has won! Their balance has increased by:" + betAmount + " ." + drP2PlayerName + " has lost: " + betAmount).queue();
			bet.changeBalance(drP1, betAmount);
			bet.changeBalance(drP2, -betAmount);
		}       		
		
	}

	@Override
	public String getCommand() {
		// TODO Auto-generated method stub
		return "deathroll";
	}

	@Override
	public String getHelp() {
		// TODO Auto-generated method stub
		return null;
	}

}
