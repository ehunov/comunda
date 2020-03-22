package comunda.example.datamatrix.messaging.listener

import comunda.example.datamatrix.model.DocumentStatusUpdatedMessage
import org.camunda.bpm.engine.RuntimeService
import org.springframework.stereotype.Service
import javax.inject.Inject

@Service
class DocumentStatusUpdateListener @Inject constructor(
    private val runtimeService: RuntimeService
) {
    fun handleMessage(message: DocumentStatusUpdatedMessage) {
        runtimeService.createMessageCorrelation(MESSAGE_NAME)
            .setVariable("documentStatus", message.status)
            .processInstanceVariableEquals(CORRELATION_VARIABLE_UNIQUE_KEY, message.uniqueKey)
            .correlateAllWithResult()
    }

    companion object {
        const val MESSAGE_NAME = "DocumentStatusUpdated"
        const val CORRELATION_VARIABLE_UNIQUE_KEY = "uniqueKey"
    }
}
