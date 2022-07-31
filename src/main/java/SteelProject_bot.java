import operation.*;
import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Flag;
import org.telegram.abilitybots.api.objects.Reply;
import org.telegram.abilitybots.api.util.AbilityExtension;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.function.Consumer;

import static org.telegram.abilitybots.api.util.AbilityUtils.getChatId;

public class SteelProject_bot extends AbilityBot {
    String START_DESCRIPTION = "Hello";
    private final ResponseHandler responseHandler;


    protected SteelProject_bot(String botToken, String botUsername) {
        super(botToken, botUsername);
        responseHandler = new ResponseHandler(sender, db);
    }

    @Override
    public String getBotUsername() {
        return Constant.BOT_NANE;
    }

    @Override
    public long creatorId() {
        return 235629427;
    }

    @Override
    public String getBotToken() {
        return Constant.BOT_TOKEN;
    }

    public Reply replyToButtons() {
        Consumer<Update> action = upd -> KeyboardFactory.checkKeyboard(getChatId(upd), upd.getCallbackQuery().getData());
        return Reply.of(action, Flag.CALLBACK_QUERY);
    }

    public AbilityExtension replyToStart () {
        return new StartCommand(this);
    }

    public AbilityExtension replyToRegister () {
        return new RegisterCommand(this);
    }

    @Override
    public void onClosing() {
        super.onClosing();
    }
}
