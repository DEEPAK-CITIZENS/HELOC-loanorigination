package me.anichakra.poc.pilot.heloc.dashboard.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.anichakra.poc.pilot.heloc.dashboard.domain.DashboardMetric;

@Repository
public interface DashboardMetricRepository extends JpaRepository<DashboardMetric, Long> {

	List<DashboardMetric> findByPeriod(String period);

	List<DashboardMetric> findByMetricName(String metricName);
}
