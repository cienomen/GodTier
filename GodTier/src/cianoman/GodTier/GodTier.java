package cianoman.GodTier;
import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.utils.ChunkingFilter;


public class GodTier extends ListenerAdapter
{

	public static String token = "ODE0MTA0ODI5NDkxNTQ0MDkz.YDZANA.CEZ8xz-HSIRMIFXv95ohtRPFdj8";

			
	
	public static void main(String[] args) throws LoginException, InterruptedException
	{
		BettingAccount bet = new BettingAccount();
		
    	JDA jda = JDABuilder.createDefault(token)
    			.setActivity(Activity.listening("Lotus and Ketchi's beats."))
    			.setChunkingFilter(ChunkingFilter.ALL)
    			.addEventListeners(new Listener())
    			.build()
    			.awaitReady();
    }
}
