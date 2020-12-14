package com.api.crud01.repositories;

import com.api.crud01.entities.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
