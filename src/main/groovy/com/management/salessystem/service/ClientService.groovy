package com.management.salessystem.service

import com.management.salessystem.domain.Client
import com.management.salessystem.request.CreateClientRequest
import com.management.salessystem.request.UpdateClientRequest

interface ClientService {
    Client createNewClient(CreateClientRequest request)

    Client updateExistClient(Client client, UpdateClientRequest request)

    List<Client> getAllClients()
}
