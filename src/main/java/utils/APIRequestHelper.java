package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIRequestHelper {

    public RequestSpecification initRequest(String url) {
        RestAssured.baseURI=url;
        return RestAssured.given();
    }

    public RequestSpecification setHeader(RequestSpecification request, String headerName, String value) {
        request = RestAssured.given()
                .header(headerName, value);
        return request;
    }

    public RequestSpecification setParameter(RequestSpecification request, String paramName, String value) {
        request = request.param(paramName, value);
        return request;
    }

    public String getRequest(RequestSpecification request) {
        Response response = request.get();
        return response.getBody().asString();
    }

    public int postRequest(RequestSpecification request, String body) {
        request.body(body);
        Response response = request.post();
        return response.statusCode();
    }

    public int deleteRequest(RequestSpecification request) {
        Response response = request.delete();
        return response.statusCode();
    }
}
