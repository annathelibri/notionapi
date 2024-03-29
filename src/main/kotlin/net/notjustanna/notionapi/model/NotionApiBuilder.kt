package net.notjustanna.notionapi.model

import net.notjustanna.notionapi.NotionApi
import net.notjustanna.notionapi.impl.NotionApiImpl
import java.net.http.HttpClient

class NotionApiBuilder {
    var accessToken: String? = null
    var baseUrl: String = "https://api.notion.com/v1"
    var httpClient: HttpClient = HttpClient.newHttpClient()
    var notionVersion: String = "2021-05-13"

    internal fun build(): NotionApi {
        return NotionApiImpl(
            accessToken ?: throw IllegalArgumentException("Access Token not set."),
            baseUrl, httpClient, notionVersion
        )
    }
}
