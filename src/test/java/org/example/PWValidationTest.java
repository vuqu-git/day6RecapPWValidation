package org.example;

// this import for Assertions class
import org.junit.jupiter.api.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;



class PWValidationTest {
    @DisplayName("test for the method with password length")
    @ParameterizedTest(name = "Case {index}: testPW=\"{0}\", testMinLength={1} => result={2}")
    @CsvSource(
            delimiter = ':',
            value = {
                    "Wsdfe:8:false",
                    "sjdhjshdjhskhd:8:true",
                    "sldk sd:8:false",
                    "S ksjd kj jj:8:true",
                    "sd:2:true",
                    "sdkj:1:true",
            }
    )
    void isOfMinLength(String testPW, int testMinLength, boolean expectedRes) {

        // WHEN
        boolean actualRes = PWValidation.isOfMinLength(testPW, testMinLength);
        //THEN
        Assertions.assertEquals(expectedRes, actualRes);
    }

}