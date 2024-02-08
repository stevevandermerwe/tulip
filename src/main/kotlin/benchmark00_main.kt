/*-------------------------------------------------------------------------*/

@file:JvmName("LoadTest1")

/*-------------------------------------------------------------------------*/

import tulip.User
import tulip.runTests

/*-------------------------------------------------------------------------*/

fun getUser(userId: Int): User {
    return UserHttp(userId)
}

/*-------------------------------------------------------------------------*/

fun main() {
    runTests(contexts, tests, actionNames, ::getUser)
}

/*-------------------------------------------------------------------------*/
