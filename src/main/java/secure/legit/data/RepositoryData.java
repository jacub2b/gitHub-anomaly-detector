package secure.legit.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RepositoryData {
    private String id;
    private String node_id;
    private String name;
    private String full_name;
    private Sender owner;
    private String created_at;
    private String pushed_at;
}