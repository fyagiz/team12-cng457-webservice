package com.team12.controller;

import com.team12.entity.AdditionalFeature;
import com.team12.entity.CommentAndRating;
import com.team12.entity.Phone;
import com.team12.service.AdditionalFeatureService;
import com.team12.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PhoneController {
    @Autowired
    PhoneService phoneService;
    @Autowired
    AdditionalFeatureService additionalFeatureService;

    @PostMapping("/addPhone")
    public Phone savePhone(@RequestBody Phone newPhone){
        return phoneService.savePhone(newPhone);
    }

    @GetMapping("/updatePhone/addAdditionalFeatures/{phoneId}/{afId}")
    public Phone updatePhone(@PathVariable int phoneId, @PathVariable int afId){
        Phone tempPhone= phoneService.getPhoneById(phoneId);
        AdditionalFeature additionalFeatures=additionalFeatureService.getAdditionalFeature(afId);
        tempPhone.getAdditionalFeatureList().add(additionalFeatures);
        return phoneService.savePhone(tempPhone);
    }

    @GetMapping("/getPhones")
    public List<Phone> getPhones(){
        return phoneService.getPhones();
    }

    @GetMapping("/getPhone/{productID}")
    public Phone getPhoneById(@PathVariable int productID){
        return phoneService.getPhoneById(productID);
    }

    @GetMapping("/getPhones/{brandName}")
    public List<Phone> getPhoneByBrandName(@PathVariable String brandName){
        return phoneService.getPhoneByBrandName(brandName);
    }

    @GetMapping("/getPhonesForSearch")
    public List<Phone> getPhonesForSearch(@RequestParam(required = false) Integer phoneID,
                                          @RequestParam(required = false) Float screenSize,
                                          @RequestParam(required = false) Float price,
                                          @RequestParam(required = false) String model,
                                          @RequestParam(required = false) String brandName,
                                          @RequestParam(required = false) String internalMemory,
                                          @RequestParam(required = false) Float priceMin,
                                          @RequestParam(required = false) Float priceMax,
                                          @RequestParam(required = false) String internalMemoryMin,
                                          @RequestParam(required = false) String internalMemoryMax,
                                          @RequestParam(required = false) List<String> additionalFeature,
                                          @RequestParam(required = false) String comment,
                                          @RequestParam(required = false) Float rating
                                          ){
        List<Phone> phoneList=phoneService.getPhones();
        int i;
        // If phoneID is given
        if(phoneID != null){
            for(i=0;i<phoneList.size();i++){
                Phone tempPhone = phoneList.get(i);
                if(tempPhone.getProductID() != phoneID){
                    phoneList.remove(i);
                    i--;
                }
            }
        }
        // If the screenSize is given
        if(screenSize != null){
            for(i=0;i<phoneList.size();i++){
                Phone tempPhone = phoneList.get(i);
                if(tempPhone.getScreenSize() < screenSize){
                    phoneList.remove(i);
                    i--;
                }
            }
        }
        // If the price is given
        if(price != null){
            for(i=0;i<phoneList.size();i++){
                Phone tempPhone = phoneList.get(i);
                if(tempPhone.getPrice() > price){
                    phoneList.remove(i);
                    i--;
                }
            }
        }
        // If the model is given
        if(model != null){
            for(i=0;i<phoneList.size();i++){
                Phone tempPhone = phoneList.get(i);
                if(!tempPhone.getModel().contains(model)){
                    phoneList.remove(i);
                    i--;
                }
            }
        }
        // If the brandName is given
        if(brandName != null){
            for(i=0;i<phoneList.size();i++){
                Phone tempPhone = phoneList.get(i);
                if(!tempPhone.getBrand().getBrandName().contains(brandName)){
                    phoneList.remove(i);
                    i--;
                }
            }
        }
        // If the internalMemory is given
        if(internalMemory != null){
            internalMemory = internalMemory.split(" ")[0];
            int internalMemoryInteger = Integer.parseInt(internalMemory);
            for(i=0;i<phoneList.size();i++){
                Phone tempPhone = phoneList.get(i);
                String tempPhoneInternalMemory = tempPhone.getInternalMemory().split(" ")[0];
                int tempPhoneInternalMemoryInteger = Integer.parseInt(tempPhoneInternalMemory);
                if(tempPhoneInternalMemoryInteger < internalMemoryInteger){
                    phoneList.remove(i);
                    i--;
                }
            }
        }
        //If the price is given in range
        if(priceMin!=null && priceMax!=null){
            for ( i = 0; i <phoneList.size() ; i++) {
                Phone tempPhone=phoneList.get(i);
                if(tempPhone.getPrice()<priceMin || tempPhone.getPrice()>priceMax){
                    phoneList.remove(i);
                    i--;
                }

            }
        }

        //If the internal memory is given in range
        if(internalMemoryMin!=null && internalMemoryMax!=null){
            internalMemoryMin = internalMemoryMin.split(" ")[0];
            int internalMemoryMinInteger = Integer.parseInt(internalMemoryMin);
            internalMemoryMax = internalMemoryMax.split(" ")[0];
            int internalMemoryMaxInteger = Integer.parseInt(internalMemoryMax);
            for ( i = 0; i <phoneList.size() ; i++) {
                Phone tempPhone=phoneList.get(i);
                int internalMemoryTemp= Integer.parseInt(tempPhone.getInternalMemory().split(" ")[0]);
                if(internalMemoryTemp<internalMemoryMinInteger || internalMemoryTemp>internalMemoryMaxInteger){
                    phoneList.remove(i);
                    i--;
                }

            }
        }

        //If additional feature is searched
        if(additionalFeature != null){
            for(String feature: additionalFeature){
                for(i=0;i<phoneList.size();i++){
                    Phone tempPhone = phoneList.get(i);
                    List<AdditionalFeature> tempPhoneAdditionalFeatures = tempPhone.getAdditionalFeatureList();
                    Boolean isFound = false;
                    for(AdditionalFeature tmpFeature: tempPhoneAdditionalFeatures){
                        if(tmpFeature.getAdditionalFeature().equals(feature)){
                            isFound = true;
                            break;
                        }
                    }
                    if (isFound == false){
                        phoneList.remove(i);
                        i--;
                    }
                }
            }
        }
        // If comment is given
        if(comment != null){
            comment = comment.toLowerCase();
            for(i=0;i<phoneList.size();i++){
                Phone tempPhone = phoneList.get(i);
                Boolean isFound = false;
                for(CommentAndRating userReview : tempPhone.getCommentAndRatingList()){
                    if(userReview.getCustomerComment().toLowerCase().contains(comment)){
                        isFound = true;
                        break;
                    }
                }
                if(isFound == false){
                    phoneList.remove(i);
                    i--;
                }
            }
        }
        // If rating is given
        if(rating != null){
            for(i=0;i<phoneList.size();i++){
                Phone tempPhone = phoneList.get(i);
                float averageRating = 0;
                for(CommentAndRating userReview : tempPhone.getCommentAndRatingList()){
                    averageRating += userReview.getRating();
                }
                averageRating = averageRating / tempPhone.getCommentAndRatingList().size();
                if(averageRating < rating){
                    phoneList.remove(i);
                    i--;
                }
            }
        }
        return phoneList;
    }



}
