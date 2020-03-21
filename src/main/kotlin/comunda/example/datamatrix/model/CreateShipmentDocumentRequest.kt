package comunda.example.datamatrix.model

import comunda.example.datamatrix.model.common.Product

data class CreateShipmentDocumentRequest(
        val products: ArrayList<Product>
)
