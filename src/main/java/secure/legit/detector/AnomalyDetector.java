package secure.legit.detector;

import secure.legit.data.AnomalyInfo;
import secure.legit.data.GitHubEvent;

import java.util.Optional;

public interface AnomalyDetector {
    public Optional<AnomalyInfo> detectAnomaly(String eventData);
    public String anomalyDescription();
}
