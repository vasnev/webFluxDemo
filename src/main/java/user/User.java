package user;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 10.09.18.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    private String name;
    private List<User> followers = new ArrayList<>();

    public void follow(User follower) {
        followers.add(follower);
    }
}
