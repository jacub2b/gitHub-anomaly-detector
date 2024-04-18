package secure.legit.controller;

import secure.legit.data.AnomalyInfo;
import secure.legit.handler.AnomalyHandler;

import java.util.Optional;

public abstract class GitHubEventHandler {
    protected AnomalyHandler anomalyHandler;

    public GitHubEventHandler(AnomalyHandler anomalyHandler) {
        this.anomalyHandler = anomalyHandler;
    }

    abstract String getEventDescription();

    protected void handleAnomaly(Optional<AnomalyInfo> anomalyInfo) {
        anomalyInfo.ifPresent(info -> anomalyHandler.handleAnomaly(info));
    }
}