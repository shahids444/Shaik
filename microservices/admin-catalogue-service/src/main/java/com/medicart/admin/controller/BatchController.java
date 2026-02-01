package com.medicart.admin.controller;

import com.medicart.admin.service.BatchService;
import com.medicart.common.dto.BatchDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/batches")
public class BatchController {

    private static final Logger log = LoggerFactory.getLogger(BatchController.class);
    private final BatchService service;

    public BatchController(BatchService service) {
        this.service = service;
    }

    private void logSecurityContext(String methodName) {
        log.debug("════════════════════════════════════════════════════════════════");
        log.debug("🎯 [BatchController.{}] SECURITY CONTEXT CHECK", methodName);
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        
        if (auth == null) {
            log.debug("   ❌ Authentication: NULL");
        } else {
            log.debug("   ✅ Authentication: EXISTS");
            log.debug("   Principal: {}", auth.getPrincipal());
            log.debug("   Authorities: {}", auth.getAuthorities());
            log.debug("   Authenticated: {}", auth.isAuthenticated());
        }
        log.debug("════════════════════════════════════════════════════════════════");
    }

    @GetMapping
    public List<BatchDTO> getAllBatches() {
        log.debug("🔷 [GET /batches] REQUEST RECEIVED");
        logSecurityContext("getAllBatches");
        
        List<BatchDTO> batches = service.getAllBatches();
        log.debug("✅ [GET /batches] RESPONSE SENT: {} batches", batches.size());
        return batches;
    }

    @PostMapping
    public BatchDTO createBatch(@RequestBody BatchDTO dto) {
        log.debug("🔶 [POST /batches] REQUEST RECEIVED");
        log.debug("   Body: {}", dto);
        logSecurityContext("createBatch");
        
        BatchDTO created = service.createBatch(dto);
        log.debug("✅ [POST /batches] RESPONSE SENT: {}", created.getId());
        return created;
    }

    @PutMapping("/{id}")
    public BatchDTO updateBatch(@PathVariable Long id,
                                @RequestBody BatchDTO dto) {
        log.debug("🔶 [PUT /batches/{}] REQUEST RECEIVED", id);
        log.debug("   Body: {}", dto);
        logSecurityContext("updateBatch");
        
        BatchDTO updated = service.updateBatch(id, dto);
        log.debug("✅ [PUT /batches/{}] RESPONSE SENT", id);
        return updated;
    }

    @DeleteMapping("/{id}")
    public void deleteBatch(@PathVariable Long id) {
        log.debug("🔴 [DELETE /batches/{}] REQUEST RECEIVED", id);
        logSecurityContext("deleteBatch");
        
        service.deleteBatch(id);
        log.debug("✅ [DELETE /batches/{}] RESPONSE SENT", id);
    }
}
