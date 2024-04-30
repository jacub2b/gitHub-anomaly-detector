package secure.legit.config;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import secure.legit.detector.AnomalyDetector;
import secure.legit.detector.RepositoryAnomalyDetector;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class AnomalyDetectorConfig {

//    todo: make generic

    @Bean
    public Map<String, AnomalyDetector> buildEventToAnomalyDetectorMap() {
        RepositoryAnomalyDetector detect = new RepositoryAnomalyDetector(new Gson());
        Map<String, AnomalyDetector> map = new HashMap<>();
        map.put("repository", detect);

        return map;
    }
}
