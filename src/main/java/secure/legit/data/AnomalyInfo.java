package secure.legit.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AnomalyInfo {
    private String description;
    private List<GitHubEvent> anomalyEvents;
}
