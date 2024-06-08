package nl.hoogervorst.hc.adapter.rest.incoming;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.hoogervorst.hc.adapter.rest.incoming.input.QualityOverviewInput;
import nl.hoogervorst.hc.application.QualityOverviewService;
import nl.hoogervorst.hc.domain.query.QualityOverviewView;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class QualityOverviewController {

    private final QualityOverviewService qualityOverviewService;

    @GetMapping("/hello")
    public String tempKeycloakService() {
        return "Hello keycloack integration";
    }
    @GetMapping("/hello-user")
    @PreAuthorize("hasRole('client_user')")
    public String tempKeycloakServiceUser() {
        return "Hello keycloack integration for USERS";
    }

    @GetMapping("/hello-admin")
    @PreAuthorize("hasRole('client_admin')")
    public String tempKeycloakServiceAdmin() {
        return "Hello keycloack integration for ADMIN only";
    }

    @GetMapping("/quality-overview/{qualityOverviewId}")
    public ResponseEntity<QualityOverviewView> getQualityOverview(@PathVariable UUID qualityOverviewId){

        log.info("Ik kom in de GET!");

        return ResponseEntity.ok(qualityOverviewService.getQualityOverview(qualityOverviewId));
    }

    @GetMapping("/quality-overview")
    public ResponseEntity<Page<QualityOverviewView>> getAllQualityOverview(Pageable pageable){
        log.info("Ik kom in de GET ALL");

        return ResponseEntity.ok(qualityOverviewService.getAllQualityOverview(pageable));
    }

    @PostMapping("/quality-overview")
    public ResponseEntity<Void> setQualityOverview(@RequestBody QualityOverviewInput qualityOverviewInput){

        log.info("Ik kom in de POST!");

        qualityOverviewService.saveQualityOverview(qualityOverviewInput);

        return ResponseEntity.accepted().build();
    }
}
