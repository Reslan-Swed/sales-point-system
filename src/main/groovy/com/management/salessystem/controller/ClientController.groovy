package com.management.salessystem.controller

import com.management.salessystem.domain.Client
import com.management.salessystem.request.CreateClientRequest
import com.management.salessystem.request.UpdateClientRequest
import com.management.salessystem.response.SuccessResponse
import com.management.salessystem.service.ClientService
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

import javax.validation.Valid

@RestController
@RequestMapping("/clients")
@Validated
class ClientController {
    private ClientService clientService

    ClientController(ClientService clientService) {
        this.clientService = clientService
    }

    @GetMapping
    SuccessResponse index() {
        clientService.getAllClients().with {
            new SuccessResponse(data: it)
        }
    }

    @GetMapping('/{id}')
    SuccessResponse get(@PathVariable('id') Client client) {
        new SuccessResponse(data: client)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    SuccessResponse store(@Valid @RequestBody CreateClientRequest request) {
        clientService.createNewClient(request).with {
            new SuccessResponse(message: 'Client created successfully', data: it)
        }
    }

    @PutMapping('/{id}')
    SuccessResponse update(@PathVariable('id') Client client, @Valid @RequestBody UpdateClientRequest request) {
        clientService.updateExistClient(client, request).with {
            new SuccessResponse(message: 'Client updated successfully', data: it)
        }
    }
}
