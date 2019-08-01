package com.example.testapp.mapping

import com.example.testapp.repository.model.Plan

fun Plan.toDomainModel(): com.example.testapp.domain.model.Plan =
        com.example.testapp.domain.model.Plan("$firstName $lastName", email)