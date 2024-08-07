package com.application.art.repository;

import com.application.art.entity.ContactDetail;
import org.springframework.data.repository.CrudRepository;

public interface ContactDetailRepository extends CrudRepository<ContactDetail, Integer> {
}
