package net.notjustanna.notionapi.model.richtext

interface Mention : RichText {
    /**
     * Type of the inline mention.
     */
    val mentionType: MentionType
}
