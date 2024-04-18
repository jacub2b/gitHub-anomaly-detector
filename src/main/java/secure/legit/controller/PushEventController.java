package secure.legit.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import secure.legit.data.AnomalyInfo;
import secure.legit.data.PushGitHubEvent;
import secure.legit.detector.PushAnomalyDetector;
import secure.legit.handler.DefaultAnomalyHandler;

import java.util.Optional;

@RestController
@RequestMapping("/events")
public class PushEventController extends GitHubEventHandler {
    private final PushAnomalyDetector anomalyDetector;

    @Autowired
    public PushEventController(PushAnomalyDetector anomalyDetector,
                               DefaultAnomalyHandler anomalyHandler) {
        super(anomalyHandler);
        this.anomalyDetector = anomalyDetector;
    }

    @Override
    String getEventDescription() {
        return "GitHub push event";
    }

    @PostMapping("/pushEvent")
    public ResponseEntity<String> getTestData(@RequestBody PushGitHubEvent pushEvent) {
        System.out.println("Recieved " + getEventDescription());
        Optional<AnomalyInfo> anomalyInfo = anomalyDetector.detectAnomaly(pushEvent);
        handleAnomaly(anomalyInfo);

        return ResponseEntity.ok(getEventDescription() + " handled successfully.");
    }
}
