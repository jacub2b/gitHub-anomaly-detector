package secure.legit.detector;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import secure.legit.data.Action;
import secure.legit.data.AnomalyInfo;
import secure.legit.data.TeamGitHubEvent;

import java.util.Collections;
import java.util.Optional;

@Service
public class TeamAnomalyDetector implements AnomalyDetector {
    private static final String PROHIBITED_PREFIX = "hacker";

    private Gson gson;

    @Autowired
    public TeamAnomalyDetector(Gson gson) {
        this.gson = gson;
    }

    @Override
    public Optional<AnomalyInfo> detectAnomaly(String eventPayload) {
        TeamGitHubEvent eventData = gson.fromJson(eventPayload, TeamGitHubEvent.class);
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

    @Override
    public String eventName() {
        return "team";
//        todo
    }

    private boolean isProhibitedPrefixInName(TeamGitHubEvent eventData) {
        String newTeamName = eventData.getTeam().getName();

        return newTeamName.toLowerCase().startsWith(PROHIBITED_PREFIX);
    }
}
