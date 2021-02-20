package com.management.salessystem.repository

import com.management.salessystem.domain.Client
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ClientRepository extends CrudRepository<Client, Long> {

}