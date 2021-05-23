package ua.kpi.comsys.iv8221.ui.film

import com.fasterxml.jackson.annotation.JsonProperty


class Search {
    @JsonProperty("Title")
    var title: String? = null

    @JsonProperty("Year")
    var year: String? = null

    @JsonProperty("imdbID")
    var imdbID: String? = null

    @JsonProperty("Type")
    var type: String? = null

    @JsonProperty("Poster")
    var poster: String? = null

    override fun toString(): String {
        return "$title"
    }
}

