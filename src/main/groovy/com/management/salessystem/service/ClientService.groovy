package com.management.salessystem.service

import com.management.salessystem.domain.Client

interface ClientService {
    Client createNewClient(Client client)

    Client updateExistClient(Long id, Client replacementClient)

    List<Client> getAllClients()
}
