package cianoman.GodTier;

import javax.annotation.Nonnull;

import net.dv8tion.jda.api.audio.hooks.ConnectionListener;
import net.dv8tion.jda.api.audio.hooks.ConnectionStatus;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Listener extends ListenerAdapter{

	public final Manager m = new Manager();


	   @Override
	   public void onReady(@Nonnull ReadyEvent event) {
		   System.out.println(event.getJDA().getSelfUser().getName() + " is online!");
	   }
	   
	   @Override
	   public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
		   if(event.getMessage().getContentRaw().equalsIgnoreCase(Constants.GodTierPrefix+"shutdown") && event.getAuthor().getIdLong()==Constants.OWNERID) {
			   
			   event.getJDA().shutdown();
			   System.exit(0);
			   
		   }
		   
		   m.run(event);
		   
	   }
	 

}
