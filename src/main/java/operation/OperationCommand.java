package operation;

import org.telegram.abilitybots.api.bot.AbilityBot;

abstract public class OperationCommand {
    AbilityBot bot;
    public OperationCommand (AbilityBot bot) {
        this.bot = bot;
    }



}
