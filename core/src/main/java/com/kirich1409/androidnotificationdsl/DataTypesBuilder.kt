@file:Suppress("unused", "NOTHING_TO_INLINE")

package com.kirich1409.androidnotificationdsl

import androidx.core.app.RemoteInput


/**
 * Data types builder
 */
class DataTypesBuilder @PublishedApi internal constructor(
    private val remoteInput: RemoteInput.Builder
) : Container<String> {

    /**
     * Specifies whether the user can provide arbitrary values.
     *
     * @param mimeType A mime type that results are allowed to come in.
     *        Be aware that text results (see [RemoteInputs.allowFreeFormInput])
     *        are allowed by default. If you do not want text results you will have to call [disallow]
     *
     * @see disallow
     */
    fun allow(mimeType: String) {
        remoteInput.setAllowDataType(mimeType, true)
    }

    /**
     * Specifies whether the user can provide arbitrary values.
     *
     * @param mimeType A mime type that results are disallowed to come in.
     *         Be aware that text results (see [RemoteInputs.allowFreeFormInput])
     *         are allowed by default. If you want text results you will have to call [allow]
     *
     * @see allow
     */
    fun disallow(mimeType: String) {
        remoteInput.setAllowDataType(mimeType, false)
    }

    override fun plusAssign(item: String) {
        allow(item)
    }
}

/**
 * Specifies whether the user can provide arbitrary values.
 *
 * @param mimeTypes A mime types that results are disallowed to come in.
 *         Be aware that text results (see [RemoteInputs.allowFreeFormInput])
 *         are allowed by default. If you want text results you will have to call [allow]
 *
 * @see allow
 */
inline fun DataTypesBuilder.allow(vararg mimeTypes: String) {
    mimeTypes.forEach(::allow)
}

/**
 * Specifies whether the user can provide arbitrary values.
 *
 * @param mimeTypes A mime types that results are disallowed to come in.
 *         Be aware that text results (see [RemoteInputs.allowFreeFormInput])
 *         are allowed by default. If you want text results you will have to call [allow]
 *
 * @see allow
 */
inline fun DataTypesBuilder.disallow(vararg mimeTypes: String) {
    mimeTypes.forEach(::disallow)
}

/**
 * Specifies whether the user can provide arbitrary values.
 *
 * @param mimeTypes A mime types that results are disallowed to come in.
 *         Be aware that text results (see [RemoteInputs.allowFreeFormInput])
 *         are allowed by default. If you want text results you will have to call [allow]
 *
 * @see allow
 */
inline fun DataTypesBuilder.allow(mimeTypes: Iterable<String>) {
    mimeTypes.forEach(::allow)
}

/**
 * Specifies whether the user can provide arbitrary values.
 *
 * @param mimeTypes A mime types that results are disallowed to come in.
 *         Be aware that text results (see [RemoteInputs.allowFreeFormInput])
 *         are allowed by default. If you want text results you will have to call [allow]
 *
 * @see allow
 */
inline fun DataTypesBuilder.disallow(mimeTypes: Iterable<String>) {
    mimeTypes.forEach(::disallow)
}

/**
 * Specifies whether the user can provide arbitrary values.
 *
 * @param mimeType A mime type that results are disallowed to come in.
 *         Be aware that text results (see [RemoteInputs.allowFreeFormInput])
 *         are allowed by default. If you want text results you will have to call [allow]
 *
 * @see allow
 */
inline operator fun DataTypesBuilder.minus(mimeType: String) {
    disallow(mimeType)
}
