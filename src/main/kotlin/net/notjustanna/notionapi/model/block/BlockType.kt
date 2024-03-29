package net.notjustanna.notionapi.model.block

import net.notjustanna.notionapi.utils.JsonEnum
import net.notjustanna.notionapi.utils.lowercaseOfName

enum class BlockType : JsonEnum {
    PARAGRAPH, HEADING_1, HEADING_2, HEADING_3, BULLETED_LIST_ITEM,
    NUMBERED_LIST_ITEM, TO_DO, TOGGLE, CHILD_PAGE, UNSUPPORTED;

    override val value: String by lowercaseOfName()

    companion object : JsonEnum.Companion<BlockType>(::values, { UNSUPPORTED })
}
