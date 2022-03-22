package com.management.salessystem.repository

import com.management.salessystem.domain.Client
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClientRepository extends JpaRepository<Client, Long> {
}