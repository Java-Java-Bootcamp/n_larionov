package com.example.demo.web.controller;

import com.example.demo.dto.ProductDto;
import com.example.demo.service.api.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/api")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @Operation(summary = "Add new product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Add the product", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDto.class))}),
            @ApiResponse(responseCode = "409", description = "Can add  duplicate product", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDto.class))})
    })
    @PostMapping(value = "/product/add", consumes = "application/json")
    public ResponseEntity<Long> addProduct(@RequestBody ProductDto productDto) {
        long id = adminService.addProduct(productDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @Operation(summary = "Update existing product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "product is updated", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDto.class))}),
            @ApiResponse(responseCode = "401", description = "Product with current id is absent in table", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDto.class))})
    })
    @PatchMapping(path = "/product/{id}/update", consumes = "application/json")
    public void updateProduct(@PathVariable("id")long productId, @RequestBody ProductDto productDto) {
        adminService.updateProduct(productId, productDto);
    }

    // add new product to the product list by store
}




