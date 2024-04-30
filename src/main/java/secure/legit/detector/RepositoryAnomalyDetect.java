package secure.legit.detector;

import secure.legit.data.AnomalyInfo;

import java.util.Optional;

public class RepositoryAnomalyDetect extends AnomalyDetector<>{
    @Override
    public Optional<AnomalyInfo> detectAnomaly(String eventData) {
        return Optional.empty();
    }

    @Override
    public String anomalyDescription() {
        return null;
    }
}
