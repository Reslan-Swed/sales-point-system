package com.management.salessystem.service

import com.management.salessystem.domain.Client
import com.management.salessystem.request.CreateClientRequest
import com.management.salessystem.request.UpdateClientRequest

interface ClientService {
    void createNewClient(CreateClientRequest request)

    void updateExistClient(Long id, UpdateClientRequest request)

    List<Client> getAllClients()
}
