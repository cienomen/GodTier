package cianoman.GodTier;


import java.util.HashMap;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class BettingAccount extends ListenerAdapter{
	
	private long drP1;
	private long drP2;
	private String drP1PlayerName;
	private String drP2PlayerName;
	private String userName;
	private MessageChannel channel;
	private int betAmount;
	

	/**
	 * 
	 */
	
	int balance;
	private static final long serialVersionUID = -5058228294731521994L;
	public static HashMap<Long, Integer> playerBalance = new HashMap<>();
	
          
      public int getBalance(Long id) {  	  
    	  
    	  return playerBalance.get(id);
    	  
      }
      
      public void setBalance(Long id, int newBalance) {
    	  
    	  playerBalance.put(id, newBalance);
      }
      
      public void setBet(GuildMessageReceivedEvent event) {
    	this.channel = event.getChannel();  
    	String msg = event.getMessage().getContentRaw();
  		betAmount = Integer.parseInt(msg.split(" ")[1]);
  		channel.sendMessage("The next wager for any game will be "+ betAmount).queue(); 
  		
      }
      
      public void getBet(GuildMessageReceivedEvent event) {
 
    		channel.sendMessage("The next wager for any game will be "+ betAmount).queue(); 
    		
        }
      
      public void changeBalance(Long id, int x) {
    	  
    	  playerBalance.put(id, playerBalance.get(id) + x);
    	  
      }
     
      public boolean accountExistence(Long id) {
    	  if(playerBalance.containsKey(id)) {
    		  return true;
    	  } else {
    	  return false;
    	  }
    	  
      }
      
      public void setPlayer1(Long id, GuildMessageReceivedEvent event) {
    	  
    	  this.channel = event.getChannel();
    	  this.drP1 = event.getAuthor().getIdLong();
  		  this.drP1PlayerName = event.getAuthor().getName();
  		  this.channel.sendMessage(drP1PlayerName + " is now player 1! ").queue();
   	  
      }
      
      public void setPlayer2(Long id, GuildMessageReceivedEvent event) {
    	  
    	  this.channel = event.getChannel();
    	  this.drP2 = event.getAuthor().getIdLong();
  		  this.drP2PlayerName = event.getAuthor().getName();
  		  this.channel.sendMessage(drP2PlayerName + " is now player 2! ").queue();

   	  
      }
      
      public void getPlayer1(Long id, GuildMessageReceivedEvent event) {
    	 
    	  this.drP1 = event.getAuthor().getIdLong();
   	  
      }
      
      public void getPlayer2(Long id, GuildMessageReceivedEvent event) {
    	  
    	  this.drP2 = event.getAuthor().getIdLong();
   	  
      }
      
      public boolean isPlayer1(GuildMessageReceivedEvent event) {
    	  
    	  if(event.getMessageIdLong() == drP1) {
    		  
    		  return true;
    	  }
    	  
    	  return false;
    	  
      }
      
      public boolean isPlayer2(GuildMessageReceivedEvent event) {
    	  
    	  if(event.getMessageIdLong() == drP2) {
    		  
    		  return true;
    	  }
    	  
    	  return false;
    	  
      }
      
      
}
