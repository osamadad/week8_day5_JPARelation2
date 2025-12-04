package com.tuwaiq.week8_day4_schoolmanagement.Controller;

import com.tuwaiq.week8_day4_schoolmanagement.Api.ApiResponse;
import com.tuwaiq.week8_day4_schoolmanagement.DTOIn.AddressDTO;
import com.tuwaiq.week8_day4_schoolmanagement.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @PostMapping("/add")
    public ResponseEntity<?> addAddress(@RequestBody @Valid AddressDTO addressDTO){
        addressService.addAddress(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("The address have been added successfully"));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateAddress(@RequestBody @Valid AddressDTO addressDTO){
        addressService.updateAddress(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("The address have been updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable Integer id){
        addressService.deleteAddress(id);
        return ResponseEntity.status(200).body(new ApiResponse("The address have been deleted successfully"));
    }
}
