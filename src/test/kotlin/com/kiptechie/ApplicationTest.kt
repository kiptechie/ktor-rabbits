package com.kiptechie

import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.serialization.*
import io.ktor.features.*
import org.slf4j.event.*
import io.ktor.content.*
import io.ktor.http.content.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import kotlin.test.*
import io.ktor.server.testing.*
import com.kiptechie.plugins.*

class ApplicationTest {
    @Test
    fun `root route works`() {
        withTestApplication({
            configureRouting()
            configureSerialization()
            configureMonitoring()
        }) {
            handleRequest(HttpMethod.Get, "/").apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals("HELLO RABBITS!", response.content)
            }
        }
    }

    @Test
    fun `random rabbit endpoint returns a random rabbit`() {
        withTestApplication({
            configureRouting()
            configureSerialization()
            configureMonitoring()
        }) {
            handleRequest(HttpMethod.Get, "/rabbit:random").apply {
                assertEquals(HttpStatusCode.OK, response.status())
                val successResponseMessage = "A random rabbit"
                assertEquals(response.content?.contains(successResponseMessage) ?: false, true)
            }
        }
    }

    @Test
    fun `rabbits endpoint returns a list of rabbits`() {
        withTestApplication({
            configureRouting()
            configureSerialization()
            configureMonitoring()
        }) {
            handleRequest(HttpMethod.Get, "/rabbits").apply {
                assertEquals(HttpStatusCode.OK, response.status())
                val successResponseMessage = "List of all rabbits"
                assertEquals(response.content?.contains(successResponseMessage) ?: false, true)
            }
        }
    }

    @Test
    fun `rabbits count endpoint returns the total number of rabbits`() {
        withTestApplication({
            configureRouting()
            configureSerialization()
            configureMonitoring()
        }) {
            handleRequest(HttpMethod.Get, "/rabbits:count").apply {
                assertEquals(HttpStatusCode.OK, response.status())
                val successResponseMessage = "Total number of rabbits"
                assertEquals(response.content?.contains(successResponseMessage) ?: false, true)
            }
        }
    }

    @Test
    fun `rabbit find endpoint finds a rabbit with the given id`() {
        withTestApplication({
            configureRouting()
            configureSerialization()
            configureMonitoring()
        }) {
            handleRequest(HttpMethod.Get, "/rabbit:find?id=2").apply {
                assertEquals(HttpStatusCode.OK, response.status())
                val successResponseMessage = "Rabbit with id:2"
                assertEquals(response.content?.contains(successResponseMessage) ?: false, true)
            }
        }
    }

    @Test
    fun `rabbit find endpoint returns false when the given id does not exist`() {
        withTestApplication({
            configureRouting()
            configureSerialization()
            configureMonitoring()
        }) {
            handleRequest(HttpMethod.Get, "/rabbit:find?id=200").apply {
                assertEquals(HttpStatusCode.OK, response.status())
                val successResponseMessage = "ID:200 does not exist!"
                assertEquals(response.content?.contains(successResponseMessage) ?: false, true)
            }
        }
    }
}