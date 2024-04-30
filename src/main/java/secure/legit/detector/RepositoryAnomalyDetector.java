package secure.legit.detector;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.stereotype.Service;
import secure.legit.data.Action;
import secure.legit.data.AnomalyInfo;
import secure.legit.data.RepositoryData;
import secure.legit.data.RepositoryGitHubEvent;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Optional;

@Service
public class RepositoryAnomalyDetector implements AnomalyDetector {
    private final int MINIMAL_DELETION_MINUTES = 5;

    private final Gson gson;


    @Autowired
    public RepositoryAnomalyDetector(Gson gson) {
        this.gson = gson;
    }

    @Override
    public Optional<AnomalyInfo> detectAnomaly(String eventPayload) {
        RepositoryGitHubEvent eventData = gson.fromJson(eventPayload, RepositoryGitHubEvent.class);
        String creationTime = eventData.getRepository().getCreated_at();
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(creationTime);
        ZonedDateTime currentTime = ZonedDateTime.now();
        long minutesBeforeDeletion = ChronoUnit.MINUTES.between(zonedDateTime, currentTime);

        if (eventData.getAction().equals(Action.DELETION.value)
        && minutesBeforeDeletion < MINIMAL_DELETION_MINUTES) {
            return Optional.of(new AnomalyInfo(anomalyDescription(), Collections.singletonList(eventData)));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public String anomalyDescription() {
        return "A repository has been deleted less than " + MINIMAL_DELETION_MINUTES + " minutes after being created!";
    }

    @Override
    public String eventName() {
        return "repository";
//        todo
    }
}
