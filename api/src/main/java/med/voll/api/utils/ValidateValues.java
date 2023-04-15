package med.voll.api.utils;

import med.voll.api.address.Address;
import med.voll.api.address.AddressRecord;

public class ValidateValues {
    public String returnValidString(String data, String attribute){
        if(data != null){
            return data;
        }
        return attribute;
    }

    public Address returnValidAddress(AddressRecord data, Address attribute){
        if(data != null){
            attribute.updateAddress(data);
        }
        return attribute;
    }
}
