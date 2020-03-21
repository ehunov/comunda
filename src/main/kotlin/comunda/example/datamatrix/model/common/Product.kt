package comunda.example.datamatrix.model.common

import java.io.Serializable

data class Product(
    var description: String? = null,
    var cost: Int? = null,
    var tax: Int? = null,
    var dataMatrix: DataMatrix? = null
): Serializable
