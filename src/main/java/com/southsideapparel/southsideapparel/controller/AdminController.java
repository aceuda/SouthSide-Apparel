package com.southsideapparel.southsideapparel.controller;

import com.southsideapparel.southsideapparel.model.Admin;
import com.southsideapparel.southsideapparel.service.AdminService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/admins")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {

    private final AdminService service;

    public AdminController(AdminService service) {
        this.service = service;
    }

    @GetMapping
    public List<Admin> all() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Admin get(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Admin create(@RequestBody Admin admin) {
        return service.create(admin);
    }

    @PutMapping("/{id}")
    public Admin update(@PathVariable Long id, @RequestBody Admin admin) {
        return service.update(id, admin);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
