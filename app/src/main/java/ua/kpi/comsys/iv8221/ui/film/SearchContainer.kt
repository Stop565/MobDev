package ua.kpi.comsys.iv8221.ui.film

import com.fasterxml.jackson.annotation.JsonProperty

class SearchContainer {
    @JsonProperty("Search")
    var search: MutableList<Search> = ArrayList()
}

