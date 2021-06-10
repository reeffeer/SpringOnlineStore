package my.project.armorer.s.shop.services;

import lombok.AllArgsConstructor;
import my.project.armorer.s.shop.entities.Role;
import my.project.armorer.s.shop.repositories.RoleRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role findRoleByName(String name) {
        return roleRepository.findByName(name);
    }
}
