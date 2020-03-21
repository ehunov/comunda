package comunda.example.datamatrix

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@EnableProcessApplication
@SpringBootApplication
class DatamatrixApplication

fun main(args: Array<String>) {
    runApplication<DatamatrixApplication>(*args)
}
