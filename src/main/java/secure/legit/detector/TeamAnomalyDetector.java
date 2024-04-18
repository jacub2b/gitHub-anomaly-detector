package secure.legit.detector;

import org.springframework.stereotype.Service;
import secure.legit.data.Action;
import secure.legit.data.AnomalyInfo;
import secure.legit.data.TeamGitHubEvent;

import java.util.Collections;
import java.util.Optional;

@Service
public class TeamAnomalyDetector implements AnomalyDetector<TeamGitHubEvent> {
    private static String PROHIBITED_PREFIX = "hacker";

    @Override
    public Optional<AnomalyInfo> detectAnomaly(TeamGitHubEvent eventData) {
        if(eventData.getAction().equals(Action.CREATION.value) && isProhibitedPrefixInName(eventData)) {
            AnomalyInfo anomalyInfo = new AnomalyInfo(anomalyDescription(), Collections.singletonList(eventData));

            return Optional.of(anomalyInfo);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public String anomalyDescription() {
        return "suspicious team has been created with " + PROHIBITED_PREFIX + " prefix!";
    }

    private boolean isProhibitedPrefixInName(TeamGitHubEvent eventData) {
        String newTeamName = eventData.getTeam().getName();

        return newTeamName.toLowerCase().startsWith(PROHIBITED_PREFIX);
    }
}
