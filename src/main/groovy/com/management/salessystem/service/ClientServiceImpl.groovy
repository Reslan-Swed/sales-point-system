package com.management.salessystem.service

import com.management.salessystem.domain.Client
import com.management.salessystem.repository.ClientRepository
import org.springframework.stereotype.Service
import org.springframework.util.Assert

@Service
class ClientServiceImpl implements ClientService {
    private ClientRepository clientRepository

    ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository
    }

    @Override
    Client createNewClient(Client client) {
        clientRepository.save(client)
    }

    @Override
    Client updateExistClient(Long id, Client replacementClient) {
        Assert.notNull(id, "Client's id must be specified")
        Assert.notNull(clientRepository.findById(id).orElse(null), "Specified client with id of $id not found")
        final newClient = new Client(id: id, name: replacementClient.name, lastName: replacementClient.lastName, mobile: replacementClient.mobile)
        clientRepository.save(newClient)
    }

    @Override
    List<Client> getAllClients() {
        clientRepository.findAll().toList()
    }
}
