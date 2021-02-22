package com.management.salessystem.response

import groovy.transform.Canonical

@Canonical
class SuccessResponse {
    private Date timestamp = new Date()
    String message
}
