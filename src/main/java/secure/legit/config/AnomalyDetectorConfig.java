package secure.legit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import secure.legit.detector.AnomalyDetector;
import secure.legit.detector.RepositoryAnomalyDetect;
import secure.legit.detector.RepositoryAnomalyDetector;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class AnomalyDetectorConfig {

//    todo: make generic

    @Bean
    public Map<String, AnomalyDetector<?>> buildEventToAnomalyDetectorMap() {
        RepositoryAnomalyDetect detect = new RepositoryAnomalyDetect();
        Map<String, AnomalyDetector<?>> map = new HashMap<>();
        map.put("repository", new RepositoryAnomalyDetect());
    }
}
