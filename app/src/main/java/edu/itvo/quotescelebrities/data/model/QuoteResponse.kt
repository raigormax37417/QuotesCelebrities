package edu.itvo.quotescelebrities.data.model

import com.google.gson.annotations.SerializedName
import edu.itvo.quotescelebrities.domain.model.QuoteModel


data class QuoteResponse(
    @SerializedName("success")
    var success: Boolean,

    @SerializedName("message")
    var message: String,

    @SerializedName("data")
    var data: List<QuoteModel?>?
)