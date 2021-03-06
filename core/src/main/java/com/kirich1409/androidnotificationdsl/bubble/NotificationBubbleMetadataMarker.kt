package com.kirich1409.androidnotificationdsl.bubble

import androidx.annotation.RestrictTo

/**
 * @see BubbleMetadataBuilder
 */
@DslMarker
@Target(AnnotationTarget.CLASS)
@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
internal annotation class NotificationBubbleMetadataMarker
