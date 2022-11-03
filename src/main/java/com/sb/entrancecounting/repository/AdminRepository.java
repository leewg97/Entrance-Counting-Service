package com.sb.entrancecounting.repository;

import com.sb.entrancecounting.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
