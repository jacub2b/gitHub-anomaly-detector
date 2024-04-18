package secure.legit.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import secure.legit.data.AnomalyInfo;
import secure.legit.data.TeamGitHubEvent;
import secure.legit.detector.TeamAnomalyDetector;
import secure.legit.handler.DefaultAnomalyHandler;

import java.util.Optional;

@RestController
@RequestMapping("/events")
public class TeamActionsEventController extends GitHubEventHandler {
    private final TeamAnomalyDetector anomalyDetector;

    public TeamActionsEventController(TeamAnomalyDetector anomalyDetector,
                                      DefaultAnomalyHandler anomalyHandler) {
        super(anomalyHandler);
        this.anomalyDetector = anomalyDetector;
    }

    @Override
    String getEventDescription() {
        return "GitHub team action event";
    }

    @PostMapping("/teamEvent")
    public ResponseEntity<String> getTestData(@RequestBody TeamGitHubEvent teamGitHubEvent) {
        System.out.println("Recieved " + getEventDescription());
        Optional<AnomalyInfo> anomalyInfo = anomalyDetector.detectAnomaly(teamGitHubEvent);
        handleAnomaly(anomalyInfo);

        return ResponseEntity.ok(getEventDescription() + " handled successfully.");
    }
}
