package operation;

import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.abilitybots.api.objects.Locality;
import org.telegram.abilitybots.api.objects.Privacy;
import org.telegram.abilitybots.api.util.AbilityExtension;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static org.telegram.abilitybots.api.objects.Locality.ALL;
import static org.telegram.abilitybots.api.objects.Privacy.PUBLIC;

public class StartCommand extends OperationCommand implements AbilityExtension {
    private final String command = "start";
    private final String description = "Это команда приветствие. Она позволяет познакомиться с пользователе и зарегистрироваться, если пользователь не знаком боту";

    public StartCommand(AbilityBot bot) {
        super(bot);
    }

    public Ability replyToStart() {
        return Ability.builder()
                .name(command)
                .info(description)
                .locality(ALL)
                .privacy(PUBLIC)
                .action(ctx -> {
                            try {
                                bot.sender().execute
                                        (
                                                SendMessage.builder()
                                                        .text("Текст нужен")
                                                        .chatId(ctx.chatId().toString())
                                                        .replyMarkup(KeyboardFactory.startButton())
                                                        .build()
                                        );
                            } catch (TelegramApiException e) {
                                e.printStackTrace();
                            }
                        }
                )
                .build();
    }
}
