package comunda.example.datamatrix.model.common

import java.io.Serializable

class DataMatrix(
    val uit: String,
    var status: DataMatrixStatus? = null
): Serializable
