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
    initConfig()
    runTests(g_contexts, g_tests, g_actionNames, ::getUser)
}

/*-------------------------------------------------------------------------*/
