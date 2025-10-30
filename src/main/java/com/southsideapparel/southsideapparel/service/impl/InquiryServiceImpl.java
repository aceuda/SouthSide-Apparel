package com.southsideapparel.southsideapparel.service.impl;

import com.southsideapparel.southsideapparel.model.Inquiry;
import com.southsideapparel.southsideapparel.repository.InquiryRepository;
import com.southsideapparel.southsideapparel.service.InquiryService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InquiryServiceImpl implements InquiryService {

    private final InquiryRepository repo;

    public InquiryServiceImpl(InquiryRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Inquiry> getAll() {
        return repo.findAll();
    }

    @Override
    public List<Inquiry> getUnreplied() {
        return repo.findByRepliedFalse();
    }

    @Override
    public Inquiry getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Inquiry not found"));
    }

    @Override
    public Inquiry create(Inquiry inquiry) {
        return repo.save(inquiry);
    }

    @Override
    public Inquiry reply(Long id, String response) {
        Inquiry i = getById(id);
        i.setReplied(true);
        // you can add email-sending logic here using JavaMailSender
        return repo.save(i);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
