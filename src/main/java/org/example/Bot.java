package org.example;


import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import org.example.listeners.EventListener;

import javax.security.auth.login.LoginException;

public class Bot {
    private final Dotenv config;
    private final ShardManager shardManager;
    /*
    * Loads environment variables and build the bot shard manager
    * @throws LoginException occur bot token is invalid
    * */
    public Bot() throws LoginException {
        config = Dotenv.configure().load();
        String token = config.get("TOKEN");
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.watching("SpeedyAstro 🫡"));
        shardManager = builder.build();

        //Register Listeners
        shardManager.addEventListener(new EventListener());
    }
    public Dotenv getConfig(){
        return config;
    }
    public ShardManager getShardManager(){
        return shardManager;
    }
    public static void main(String[] args) {
        try {
            Bot bot = new Bot();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}