package secure.legit.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import secure.legit.detector.AnomalyDetector;


import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
public class AnomalyDetectorConfig {
    private ApplicationContext context;

    @Autowired
    public AnomalyDetectorConfig(ApplicationContext context) {
        this.context = context;
    }

    @Bean
    @Qualifier("detectorMap")
    public Map<String, AnomalyDetector> buildEventToAnomalyDetectorMap() {
        Map<String, AnomalyDetector> anomalyDetectorBeans = context.getBeansOfType(AnomalyDetector.class);
        Map<String, AnomalyDetector> eventToAnomalyDetectorMap = anomalyDetectorBeans.values().stream()
                .collect(Collectors.toMap(AnomalyDetector::eventName, Function.identity()));

        return eventToAnomalyDetectorMap;
    }
}
