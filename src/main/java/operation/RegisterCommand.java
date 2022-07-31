package operation;

import com.sun.xml.bind.v2.TODO;
import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.abilitybots.api.util.AbilityExtension;

import static org.telegram.abilitybots.api.objects.Locality.ALL;
import static org.telegram.abilitybots.api.objects.Privacy.PUBLIC;

public class RegisterCommand extends OperationCommand implements AbilityExtension {
    private final String command = "reg";
    //TODO не забыть описать Description
    private final String description = "";
    public RegisterCommand(AbilityBot bot) {
        super(bot);
    }

    public Ability replyToStart (){
        return Ability.builder()
                .name(command)
                .info(description)
                .locality(ALL)
                .privacy(PUBLIC)
                .action(ctx -> bot.silent().send(ctx.chatId().toString(), ctx.chatId()))
                .build();
    }
}
