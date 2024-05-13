package tests;

import base.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.specification.RequestSpecification;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.APIRequestHelper;

public class TestAPI extends BaseTest {
    private APIRequestHelper apiRequestHelper = new APIRequestHelper();
    private static final String baseUrl = "https://api.thedogapi.com/v1/";
    private static final String paramName = "x-api-key";
    private static final String paramValue = "live_FxWkVz9RmiqzFuBEH4hcr2jMMiKdaBIGNYK3AqWfBK7jWZZD0Yo3SEnB2I5zo0Bp";
    private static final String contentType = "Content-Type";
    private static final String contentTypeValue = "application/json";
    private static final String ERROR_MSG = "The response was not correct";
    private static final int OK_STATUS_CODE = 200;

    @Description("Test to validate GET endpoint")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void testGetDogBreed(){
        String dogId = "3";
        String url = baseUrl + "breeds/" + dogId;
        RequestSpecification request = apiRequestHelper.initRequest(url);
        apiRequestHelper.setHeader(request, paramName, paramValue);
        apiRequestHelper.setHeader(request, contentType, contentTypeValue);
        String dogInformation = apiRequestHelper.getRequest(request);
        System.out.println("Dog breed: " + dogInformation);
        Assert.assertTrue(request.get().statusCode()==OK_STATUS_CODE, ERROR_MSG);
    }

    @Description("Test to validate POST endpoint")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void testUpdateDogVote(){
        String url = baseUrl + "votes";
        String body = "{\n" +
                "\t\"image_id\":\"GAmy2bg8G\",\n" +
                "\t\"sub_id\": \"my-user-1232\",\n" +
                "\t\"value\":1\n" +
                "}";
        RequestSpecification request = apiRequestHelper.initRequest(url);
        apiRequestHelper.setHeader(request, paramName, paramValue);
        apiRequestHelper.setHeader(request, contentType, contentTypeValue);
        int result = apiRequestHelper.postRequest(request, body);
        Assert.assertTrue(result==OK_STATUS_CODE, ERROR_MSG);
    }

    @Description("Test to validate DELETE endpoint")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void testDeleteDogVote(){
        String dogId = "198689";
        String url = baseUrl + "votes/" + dogId;
        RequestSpecification request = apiRequestHelper.initRequest(url);
        apiRequestHelper.setHeader(request, paramName, paramValue);
        apiRequestHelper.setHeader(request, contentType, contentTypeValue);
        int result = apiRequestHelper.deleteRequest(request);
        Assert.assertTrue(result==OK_STATUS_CODE, ERROR_MSG);
    }
}