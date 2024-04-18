package secore.legit.detector;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import secure.legit.data.*;
import secure.legit.detector.TeamAnomalyDetector;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TeamAnomalyDetectorTest {
    private static TeamAnomalyDetector detector;

    @BeforeAll
    public static void setUp() {
        detector = new TeamAnomalyDetector();
    }

    @Test
    public void detectAnomaly_shouldDetectWhenHackerTeamCreated(){
        Optional<AnomalyInfo> anomalyInfo = detector.detectAnomaly(createTeamEvent(Action.CREATION.value, "hacker"));
        assertTrue(anomalyInfo.isPresent());
    }

    @Test
    public void detectAnomaly_shouldDetectWhenHackerTeamCreatedWithCapital(){
        Optional<AnomalyInfo> anomalyInfo = detector.detectAnomaly(createTeamEvent(Action.CREATION.value, "Hacker"));
        assertTrue(anomalyInfo.isPresent());
    }

    @Test
    public void detectAnomaly_shouldNotDetectWhenGoodTeamCreated(){
        Optional<AnomalyInfo> anomalyInfo = detector.detectAnomaly(createTeamEvent(Action.CREATION.value, "Legit team"));
        assertFalse(anomalyInfo.isPresent());
    }

    @Test
    public void detectAnomaly_shouldNotDetectWhenBadTeamDeleted(){
        Optional<AnomalyInfo> anomalyInfo = detector.detectAnomaly(createTeamEvent(Action.DELETION.value, "hacker4u"));
        assertFalse(anomalyInfo.isPresent());
    }

    private TeamGitHubEvent createTeamEvent(String action, String teamName) {
        TeamGitHubEvent event = new TeamGitHubEvent();
        event.setAction(action);
        event.setTeam(createTeam(teamName));

        return event;
    }

    private Team createTeam(String teamName) {
        Team team = new Team();
        team.setName(teamName);

        return team;
    }
}
