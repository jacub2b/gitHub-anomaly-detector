package secure.legit.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Sender {
           private String login;
           private String id;
           private String node_id;
           private String avatar_url;
           private String gravatar_id;
           private String url;
           private String html_url;
           private String followers_url;
           private String following_url;
           private String gists_url;
           private String starred_url;
           private String subscriptions_url;
           private String organizations_url;
           private String repos_url;
           private String events_url;
           private String received_events_url;
           private String type;
           private String site_admin;
}
