package tests;

import base.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.specification.RequestSpecification;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.APIRequestHelper;

public class TestAPIBook extends BaseTest {

    private APIRequestHelper apiRequestHelper = new APIRequestHelper();
    private static final String baseUrl = "https://restful-booker.herokuapp.com/";
    private static final String ERROR_MSG = "The response was not correct";
    private static final int OK_STATUS_CODE = 200;

    @Description("Test to validate POST endpoint")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void testCreateBooking(){
        String url = baseUrl + "booking";
        String body = "{\n" + "    \"firstname\": \"Cynthia\",\n" +
                "    \"lastname\": \"Brown\",\n" +
                "    \"totalprice\": 1212,\n" +
                "    \"depositpaid\": true,\n" +
                "    \"bookingdates\": {\n" +
                "         \"checkin\": \"2018-01-01\",\n" +
                "        \"checkout\": \"2019-01-01\"\n" +
                "    },\n" + "    \"additionalneeds\": \"Breakfast\"\n" + "}";
        RequestSpecification request = apiRequestHelper.initRequest(url);
        int statusCode = apiRequestHelper.postRequest(request, body);
        Assert.assertTrue(statusCode==OK_STATUS_CODE, ERROR_MSG);
    }

    @Description("Test to validate GET endpoint")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void testGetBookingById(){
        String bookingId = "481";
        String url = baseUrl + "booking/" + bookingId;
        RequestSpecification request = apiRequestHelper.initRequest(url);
        String booking = apiRequestHelper.getRequest(request);
        System.out.println("Booking information " + booking);
        Assert.assertTrue(request.get().statusCode()==OK_STATUS_CODE, ERROR_MSG);
    }

    @Description("Test to validate GET endpoint with filters")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void testGetAllBookingsFilter(){
        String url = baseUrl + "booking";
        String parameterName = "firstname";
        String parameterValue = "593106ca-04ce-4eae-b621-6bdd1dd7d86f";
        RequestSpecification request = apiRequestHelper.initRequest(url);
        apiRequestHelper.setParameter(request, parameterName, parameterValue);
        String bookings = apiRequestHelper.getRequest(request);
        System.out.println("Bookings matching the filter " + bookings);
        Assert.assertTrue(request.get().statusCode()==OK_STATUS_CODE, ERROR_MSG);
    }
}
