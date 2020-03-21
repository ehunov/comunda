package comunda.example.datamatrix.api.controller

import comunda.example.datamatrix.model.CreateShipmentDocumentRequest
import org.camunda.bpm.engine.RuntimeService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.inject.Inject

@RestController
class RequestController @Inject constructor(
        val runtimeService: RuntimeService
) {
    @PostMapping("/shipments")
    fun create(@RequestBody createShipmentDocumentRequest: CreateShipmentDocumentRequest) {
        runtimeService.createProcessInstanceByKey("createShipmentDocument")
                .setVariable("createShipmentDocumentRequest", createShipmentDocumentRequest)
                .execute()
    }
}
