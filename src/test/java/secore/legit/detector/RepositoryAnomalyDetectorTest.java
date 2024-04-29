package secore.legit.detector;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import secure.legit.data.Action;
import secure.legit.data.AnomalyInfo;
import secure.legit.data.RepositoryData;
import secure.legit.data.RepositoryGitHubEvent;
import secure.legit.detector.RepositoryAnomalyDetector;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RepositoryAnomalyDetectorTest {
    private static RepositoryAnomalyDetector anomalyDetector;

    @BeforeAll
    public static void setUp() {
        anomalyDetector = new RepositoryAnomalyDetector();
    }

    @Test
    public void detectAnomaly_shouldDetectWhenDeletedWithingTime() {
        String fourMinutesAgo = ZonedDateTime.now().minusMinutes(4).toString();
        Optional<AnomalyInfo> anomalyInfo = anomalyDetector.detectAnomaly(buildEvent(Action.DELETION.value, fourMinutesAgo));
        assertTrue(anomalyInfo.isPresent());
    }

    @Test
    public void detectAnomaly_shouldNotDetectWhenDeletedAfterTime() {
        String fiveMinutesAgo = ZonedDateTime.now().minusMinutes(5).toString();
        Optional<AnomalyInfo> anomalyInfo = anomalyDetector.detectAnomaly(buildEvent(Action.DELETION.value, fiveMinutesAgo));
        assertFalse(anomalyInfo.isPresent());
    }

    @Test
    public void detectAnomaly_shouldDetectWhenDeletedWithinTime_differentTimeZone() {
        ZoneId differentZone = ZoneId.of("America/New_York");
        ZonedDateTime fourMinutesAgoNewYork = ZonedDateTime.now(differentZone).minusMinutes(4);
        Optional<AnomalyInfo> anomalyInfo = anomalyDetector.detectAnomaly(buildEvent(Action.DELETION.value, fourMinutesAgoNewYork.toString()));
        assertTrue(anomalyInfo.isPresent());
    }

    @Test
    public void detectAnomaly_shouldNotDetectWhenCreatedWithinTime() {
        String fourMinutesAgo = ZonedDateTime.now().minusMinutes(4).toString();
        Optional<AnomalyInfo> anomalyInfo = anomalyDetector.detectAnomaly(buildEvent(Action.CREATION.value, fourMinutesAgo));
        assertFalse(anomalyInfo.isPresent());
    }

    public RepositoryGitHubEvent buildEvent(String action, String creationTime) {
        RepositoryGitHubEvent event = new RepositoryGitHubEvent();
        event.setAction(action);
        event.setRepository(buildRepository(creationTime));

        return event;
    }

    private RepositoryData buildRepository(String creationTime) {
        RepositoryData repository = new RepositoryData();
        repository.setCreated_at(creationTime);

        return repository;
    }
}
