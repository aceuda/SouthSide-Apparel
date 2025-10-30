package com.southsideapparel.southsideapparel.repository;

import com.southsideapparel.southsideapparel.model.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface InquiryRepository extends JpaRepository<Inquiry, Long> {
    List<Inquiry> findByRepliedFalse();
}
