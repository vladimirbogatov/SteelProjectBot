import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import static org.telegram.abilitybots.api.objects.Locality.ALL;
import static org.telegram.abilitybots.api.objects.Privacy.PUBLIC;

public class SteelProject_bot {

    private final File FILE_PROPERTIES = new File("data.properties");


    private class SteelProjectAbility extends AbilityBot {

        protected SteelProjectAbility() {
            super(getBotsToken(), getBotsName());
        }

        //todo пока не знаю, что это за id
        @Override
        public long creatorId() {
            return 235629427;
        }

        @Override
        public void onUpdatesReceived(List<Update> updates) {
            super.onUpdatesReceived(updates);
        }

        @Override
        public void onClosing() {
            super.onClosing();
        }
    }

    private String getBotsToken() {
        return getProperties().getProperty("BOT_TOKEN");
    }

    private String getBotsName() {
        return getProperties().getProperty("BOT_NAME");
    }

    private Properties getProperties() {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(FILE_PROPERTIES));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }

    public AbilityBot getBot() {
        return new SteelProjectAbility();
    }

/*
    public Reply replyToButtons() {
        Consumer<Update> action = upd -> KeyboardFactory.checkKeyboard(AbilityUtils.getChatId(upd), upd.getCallbackQuery().getData());
        return Reply.of(action, Flag.CALLBACK_QUERY);
    }

    public AbilityExtension replyToStart () {
        return new StartCommand(this);
    }

    public AbilityExtension replyToRegister () {
        return new RegisterCommand(this);
    }*/

}
