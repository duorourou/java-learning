package com.github.duorourou.snailpowder.adapter.api

interface ApiAdapter {
    def <R, P> R get(String url, P params)

    def <R, P, B> R post(String url, P params, B body)

    def <R, P, B> R put(String url, P params, B body)

    def <R, P> R delete(String url, P params)
}
