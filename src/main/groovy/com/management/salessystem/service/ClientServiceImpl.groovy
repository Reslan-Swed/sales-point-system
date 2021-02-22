package com.management.salessystem.service

import com.management.salessystem.domain.Client
import com.management.salessystem.repository.ClientRepository
import com.management.salessystem.request.CreateClientRequest
import com.management.salessystem.request.UpdateClientRequest
import org.springframework.stereotype.Service
import org.springframework.util.Assert

@Service
class ClientServiceImpl implements ClientService {
    private ClientRepository clientRepository

    ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository
    }

    @Override
    void createNewClient(CreateClientRequest request) {
        final client = new Client(name: request.name, lastName: request.lastName, mobile: request.mobile)
        clientRepository.save(client)
    }

    @Override
    void updateExistClient(Long id, UpdateClientRequest request) {
        Assert.notNull(id, "Client's id must be specified")
        final oldClient = clientRepository.findById(id).orElse(null)
        Assert.notNull(oldClient, "Specified client with id of $id not found")
        final client = new Client(id: id, name: request.name ?: oldClient.name,
                lastName: request.lastName ?: oldClient.lastName, mobile: request.mobile ?: oldClient.mobile)
        clientRepository.save(client)
    }

    @Override
    List<Client> getAllClients() {
        clientRepository.findAll().toList()
    }
}
