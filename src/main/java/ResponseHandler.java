import org.telegram.abilitybots.api.db.DBContext;
import org.telegram.abilitybots.api.sender.MessageSender;
import user.State;

import java.util.Map;

public class ResponseHandler {
    private final MessageSender sender;
    private final Map<Long, State> chatStates;

    public ResponseHandler(MessageSender sender, DBContext db) {
        this.sender = sender;
        chatStates = db.getMap(Constant.CHAT_STATES);
    }
}
