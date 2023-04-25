package com.example.yash.transformer

interface Transformer<A,B> {
    fun transform(source:A):B
}