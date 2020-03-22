package comunda.example.datamatrix.model

import comunda.example.datamatrix.model.common.Product
import java.io.Serializable

data class ShipmentDocumentRequest(
    val sourceSystem: String,
    val number: String,
    val products: ArrayList<Product>
): Serializable
