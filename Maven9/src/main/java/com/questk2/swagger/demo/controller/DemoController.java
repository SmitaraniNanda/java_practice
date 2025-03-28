package com.questk2.swagger.demo.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Demo controller", description = "APIs for controllers for example of HTTP methods") 
public class DemoController {

	@Operation(summary = "Get mapping", description = "Example of Get mapping")
	@ApiResponse(responseCode = "200", description = "found", content = @Content(schema = @Schema(implementation = String.class)))
	@ApiResponse(responseCode = "404", description = "Method not found")
	@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(schema = @Schema(implementation = String.class)))
	@GetMapping("/get/{text}")
	public ResponseEntity<?> get(@PathVariable String text) {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "application/json; charset=utf-8");
		return ResponseEntity.status(HttpStatus.OK).headers(new HttpHeaders()).body("Hello!!! I am Get");

	}

	@Operation(summary = "POST mapping", description = "Example of POST mapping")
	@ApiResponse(responseCode = "200", description = "found", content = @Content(schema = @Schema(implementation = String.class)))
	@ApiResponse(responseCode = "404", description = "Method not found")
	@PostMapping("/post")
	public ResponseEntity<?> post(@RequestBody TokenRequest tokenRequest) {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "application/json; charset=utf-8");
		return ResponseEntity.status(HttpStatus.OK).headers(new HttpHeaders()).body("Hello!!! I am post");

	}

	@Operation(summary = "Put mapping", description = "Example of Put mapping..")
	@ApiResponse(responseCode = "200", description = "found", content = @Content(schema = @Schema(implementation = String.class)))
	@ApiResponse(responseCode = "404", description = "Method not found")
	@PutMapping("/put")
	public ResponseEntity<?> put() {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "application/json; charset=utf-8");
		return ResponseEntity.status(HttpStatus.OK).headers(new HttpHeaders()).body("Hello!!! I am put");

	}

	@Operation(summary = "delete mapping", description = "Example of delete mapping")
	@ApiResponse(responseCode = "200", description = "found", content = @Content(schema = @Schema(implementation = String.class)))
	@ApiResponse(responseCode = "404", description = "Method not found")
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete() {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "application/json; charset=utf-8");
		return ResponseEntity.status(HttpStatus.OK).headers(new HttpHeaders()).body("Hello!!! I am delete");

	}

}
