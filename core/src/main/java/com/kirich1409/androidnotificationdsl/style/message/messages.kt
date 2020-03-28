@file:Suppress("unused", "NOTHING_TO_INLINE", "MemberVisibilityCanBePrivate")

package com.kirich1409.androidnotificationdsl.style.message

import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.Person
import java.time.Instant
import java.util.*
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

@NotificationMessagesMarker
class Messages @PublishedApi internal constructor(
    @PublishedApi internal val style: NotificationCompat.MessagingStyle
) {

    /**
     * Adds a message for display by this notification
     */
    fun message(text: CharSequence, timestamp: Long, person: Person) {
        style.addMessage(NotificationCompat.MessagingStyle.Message(text, timestamp, person))
    }

    /**
     * Adds a message for display by this notification
     */
    fun message(text: CharSequence, timestamp: Long, person: Person, dataMimeType: String, dataUri: Uri) {
        style.addMessage(
            NotificationCompat.MessagingStyle.Message(text, timestamp, person).apply {
                setData(dataMimeType, dataUri)
            }
        )
    }

    /**
     * Adds a message for display by this notification
     */
    fun message(message: NotificationCompat.MessagingStyle.Message) {
        style.addMessage(message)
    }
}

/**
 * Adds a message for display by this notification
 */
@ExperimentalTime
inline fun Messages.message(text: CharSequence, timestamp: Duration, person: Person) {
    message(text, timestamp.toLongMilliseconds(), person)
}

/**
 * Adds a message for display by this notification
 */
@ExperimentalTime
inline fun Messages.message(
    text: CharSequence,
    timestamp: Duration,
    person: Person,
    dataMimeType: String,
    dataUri: Uri
) {
    message(text, timestamp.toLongMilliseconds(), person, dataMimeType, dataUri)
}

/**
 * Adds a message for display by this notification
 */
inline fun Messages.message(text: CharSequence, timestamp: Date, person: Person) {
    message(text, timestamp.time, person)
}

/**
 * Adds a message for display by this notification
 */
inline fun Messages.message(text: CharSequence, timestamp: Date, person: Person, dataMimeType: String, dataUri: Uri) {
    message(text, timestamp.time, person, dataMimeType, dataUri)
}

/**
 * Adds a message for display by this notification
 */
@RequiresApi(Build.VERSION_CODES.O)
inline fun Messages.message(text: CharSequence, timestamp: Instant, person: Person) {
    message(text, timestamp.toEpochMilli(), person)
}

/**
 * Adds a message for display by this notification
 */
@RequiresApi(Build.VERSION_CODES.O)
inline fun Messages.message(
    text: CharSequence,
    timestamp: Instant,
    person: Person,
    dataMimeType: String,
    dataUri: Uri
) {
    message(text, timestamp.toEpochMilli(), person, dataMimeType, dataUri)
}