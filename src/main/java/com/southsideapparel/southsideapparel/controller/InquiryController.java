package com.southsideapparel.southsideapparel.controller;

import com.southsideapparel.southsideapparel.model.Inquiry;
import com.southsideapparel.southsideapparel.service.InquiryService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/inquiries")
@CrossOrigin(origins = "http://localhost:3000")
public class InquiryController {

    private final InquiryService service;

    public InquiryController(InquiryService service) {
        this.service = service;
    }

    @GetMapping
    public List<Inquiry> all() {
        return service.getAll();
    }

    @GetMapping("/unreplied")
    public List<Inquiry> unreplied() {
        return service.getUnreplied();
    }

    @GetMapping("/{id}")
    public Inquiry get(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Inquiry create(@RequestBody Inquiry inquiry) {
        return service.create(inquiry);
    }

    @PutMapping("/{id}/reply")
    public Inquiry reply(@PathVariable Long id, @RequestBody String response) {
        return service.reply(id, response);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
