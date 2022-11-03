package com.sb.entrancecounting.repository;

import com.sb.entrancecounting.domain.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {
}
