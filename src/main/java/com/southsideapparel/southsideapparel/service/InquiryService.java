package com.southsideapparel.southsideapparel.service;

import com.southsideapparel.southsideapparel.model.Inquiry;
import java.util.List;

public interface InquiryService {
    List<Inquiry> getAll();

    List<Inquiry> getUnreplied();

    Inquiry getById(Long id);

    Inquiry create(Inquiry inquiry);

    Inquiry reply(Long id, String response);

    void delete(Long id);
}
