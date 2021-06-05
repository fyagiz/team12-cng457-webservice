package com.team12.controller;


import com.team12.entity.*;
import com.team12.service.AdditionalFeatureService;
import com.team12.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ComputerController {
    @Autowired
    ComputerService computerService;

    @Autowired
    AdditionalFeatureService additionalFeatureService;

    @PostMapping("/addComputer")
    public Computer savePhone(@RequestBody Computer newComputer){
        return computerService.saveComputer(newComputer);
    }

    @GetMapping("/updateComputer/addAdditionalFeatures/{computerID}/{afId}")
    public Computer updateComputer(@PathVariable int computerID, @PathVariable int afId){
        Computer tempComputer = computerService.getComputerById(computerID);
        AdditionalFeature additionalFeatures=additionalFeatureService.getAdditionalFeature(afId);
        tempComputer.getAdditionalFeatureList().add(additionalFeatures);
        return computerService.saveComputer(tempComputer);
    }

    @GetMapping("/getComputers")
    public List<Computer> getComputers(){
        return computerService.getComputers();
    }

    @GetMapping("/getComputer/{productID}")
    public Computer getComputerById(@PathVariable int productID){
        return computerService.getComputerById(productID);
    }

    @GetMapping("/getComputers/{brandName}")
    public List<Computer> getComputerByBrandName(@PathVariable String brandName){
        return computerService.getComputerByBrandName(brandName);
    }



   

    @GetMapping("/getComputerForSearch")
    public List<Computer> getComputerForSearch(@RequestParam(required = false) Integer computerID,
                                               @RequestParam(required = false) Float screenSize,
                                               @RequestParam(required = false) Float price,
                                               @RequestParam(required = false) String model,
                                               @RequestParam(required = false) String brandName,
                                               @RequestParam(required = false) String computerMemory,
                                               @RequestParam(required = false) Float priceMin,
                                               @RequestParam(required = false) Float priceMax,
                                               @RequestParam(required = false) String computerMemoryMin,
                                               @RequestParam(required = false) String computerMemoryMax,
                                               @RequestParam(required = false) List<String> additionalFeature,
                                               @RequestParam(required = false) String storageCapacity,
                                               @RequestParam(required = false) String storageCapacityMin,
                                               @RequestParam(required = false) String storageCapacityMax,
                                               @RequestParam(required = false) String screenResolution,
                                               @RequestParam(required = false) String processorModelName,
                                               @RequestParam(required = false) Float processorClockFrequency,
                                               @RequestParam(required = false) String comment,
                                               @RequestParam(required = false) Float rating
    ){
        List<Computer> computerList=computerService.getComputers();
        int i;
        // If computerID is given
        if(computerID != null){
            for(i=0;i<computerList.size();i++){
                Computer tempComputer = computerList.get(i);
                if(tempComputer.getProductID() != computerID){
                    computerList.remove(i);
                    i--;
                }
            }
        }
        // If the screenSize is given
        if(screenSize != null){
            for(i=0;i<computerList.size();i++){
                Computer tempComputer = computerList.get(i);
                if(tempComputer.getScreenSize() < screenSize){
                    computerList.remove(i);
                    i--;
                }
            }
        }
        // If the price is given
        if(price != null){
            for(i=0;i<computerList.size();i++){
                Computer tempComputer = computerList.get(i);
                if(tempComputer.getPrice() > price){
                    computerList.remove(i);
                    i--;
                }
            }
        }
        // If the model is given
        if(model != null){
            for(i=0;i<computerList.size();i++){
                Computer tempComputer = computerList.get(i);
                if(!tempComputer.getModel().contains(model)){
                    computerList.remove(i);
                    i--;
                }
            }
        }
        // If the brandName is given
        if(brandName != null){
            for(i=0;i<computerList.size();i++){
                Computer tempComputer = computerList.get(i);
                if(!tempComputer.getBrand().getBrandName().contains(brandName)){
                    computerList.remove(i);
                    i--;
                }
            }
        }
        // If the computerMemory is given
        if(computerMemory != null){
            computerMemory = computerMemory.split(" ")[0];
            int computerMemoryInteger = Integer.parseInt(computerMemory);
            for(i=0;i<computerList.size();i++){
                Computer tempComputer = computerList.get(i);
                String tempComputercomputerMemory = tempComputer.getComputerMemory().split(" ")[0];
                int tempComputercomputerMemoryInteger = Integer.parseInt(tempComputercomputerMemory);
                if(tempComputercomputerMemoryInteger < computerMemoryInteger){
                    computerList.remove(i);
                    i--;
                }
            }
        }
        //If the price is given in range
        if(priceMin!=null && priceMax!=null){
            for ( i = 0; i <computerList.size() ; i++) {
                Computer tempComputer=computerList.get(i);
                if(tempComputer.getPrice()<priceMin || tempComputer.getPrice()>priceMax){
                    computerList.remove(i);
                    i--;
                }

            }
        }

        // If the computer memory is given in range
        if(computerMemoryMin!=null && computerMemoryMax!=null){
            computerMemoryMin = computerMemoryMin.split(" ")[0];
            int computerMemoryMinInteger = Integer.parseInt(computerMemoryMin);
            computerMemoryMax = computerMemoryMax.split(" ")[0];
            int computerMemoryMaxInteger = Integer.parseInt(computerMemoryMax);
            for ( i = 0; i <computerList.size() ; i++) {
                Computer tempComputer=computerList.get(i);
                int computerMemoryTemp= Integer.parseInt(tempComputer.getComputerMemory().split(" ")[0]);
                if(computerMemoryTemp<computerMemoryMinInteger || computerMemoryTemp>computerMemoryMaxInteger){
                    computerList.remove(i);
                    i--;
                }

            }
        }

        // If additional feature is searched
        if(additionalFeature != null){
            for(String feature: additionalFeature){
                for(i=0;i<computerList.size();i++){
                    Computer tempComputer = computerList.get(i);
                    List<AdditionalFeature> tempComputerAdditionalFeatures = tempComputer.getAdditionalFeatureList();
                    Boolean isFound = false;
                    for(AdditionalFeature tmpFeature: tempComputerAdditionalFeatures){
                        if(tmpFeature.getAdditionalFeature().equals(feature)){
                            isFound = true;
                            break;
                        }
                    }
                    if (isFound == false){
                        computerList.remove(i);
                        i--;
                    }
                }
            }
        }

        // If the storageCapacity is given
        if(storageCapacity != null){
            String[] storageCapacityArray = storageCapacity.split(" ");
            float storageCapacityInteger = Float.parseFloat(storageCapacityArray[0]);
            if(storageCapacityArray[1].equals("TB")){
                storageCapacityInteger=storageCapacityInteger * 1000;
            }
            for(i=0;i<computerList.size();i++){
                Computer tempComputer = computerList.get(i);
                String[] tempStorageCapacity = tempComputer.getStorageCapacity().split(" ");
                float tempStorageCapacityInteger = Float.parseFloat(tempStorageCapacity[0]);
                if(tempStorageCapacity[1].equals("TB")){
                    tempStorageCapacityInteger = tempStorageCapacityInteger * 1000;
                }
                if(tempStorageCapacityInteger < storageCapacityInteger){
                    computerList.remove(i);
                    i--;
                }
            }
        }

        // If storageCapacity in range
        if(storageCapacityMin!=null && storageCapacityMax!=null){
            String[] storageCapacityMinArray = storageCapacityMin.split(" ");
            String[] storageCapacityMaxArray = storageCapacityMax.split(" ");
            float storageCapacityMinInteger = Float.parseFloat(storageCapacityMinArray[0]);
            float storageCapacityMaxInteger = Float.parseFloat(storageCapacityMaxArray[0]);
            if(storageCapacityMinArray[1].equals("TB")){
                storageCapacityMinInteger = storageCapacityMinInteger * 1000;
            }
            if(storageCapacityMaxArray[1].equals("TB")){
                storageCapacityMaxInteger = storageCapacityMaxInteger * 1000;
            }
            for(i=0;i<computerList.size();i++){
                Computer tempComputer = computerList.get(i);
                String[] tempStorageCapacity = tempComputer.getStorageCapacity().split(" ");
                float tempStorageCapacityInteger = Float.parseFloat(tempStorageCapacity[0]);
                if(tempStorageCapacity[1].equals("TB")){
                    tempStorageCapacityInteger = tempStorageCapacityInteger * 1000;
                }
                if(tempStorageCapacityInteger<storageCapacityMinInteger || tempStorageCapacityInteger>storageCapacityMaxInteger){
                    computerList.remove(i);
                    i--;
                }
            }
        }

        // If screenResolution is given
        if(screenResolution != null){
            for(i=0;i<computerList.size();i++){
                Computer tempComputer = computerList.get(i);
                if(!tempComputer.getScreenResolution().equals(screenResolution)){
                    computerList.remove(i);
                    i--;
                }
            }
        }
        // If processorModelName is given
        if(processorModelName != null){
            for(i=0;i<computerList.size();i++){
                Computer tempComputer = computerList.get(i);
                if(!tempComputer.getProcessor().getModelName().equals(processorModelName)){
                    computerList.remove(i);
                    i--;
                }
            }
        }
        // If processorClockFrequency is given
        if(processorClockFrequency != null){
            for(i=0;i<computerList.size();i++){
                Computer tempComputer = computerList.get(i);
                if(tempComputer.getProcessor().getClockFrequency() < processorClockFrequency){
                    computerList.remove(i);
                    i--;
                }
            }
        }
        // If comment is given
        if(comment != null){
            comment = comment.toLowerCase();
            for(i=0;i<computerList.size();i++){
                Computer tempComputer = computerList.get(i);
                Boolean isFound = false;
                for(CommentAndRating userReview : tempComputer.getCommentAndRatingList()){
                    if(userReview.getCustomerComment().toLowerCase().contains(comment)){
                        isFound = true;
                        break;
                    }
                }
                if(isFound == false){
                    computerList.remove(i);
                    i--;
                }
            }
        }
        // If rating is given
        if(rating != null){
            for(i=0;i<computerList.size();i++){
                Computer tempComputer = computerList.get(i);
                float averageRating = 0;
                for(CommentAndRating userReview : tempComputer.getCommentAndRatingList()){
                    averageRating += userReview.getRating();
                }
                averageRating = averageRating / tempComputer.getCommentAndRatingList().size();
                if(averageRating < rating){
                    computerList.remove(i);
                    i--;
                }
            }
        }
        return computerList;
    }

}
