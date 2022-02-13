package com.example.common.domain

interface Mapper<I, O> {

    fun to(input: I): O

    fun from(output: O): I
}