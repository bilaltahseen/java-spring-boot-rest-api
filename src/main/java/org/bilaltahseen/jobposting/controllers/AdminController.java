package org.bilaltahseen.jobposting.controllers;

import lombok.AllArgsConstructor;
import org.bilaltahseen.jobposting.common.APIResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping("/admin")
@RestController
public class AdminController {

    @GetMapping("/dashboard")
    public ResponseEntity<APIResponse<?>> dashboard() {
        return ResponseEntity.ok(new APIResponse<>("Admin dashboard", null));
    }
}
