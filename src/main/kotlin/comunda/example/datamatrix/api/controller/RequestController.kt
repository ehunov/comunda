package comunda.example.datamatrix.api.controller

import comunda.example.datamatrix.model.ShipmentDocumentRequest
import org.camunda.bpm.engine.RuntimeService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.inject.Inject

@RestController
class RequestController @Inject constructor(
    val runtimeService: RuntimeService
) {
    @PostMapping("/shipment-document-request")
    fun create(@RequestBody shipmentDocumentRequest: ShipmentDocumentRequest) {
        runtimeService.createProcessInstanceByKey("createShipmentDocument")
            .setVariable("shipmentDocumentRequest", shipmentDocumentRequest)
            .execute()
    }
}
