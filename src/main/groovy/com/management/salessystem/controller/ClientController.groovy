package com.management.salessystem.controller

import com.management.salessystem.domain.Client
import com.management.salessystem.request.CreateClientRequest
import com.management.salessystem.request.UpdateClientRequest
import com.management.salessystem.response.SuccessResponse
import com.management.salessystem.service.ClientService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

import javax.validation.Valid

@RestController
@RequestMapping("/clients")
class ClientController {
    private ClientService clientService

    ClientController(ClientService clientService) {
        this.clientService = clientService
    }

    @GetMapping
    List<Client> index() {
        clientService.getAllClients()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    SuccessResponse store(@Valid @RequestBody CreateClientRequest request) {
        clientService.createNewClient(request)
        new SuccessResponse(message: 'Client created successfully')
    }

    @PutMapping('/{id}')
    @ResponseStatus(HttpStatus.OK)
    SuccessResponse update(@PathVariable('id') Long id, @Valid @RequestBody UpdateClientRequest request) {
        clientService.updateExistClient(id, request)
        new SuccessResponse(message: 'Client updated successfully')
    }
}
