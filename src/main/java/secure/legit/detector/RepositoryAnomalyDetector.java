package secure.legit.detector;

import org.springframework.stereotype.Service;
import secure.legit.data.Action;
import secure.legit.data.AnomalyInfo;
import secure.legit.data.RepositoryGitHubEvent;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Optional;

@Service
public class RepositoryAnomalyDetector implements AnomalyDetector<RepositoryGitHubEvent> {


    private static final int MINIMAL_DELETION_MINUTES = 5;

    @Override
    public Optional<AnomalyInfo> detectAnomaly(RepositoryGitHubEvent eventData) {
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
}
