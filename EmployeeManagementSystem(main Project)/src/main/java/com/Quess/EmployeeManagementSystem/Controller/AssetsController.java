package com.Quess.EmployeeManagementSystem.Controller;


import com.Quess.EmployeeManagementSystem.Models.Assets;
import com.Quess.EmployeeManagementSystem.Service.AssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/assets")
public class AssetsController {

    @Autowired
    private AssetsService service;

    public AssetsController(AssetsService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> saveAssetDetail(@RequestBody @Valid Assets assets)
    {
        service.saveAsset(assets);
        return new ResponseEntity<String>("Asset Added Successfully", HttpStatus.CREATED);
    }

    @GetMapping
    public List<Assets> getAllAssets()
    {
        return service.getAllAssets();
    }
    @GetMapping("{id}")
    public ResponseEntity<Assets> getAssetById(@PathVariable("id")int id)
    {
        return new ResponseEntity<Assets>(service.getAssetById(id),HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<String> updateAsset(@PathVariable("id")int id,@RequestBody Assets assets)
    {
        service.updateAsset(assets,id);
        return new ResponseEntity<String>("Asset Updated Successfully", HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAsset(@PathVariable("id")int id)
    {
        service.deleteAsset(id);
        return new ResponseEntity<String>("Asset deleted successfully",HttpStatus.OK);
    }
}
