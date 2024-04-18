package secure.legit.data;

import lombok.Data;

@Data
public class Team {

           private String name;
           private String id;
           private String node_id;
           private String slug;
           private String description;
           private String privacy;
           private String notification_setting;
           private String url;
           private String html_url;
           private String members_url;
           private String repositories_url;
           private String permission;
           private String parent;

}
