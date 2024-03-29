package net.notjustanna.notionapi.model.database

import net.notjustanna.notionapi.model.NotionObject
import net.notjustanna.notionapi.model.database.property.DatabaseProperty
import net.notjustanna.notionapi.model.richtext.RichText
import java.time.OffsetDateTime

/**
 * Database objects describe the property schema of a database in Notion.
 * Pages are the items (or children) in a database.
 * Page property values must conform to the property objects laid out in the parent database object.
 *
 * [Notion API Page about this entity](https://developers.notion.com/reference/database).
 */
interface Database : NotionObject {
    /**
     * Unique identifier for the database.
     */
    override val id: String

    /**
     * Date and time when this database was created.
     */
    override val createdTime: OffsetDateTime

    /**
     * Date and time when this database was updated.
     */
    override val lastEditedTime: OffsetDateTime

    /**
     * Name of the database as it appears in Notion.
     */
    val title: List<RichText>

    /**
     * Schema of properties for the database as they appear in Notion.
     * The key is the name of the property as it appears in Notion.
     */
    val properties: Map<String, DatabaseProperty>
}

