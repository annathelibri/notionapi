package net.notjustanna.notionapi.net.request.richtext

import net.notjustanna.notionapi.net.request.annotation.NotionDsl
import net.notjustanna.notionapi.utils.buildJsonObject
import net.notjustanna.notionapi.utils.jsonObjectOf

@NotionDsl
class TextBuilder : RichTextBuilder() {
    /**
     * Text content.
     * This field contains the actual content of your text and is probably the field you'll use most often.
     */
    var contentBuilder = StringBuilder()

    operator fun String.unaryPlus() {
        contentBuilder.append(this)
    }

    /**
     * Any inline link in this text.
     */
    var linkUrl: String? = null

    override fun toJson() = super.toJson().apply {
        put("type", "text")
        this["text"] = buildJsonObject {
            put("content", contentBuilder.toString())
            linkUrl?.let { put("link", jsonObjectOf("url" to it)) }
        }
    }
}
