package user.http

/*-------------------------------------------------------------------------*/

import org.tulip.core.Console
import org.tulip.core.delayMillisRandom
import org.tulip.api.TulipUser
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

/*-------------------------------------------------------------------------*/

private val client = HttpClient.newHttpClient()

private fun serviceCall(request:HttpRequest): Boolean {
    // https://www.baeldung.com/java-httpclient-connection-management

    val response = client.send(request, HttpResponse.BodyHandlers.ofString())

    //println(id)
    //println(name)
    //println(response.statusCode())
    //println(response.body())

    return (response.statusCode() == 200)
}

/*-------------------------------------------------------------------------*/

class HttpUser(userId: Int, threadId: Int) : TulipUser(userId, threadId) {

    // ----------------------------------------------------------------- //

    private val requestPosts = createRequest("posts")
    private val requestComments = createRequest("comments")
    private val requestAlbums = createRequest("albums")
    private val requestPhotos = createRequest("photos")
    private val requestTodos = createRequest("todos")

    override fun start(): Boolean {
        val actionId = 0
        Console.put("  $userId -> $actionId -> ${getActionName(actionId)} -> $threadId")
        return true
    }

    // ----------------------------------------------------------------- //

    // 0.25*6 + 0.75*14 = 12.0 ms

    override fun action1(): Boolean {
        // 6 ms delay (average)
        delayMillisRandom(0, 12)
        return true
    }

    override fun action2(): Boolean {
        // 14 ms delay (average)
        delayMillisRandom(0, 28)
        return true
    }

    // ----------------------------------------------------------------- //

    override fun action3(): Boolean {
        return serviceCall(requestPosts)
    }

    override fun action4(): Boolean {
        return serviceCall(requestComments)
    }

    override fun action5(): Boolean {
        return serviceCall(requestAlbums)
    }

    override fun action6(): Boolean {
        return serviceCall(requestPhotos)
    }

    override fun action7(): Boolean {
        return serviceCall(requestTodos)
    }

    // ----------------------------------------------------------------- //

    override fun action8(): Boolean {
        val actionId = 8
        Console.put("  $userId -> $actionId -> ${getActionName(actionId)} -> $threadId")
        return true
    }

    // ----------------------------------------------------------------- //

    override fun action9(): Boolean {
        return true
    }

    // ----------------------------------------------------------------- //

    override fun action10(): Boolean {
        Thread.sleep(10)
        return true
    }

    // ----------------------------------------------------------------- //

    override fun stop(): Boolean {
        Console.put("  Terminate: UserId = $userId")
        Thread.sleep(100)
        return true
    }

    // ----------------------------------------------------------------- //

    private fun createRequest(name: String): HttpRequest {
        val id = userId + 1
        val url: String = this.getUserParamValue("url")
        val request:HttpRequest = HttpRequest.newBuilder()
            .uri(URI("${url}/${name}/${id}"))
            .GET()
            .build()
        return request
    }

    // ----------------------------------------------------------------- //

//    companion object {
//        init {
//            //Console.put("Loading .... Kotlin class ... HttpUser")
//        }
//    }

    // ----------------------------------------------------------------- //

}

/*-------------------------------------------------------------------------*/