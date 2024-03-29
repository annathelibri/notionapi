package net.notjustanna.notionapi.model.property

import net.notjustanna.notionapi.utils.JsonEnum
import net.notjustanna.notionapi.utils.lowercaseOfName

enum class PropertyType : JsonEnum {
    TITLE, RICH_TEXT, NUMBER, SELECT, MULTI_SELECT, DATE, PEOPLE, FILES, CHECKBOX, URL, EMAIL, PHONE_NUMBER, FORMULA,
    RELATION, ROLLUP, CREATED_TIME, CREATED_BY, LAST_EDITED_TIME, LAST_EDITED_BY;

    override val value by lowercaseOfName()

    companion object : JsonEnum.Companion<PropertyType>(::values)
}
