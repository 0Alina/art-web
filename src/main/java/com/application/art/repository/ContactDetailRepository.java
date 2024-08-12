package com.application.art.repository;

import com.application.art.entity.ContactDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactDetailRepository extends JpaRepository<ContactDetail, Integer> {
}
