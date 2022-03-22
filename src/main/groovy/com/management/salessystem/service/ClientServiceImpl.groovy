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
    Client createNewClient(CreateClientRequest request) {
        new Client(name: request.name, lastName: request.lastName, mobile: request.mobile).with {
            clientRepository.save(it)
        }
    }

    @Override
    Client updateExistClient(Client client, UpdateClientRequest request) {
        client.tap {
            name = request.name ?: name
            lastName = request.lastName ?: lastName
            mobile = request.mobile ?: mobile
        }
        clientRepository.save(client)
    }

    @Override
    List<Client> getAllClients() {
        clientRepository.findAll().toList()
    }
}
