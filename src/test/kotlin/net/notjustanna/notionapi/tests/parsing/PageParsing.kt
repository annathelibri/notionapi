package net.notjustanna.notionapi.tests.parsing

import net.notjustanna.notionapi.impl.model.PageImpl
import net.notjustanna.notionapi.model.page.PageParent
import net.notjustanna.notionapi.model.property.PropertyType
import net.notjustanna.notionapi.model.property.RichTextValue
import net.notjustanna.notionapi.model.richtext.Text
import net.notjustanna.notionapi.tests.base.ModelTests
import net.notjustanna.notionapi.tests.base.assertNotionObject
import net.notjustanna.notionapi.tests.base.assertPlainText
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PageParsing {
    @Test
    fun `parse page 1`() {
        val page = PageImpl.fromResponse(Page1.json)

        assertNotionObject(Page1, page)
        assertFalse(page.archived)
        assertEquals(PageParent.Page(Page1.parentId), page.parent)
        assertEquals(setOf("title"), page.properties.keys)

        val title = page.properties["title"] ?: fail("Title is null")
        assertEquals("title", title.id)
        assertEquals("title", title.name)

        val value = title.value as? RichTextValue ?: fail("Value is not RichText")
        assertEquals(PropertyType.TITLE, value.type)

        val text = value.value.single() as? Text ?: fail("Title's rich text is not Text.")
        assertPlainText(Page1.title, text)
    }

    private companion object : ModelTests() {
        object Page1 : Snippet("/input/page/unit/1.json"), NotionObjectDeclaration {
            override val id = "b58db8ca-35a4-40c2-83f7-e53ee672f3bf"
            override val createdTime = "2021-06-25T00:19:00.000Z"
            override val lastEditedTime = "2021-06-25T00:39:00.000Z"
            const val parentId = "ba62fc19-01e4-425d-bcf7-2545050e6b36"
            const val title = "Example Page"
        }
    }
}
