package secure.legit.detector;

import secure.legit.data.AnomalyInfo;
import secure.legit.data.GitHubEvent;

import java.util.Optional;

public interface AnomalyDetector <T extends GitHubEvent> {
    public Optional<AnomalyInfo> detectAnomaly(T eventData);
    public String anomalyDescription();
}
