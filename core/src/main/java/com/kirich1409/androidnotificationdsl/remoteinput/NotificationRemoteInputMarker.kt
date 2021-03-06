package com.kirich1409.androidnotificationdsl.remoteinput

import androidx.annotation.RestrictTo

/**
 * @see RemoteInputBuilder
 */
@DslMarker
@Target(AnnotationTarget.CLASS)
@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
internal annotation class NotificationRemoteInputMarker
