package comunda.example.datamatrix.model

import comunda.example.datamatrix.model.common.DataMatrixStatus
import java.io.Serializable

class DataMatrixInformationUpdatedMessage(
    val uit: String,
    val status: DataMatrixStatus
): Serializable