package secure.legit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import secure.legit.data.Action;
import secure.legit.data.AnomalyInfo;
import secure.legit.data.RepositoryGitHubEvent;
import secure.legit.detector.AnomalyDetector;
import secure.legit.detector.RepositoryAnomalyDetector;
import secure.legit.handler.DefaultAnomalyHandler;

import java.util.Optional;

@RestController
@RequestMapping("/events")
public class RepositoryActionsController extends GitHubEventHandler{
    private AnomalyDetector<RepositoryGitHubEvent> anomalyDetector;

    @Autowired
    public RepositoryActionsController(RepositoryAnomalyDetector anomalyDetector,
                                       DefaultAnomalyHandler anomalyHandler) {
        super(anomalyHandler);
        this.anomalyDetector = anomalyDetector;
    }

    @Override
    String getEventDescription() {
        return "GitHub Repository action event";
    }

    @PostMapping("/repositoryEvent")
    public ResponseEntity<String> getTestData(@RequestBody RepositoryGitHubEvent repositoryEvent) {
        System.out.println("Recieved " + getEventDescription());
        String action = repositoryEvent.getAction();

        if(action.equals(Action.DELETION.value)) {
            Optional<AnomalyInfo> anomalyInfo = anomalyDetector.detectAnomaly(repositoryEvent);
            handleAnomaly(anomalyInfo);
        }

        return ResponseEntity.ok(getEventDescription() + " handled successfully.");
    }
}
