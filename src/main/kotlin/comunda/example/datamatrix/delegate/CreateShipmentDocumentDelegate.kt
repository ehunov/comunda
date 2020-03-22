package comunda.example.datamatrix.delegate

import comunda.example.datamatrix.messaging.listener.DocumentStatusUpdateListener
import comunda.example.datamatrix.model.DocumentStatusUpdatedMessage
import comunda.example.datamatrix.model.ShipmentDocumentRequest
import comunda.example.datamatrix.model.common.DataMatrix
import comunda.example.datamatrix.model.common.DocumentStatus
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Service
import javax.inject.Inject

@Service
class CreateShipmentDocumentDelegate @Inject constructor(
    private val listener: DocumentStatusUpdateListener
) : JavaDelegate {
    override fun execute(execution: DelegateExecution) {
        // here initial request
        val request = execution.getVariable("shipmentDocumentRequest") as ShipmentDocumentRequest
        // here comes DataMatrixes with updated statuses
        val dataMatrixes = execution.getVariable("dataMatrixes") as ArrayList<DataMatrix>

        // fake req/sub
        listener.handleMessage(DocumentStatusUpdatedMessage(
            request.number + request.sourceSystem,
            DocumentStatus.FINISHED
        ))
    }
}
