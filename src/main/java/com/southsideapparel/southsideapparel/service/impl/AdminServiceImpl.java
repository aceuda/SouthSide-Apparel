package com.southsideapparel.southsideapparel.service.impl;

import com.southsideapparel.southsideapparel.model.Admin;
import com.southsideapparel.southsideapparel.repository.AdminRepository;
import com.southsideapparel.southsideapparel.service.AdminService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository repo;

    public AdminServiceImpl(AdminRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Admin> getAll() {
        return repo.findAll();
    }

    @Override
    public Admin getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Admin not found"));
    }

    @Override
    public Admin create(Admin admin) {
        return repo.save(admin);
    }

    @Override
    public Admin update(Long id, Admin admin) {
        Admin existing = getById(id);
        existing.setName(admin.getName());
        existing.setEmail(admin.getEmail());
        existing.setPasswordHash(admin.getPasswordHash());
        existing.setRole(admin.getRole());
        return repo.save(existing);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
