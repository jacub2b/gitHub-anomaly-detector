package secure.legit.handler;

import org.springframework.stereotype.Service;
import secure.legit.data.AnomalyInfo;

@Service
public class DefaultAnomalyHandler implements AnomalyHandler{
    @Override
    public void handleAnomaly(AnomalyInfo anomalyInfo) {
        System.out.println("Anomaly has been detected: " + anomalyInfo.getDescription() +
                            "\nRelated events: " + anomalyInfo.getAnomalyEvents().toString());
    }
}
