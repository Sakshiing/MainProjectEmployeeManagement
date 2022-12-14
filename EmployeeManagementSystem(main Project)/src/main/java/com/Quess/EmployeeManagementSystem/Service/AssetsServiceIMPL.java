package com.Quess.EmployeeManagementSystem.Service;

import com.Quess.EmployeeManagementSystem.Models.Assets;
import com.Quess.EmployeeManagementSystem.Repository.AssetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetsServiceIMPL implements AssetsService {

    @Autowired
    private AssetsRepository assetsrepo;

    public AssetsServiceIMPL(AssetsRepository assetsrepo) {
        this.assetsrepo =assetsrepo;
    }

    @Override
    public Assets saveAsset(Assets assets) {
        return assetsrepo.save(assets);
    }

    @Override
    public List<Assets> getAllAssets() {
        return assetsrepo.findAll();
    }

    @Override
    public Assets getAssetById(int id) {
        return assetsrepo.findById(id).orElseThrow(() -> new  com.Quess.EmployeeManagementSystem.exception.ResourceNotFoundException("assets not found with id :" + id));
    }

    @Override
    public Assets updateAsset(Assets assets, int id) {
        Assets existingDetail=assetsrepo.findById(id).orElseThrow(() -> new  com.Quess.EmployeeManagementSystem.exception.ResourceNotFoundException("assets not found with id :" + id));
        existingDetail.setAssetName(assets.getAssetName());
        existingDetail.setAssetType(assets.getAssetType());
        existingDetail.setAssetValue(assets.getAssetValue());
        assetsrepo.save(existingDetail);
        return existingDetail;
    }

    @Override
    public void deleteAsset(int id) {
        assetsrepo.findById(id).orElseThrow(() -> new  com.Quess.EmployeeManagementSystem.exception.ResourceNotFoundException("Assets not found with id :" + id));
        assetsrepo.deleteById(id);

    }
}
