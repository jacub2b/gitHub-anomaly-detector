package secure.legit.data;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TeamGitHubEvent extends GitHubEvent {
    Team team;
    String action;
}
