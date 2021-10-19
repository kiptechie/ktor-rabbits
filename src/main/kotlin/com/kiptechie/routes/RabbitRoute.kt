package com.kiptechie.routes

import com.kiptechie.data.models.Rabbit
import com.kiptechie.data.models.StandardResponse
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

private const val BASE_URL = "https://ktor-rabbits.herokuapp.com"

private val rabbits = getRabbits()

fun getRabbits(): List<Rabbit> {
    val rabbits = ArrayList<Rabbit>()
    for (i in 0..5) {
        val id = i + 1
        val name = "Rabbit $id"
        val description = "Just a fake description $id"
        val imageUrl = "$BASE_URL/rabbits/rabbit$id.jpg"
        rabbits.add(Rabbit(id, name, description, imageUrl))
    }
    return rabbits
}

fun Route.randomRabbit() {
    get("/") {
        call.respondText("HELLO RABBITS!", contentType = ContentType.Text.Plain)
    }
    get("/rabbit:random") {
        call.respond(
            HttpStatusCode.OK,
            StandardResponse(
                true,
                "List of random rabbits",
                rabbit = rabbits.random()
            )
        )
    }
    get("/rabbits") {
        call.respond(
            HttpStatusCode.OK,
            StandardResponse(
                true,
                "List of all rabbits",
                rabbits = rabbits
            )
        )
    }
    get("/rabbit:find") {
        val id = call.parameters["id"]?.toInt()
        val position = id?.minus(1)
        if (position != null && position <= 5) {
            call.respond(
                HttpStatusCode.OK,
                StandardResponse(
                    true,
                    "List of the rabbit with id:$id",
                    rabbit = rabbits[position]
                )
            )
        } else {
            call.respond(
                HttpStatusCode.OK,
                StandardResponse(
                    false,
                    "ID:$id does not exist!"
                )
            )
        }
    }
}