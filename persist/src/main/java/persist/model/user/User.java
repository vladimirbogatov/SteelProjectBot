package persist.model.user;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import one.util.streamex.StreamEx;
import persist.model.BaseEntity;

import java.beans.ConstructorProperties;
import java.time.LocalDateTime;
import java.util.*;

@NoArgsConstructor
@Setter
@Getter
public class User extends BaseEntity {

    private String name;

    private Long chatId;

    private boolean enabled = true;

    private LocalDateTime registered;

    private Set<Role> roles;

  //  @ConstructorProperties({"id", "name", "chat_id","enabled"})
    public User(Integer id, String name, Long chatId, boolean enabled, LocalDateTime registered, Collection<Role> roles) {
        super(id);
        this.name = name;
        this.chatId = chatId;
        this.enabled = enabled;
        this.registered = registered;
        setRoles(roles);
    }

    public User(String name, Long chatId, boolean enabled, LocalDateTime registered, Role... roles) {
        this (null, name, chatId, enabled, registered, Arrays.asList(roles));
    }

    public User(String name, Long chatId, boolean enabled, Role... roles) {
        this (null, name, chatId, enabled, LocalDateTime.now(), Arrays.asList(roles));
    }


    public void setRoles(Collection<Role> roles) {
        this.roles = roles.isEmpty() ? EnumSet.noneOf(Role.class) : EnumSet.copyOf(roles);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + chatId + '\'' +
                ", enabled=" + enabled +
                ", registered=" + registered +
                ", roles=" + roles +
                '}';
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }
}
