package uz.kpi.motors.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import uz.kpi.motors.models.Metrics;
import uz.kpi.motors.models.Periods;
import uz.kpi.motors.repositories.MetricsRepository;

import java.util.List;

@Service
@Transactional
public class MetricsService {
    private final MetricsRepository metricsRepository;

    public MetricsService(MetricsRepository metricsRepository) {
        this.metricsRepository = metricsRepository;
    }


    public List<Metrics> findAll(){
        return metricsRepository.findAll();
    }

}
