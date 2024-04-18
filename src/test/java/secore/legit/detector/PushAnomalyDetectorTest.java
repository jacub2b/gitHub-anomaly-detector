package secore.legit.detector;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import secure.legit.data.AnomalyInfo;
import secure.legit.data.Commit;
import secure.legit.data.PushGitHubEvent;
import secure.legit.data.RepositoryData;
import secure.legit.detector.PushAnomalyDetector;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PushAnomalyDetectorTest {
    private static PushAnomalyDetector anomalyDetector;

    @BeforeAll
    public static void setUp() {
        anomalyDetector = new PushAnomalyDetector();
    }

    @Test
    public void detectAnomaly_shouldReturnFalseWhenTimeIsNormalTime() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now().withHour(18);
        Optional<AnomalyInfo> anomalyInfo = anomalyDetector.detectAnomaly(buildEvent("2024-04-17T13:11:30+03:00", String.valueOf(zonedDateTime.toEpochSecond())));
        assertFalse(anomalyInfo.isPresent());
    }

    @Test
    public void detectAnomaly_shouldReturnTrueWhenTimeIsRestTime() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now().withHour(15);
        Optional<AnomalyInfo> anomalyInfo = anomalyDetector.detectAnomaly(buildEvent("2024-04-17T13:11:30+03:00", String.valueOf(zonedDateTime.toEpochSecond())));
        assertTrue(anomalyInfo.isPresent());
    }

    @Test
    public void detectAnomaly_shouldReturnFalseWhenTimeIsRestTimeButDifferentTimeZone() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now().withHour(15);
        Optional<AnomalyInfo> anomalyInfo = anomalyDetector.detectAnomaly(buildEvent("2024-04-17T13:11:30+00:00", String.valueOf(zonedDateTime.toEpochSecond())));
        assertFalse(anomalyInfo.isPresent());
    }

    @Test
    public void detectAnomaly_shouldReturnTrueWhenTimeIsRestTimeInDifferentTimeZone() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now().withHour(18);
        Optional<AnomalyInfo> anomalyInfo = anomalyDetector.detectAnomaly(buildEvent("2024-04-17T13:11:30+00:00", String.valueOf(zonedDateTime.toEpochSecond())));
        assertTrue(anomalyInfo.isPresent());
    }

    private PushGitHubEvent buildEvent(String timeZonedField, String pushedEpoch) {
        PushGitHubEvent event = new PushGitHubEvent();
        event.setHead_commit(buildHeadCommit(timeZonedField));
        event.setRepository(createRepository(pushedEpoch));

        return event;
    }

    private RepositoryData createRepository(String pushedEpoch) {
        RepositoryData repositoryData = new RepositoryData();
        repositoryData.setPushed_at(pushedEpoch);

        return repositoryData;
    }

    private Commit buildHeadCommit(String timeZonedField) {
        Commit commit = new Commit();
        commit.setTimestamp(timeZonedField);

        return commit;
    }
}
