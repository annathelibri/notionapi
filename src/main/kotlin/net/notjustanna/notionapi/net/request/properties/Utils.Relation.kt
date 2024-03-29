package net.notjustanna.notionapi.net.request.properties

import net.notjustanna.notionapi.model.database.property.DatabaseProperty
import net.notjustanna.notionapi.model.page.Page
import net.notjustanna.notionapi.model.property.PropertyType

operator fun PropertiesBuilder.set(property: DatabaseProperty, value: Page) {
    set(property.id, property.type, value)
}

operator fun PropertiesBuilder.set(property: String, value: Page) {
    relation(property, value)
}

operator fun PropertiesBuilder.set(property: String, type: PropertyType, value: Page) {
    require(type == PropertyType.RELATION) { "Value only allowed for RELATION properties" }
    relation(property, value)
}

operator fun PropertiesBuilder.set(property: DatabaseProperty, value: List<Page>) {
    set(property.id, property.type, value)
}

operator fun PropertiesBuilder.set(property: String, value: List<Page>) {
    relation(property, value)
}

operator fun PropertiesBuilder.set(property: String, type: PropertyType, value: List<Page>) {
    require(type == PropertyType.RELATION) { "Value only allowed for RELATION properties" }
    relation(property, value)
}
