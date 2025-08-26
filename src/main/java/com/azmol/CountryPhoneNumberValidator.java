package com.azmol;


import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;

public class CountryPhoneNumberValidator {

    public static void main(String[] args) {

        System.out.println(isValidPhoneNumber("465805445", "+358"));

    }

    public static boolean isValidPhoneNumber(String mobileNumber, String phoneCode) {

        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
        String countryName = "";

        try {
            for (CountryCode code : CountryCode.values()) {
                if (code.getDialCode().equals(phoneCode)) {
                    countryName = code.name();
                }
            }

            PhoneNumber phoneNumber = phoneNumberUtil.parse(phoneCode + mobileNumber, countryName);

            return phoneNumberUtil.isValidNumber(phoneNumber);

        } catch (NumberParseException e) {
            throw new RuntimeException(e);
        }
    }

}
