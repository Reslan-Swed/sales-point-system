package com.management.salessystem.response

import groovy.transform.Canonical

@Canonical
class ErrorResponse {
    Date timestamp = new Date()
    List<String> cause
    String path
}
