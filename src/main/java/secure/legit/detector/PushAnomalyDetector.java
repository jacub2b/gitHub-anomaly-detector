package secure.legit.detector;

import org.springframework.stereotype.Service;
import secure.legit.data.AnomalyInfo;
import secure.legit.data.PushGitHubEvent;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.Optional;

@Service
public class PushAnomalyDetector implements AnomalyDetector<PushGitHubEvent>{
    private static final int PUSH_BOUNDARY_FLOOR = 14;
    private static final int PUSH_BOUNDARY_CEILING = 16;


    @Override
    public Optional<AnomalyInfo> detectAnomaly(PushGitHubEvent eventData) {
        ZonedDateTime dateTime = ZonedDateTime.parse(eventData.getHead_commit().getTimestamp());
        ZoneId userZoneId = dateTime.getZone();
        String pushedEpochSeconds = eventData.getRepository().getPushed_at();
        Instant instant = Instant.ofEpochSecond(Long.parseLong(pushedEpochSeconds));
        ZonedDateTime pushTime = ZonedDateTime.ofInstant(instant, userZoneId);

        ZonedDateTime boundaryFloor = pushTime.withHour(PUSH_BOUNDARY_FLOOR).withMinute(0).withSecond(0).withNano(0);
        ZonedDateTime boundaryCeiling = pushTime.withHour(PUSH_BOUNDARY_CEILING).withMinute(0).withSecond(0).withNano(0) ;

        if (pushTime.isAfter(boundaryFloor) && pushTime.isBefore(boundaryCeiling)) {
            AnomalyInfo anomalyInfo = new AnomalyInfo(anomalyDescription(), Collections.singletonList(eventData));

            return Optional.of(anomalyInfo);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public String anomalyDescription() {
        return "pushes have been done in uncommon hours!";
    }
}