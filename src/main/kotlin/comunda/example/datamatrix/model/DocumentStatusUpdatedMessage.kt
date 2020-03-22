package comunda.example.datamatrix.model

import comunda.example.datamatrix.model.common.DocumentStatus
import java.io.Serializable

class DocumentStatusUpdatedMessage(
    val uniqueKey: String,
    val status: DocumentStatus
): Serializable