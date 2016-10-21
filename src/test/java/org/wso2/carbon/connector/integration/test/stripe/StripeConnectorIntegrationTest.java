/*
 *  Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.carbon.connector.integration.test.stripe;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.wso2.connector.integration.test.base.ConnectorIntegrationTestBase;
import org.wso2.connector.integration.test.base.RestResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StripeConnectorIntegrationTest extends ConnectorIntegrationTestBase {
    private Map<String, String> esbRequestHeadersMap = new HashMap<String, String>();

    private Map<String, String> apiRequestHeadersMap = new HashMap<String, String>();

    private Map<String, String> mpRequestHeadersMap = new HashMap<String, String>();

    private String apiUrl;
    private String invalidId;

    /**
     * Set up the environment.
     */
    @BeforeClass(alwaysRun = true)
    public void setEnvironment() throws Exception {

        init("stripe-connector-2.0.1-SNAPSHOT");

        apiUrl = connectorProperties.getProperty("apiUrl");
        invalidId = connectorProperties.getProperty("invalidId");

        esbRequestHeadersMap.put("Accept-Charset", "UTF-8");
        esbRequestHeadersMap.put("Content-Type", "application/json");

        apiRequestHeadersMap.put("Content-Type", "application/x-www-form-urlencoded");
        apiRequestHeadersMap.put("Authorization", "Bearer " + connectorProperties.getProperty("apiKey"));

    }

    /**
     * Positive test case for createTokenForCard method with mandatory parameters.
     */
    @Test(groups = {"wso2.esb"}, description = "Stripe {createTokenForCard} integration test with mandatory parameters.")
    public void testCreateTokenForCardWithMandatoryParameters() throws IOException, JSONException {

        esbRequestHeadersMap.put("Action", "urn:createTokenForCard");
        RestResponse< JSONObject > esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "createTokenForCard_Mandatory.json");

        String tokenId = esbRestResponse.getBody().getString("id");
        connectorProperties.put("tokenId", tokenId);
        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/" + connectorProperties.getProperty("apiVersion") + "/tokens/" + tokenId;
        RestResponse< JSONObject > apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);

        Assert.assertEquals(esbRestResponse.getBody().toString(), apiRestResponse.getBody().toString());
    }

    /**
     * Positive test case for createTokenForCard method with mandatory parameters.
     */
    @Test(groups = {"wso2.esb"}, description = "Stripe {createTokenForCard} integration test with mandatory parameters.")
    public void testCreateTokenForCardMandatoryParameters() throws IOException, JSONException {

        esbRequestHeadersMap.put("Action", "urn:createTokenForCard");
        RestResponse< JSONObject > esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "createTokenForCard_Mandatory.json");

        String tokId = esbRestResponse.getBody().getString("id");
        connectorProperties.put("tokId", tokId);
        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/" + connectorProperties.getProperty("apiVersion") + "/tokens/" + tokId;
        RestResponse< JSONObject > apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);

        Assert.assertEquals(esbRestResponse.getBody().toString(), apiRestResponse.getBody().toString());
    }

    /**
     * Positive test case for createTokenForCard method with mandatory parameters.
     */
    @Test(groups = {"wso2.esb"}, description = "Stripe {createTokenForCard} integration test with mandatory parameters.")
    public void testCreateTokenForCardWithMandatoryParameter() throws IOException, JSONException {

        esbRequestHeadersMap.put("Action", "urn:createTokenForCard");
        RestResponse< JSONObject > esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "createTokenForCard_Mandatory.json");

        String tokenIds = esbRestResponse.getBody().getString("id");
        connectorProperties.put("tokenIds", tokenIds);
        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/" + connectorProperties.getProperty("apiVersion") + "/tokens/" + tokenIds;
        RestResponse< JSONObject > apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);

        Assert.assertEquals(esbRestResponse.getBody().toString(), apiRestResponse.getBody().toString());
    }

    /**
     * Positive test case for createTokenForCard method with optional parameters.
     */
    @Test(groups = {"wso2.esb"}, description = "Stripe {createTokenForCard} integration test with optional parameters.")
    public void testCreateTokenForCardWithOptionalParameters() throws IOException, JSONException {

        esbRequestHeadersMap.put("Action", "urn:createTokenForCard");
        RestResponse< JSONObject > esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "createTokenForCard_Optional.json");

        String tokenId = esbRestResponse.getBody().getString("id");
        connectorProperties.put("optionalTokenId", tokenId);

        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/" + connectorProperties.getProperty("apiVersion") + "/tokens/" + tokenId;
        RestResponse< JSONObject > apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);

        Assert.assertEquals(esbRestResponse.getBody().toString(), apiRestResponse.getBody().toString());
    }

    /**
     * Positive test case for createTokenForBankAccount method with mandatory parameters.
     */
    @Test(groups = {"wso2.esb"}, description = "Stripe {createTokenForBankAccount} integration test with mandatory parameters.")
    public void testCreateTokenForBankAccountWithMandatoryParameters() throws IOException, JSONException {

        esbRequestHeadersMap.put("Action", "urn:createTokenForBankAccount");
        RestResponse< JSONObject > esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "createTokenForBankAccount_Mandatory.json");

        String bTokenId = esbRestResponse.getBody().getString("id");
        connectorProperties.put("bTokenId", bTokenId);

        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/" + connectorProperties.getProperty("apiVersion") + "/tokens/" + bTokenId;
        RestResponse< JSONObject > apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);

        Assert.assertEquals(esbRestResponse.getBody().toString(), apiRestResponse.getBody().toString());
    }

    /**
     *
     *  Positive test case for createTokenForBankAccount method with optional parameters.
     */
    @Test(groups = {"wso2.esb"}, description = "Stripe {createTokenForBankAccount} integration test with optional parameters.")
    public void testCreateTokenForBankAccountWithOptionalParameters() throws IOException, JSONException {

        esbRequestHeadersMap.put("Action", "urn:createTokenForBankAccount");
        RestResponse< JSONObject > esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "createTokenForBankAccount_Optional.json");

        String optionalBankTokenId = esbRestResponse.getBody().getString("id");
        connectorProperties.put("optionalBankTokenId", optionalBankTokenId);

        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/" + connectorProperties.getProperty("apiVersion") + "/tokens/" + optionalBankTokenId;
        RestResponse< JSONObject > apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);

        Assert.assertEquals(esbRestResponse.getBody().toString(), apiRestResponse.getBody().toString());
    }

    /**
     *
     * Positive test case for createPIIToken method.
     */
    @Test(groups = {"wso2.esb"}, description = "Stripe {createPIIToken} integration test with positive case.")
    public void testCreatePIITokenPositiveTestCase() throws IOException, JSONException {

        esbRequestHeadersMap.put("Action", "urn:createPIIToken");
        RestResponse< JSONObject > esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "createPIIToken_Positive.json");

        String pId = esbRestResponse.getBody().getString("id");
        connectorProperties.put("pId", pId);

        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/" + connectorProperties.getProperty("apiVersion") + "/tokens/" + pId;
        RestResponse< JSONObject > apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);

        Assert.assertEquals(esbRestResponse.getBody().toString(), apiRestResponse.getBody().toString());
    }

    /**
     *
     * Positive test case for retrieveToken method.
     */
    @Test(groups = {"wso2.esb"},dependsOnMethods = {"testCreateTokenForCardWithMandatoryParameters"},description = "Stripe {retrieveToken} integration test with positive case.")
    public void testRetrieveAnExistingTokenPositiveTestCase() throws IOException, JSONException {

        esbRequestHeadersMap.put("Action", "urn:retrieveToken");
        RestResponse< JSONObject > esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "retrieveToken_Positive.json");

        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/" + connectorProperties.getProperty("apiVersion") + "/tokens/" + connectorProperties.getProperty("tokenId");
        RestResponse< JSONObject > apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);

        Assert.assertEquals(esbRestResponse.getBody().toString(), apiRestResponse.getBody().toString());
    }

    /**
     *
     * Negative test case for retrieveToken method.
     */
    @Test(groups = {"wso2.esb"},dependsOnMethods = {"testRetrieveAnExistingTokenPositiveTestCase"},description = "Stripe {retrieveToken} integration test with positive case.")
    public void testRetrieveAnExistingTokenNegativeTestCase() throws IOException, JSONException {

        esbRequestHeadersMap.put("Action", "urn:retrieveToken");
        RestResponse< JSONObject > esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "retrieveToken_Negative.json");

        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/" + connectorProperties.getProperty("apiVersion") + "/tokens/" + invalidId;
        RestResponse< JSONObject > apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);

        Assert.assertEquals(esbRestResponse.getBody().toString(), apiRestResponse.getBody().toString());
    }

    /**
     *
     * Positive test case for createCustomer method with mandatory parameters.
     */
    @Test(groups = {"wso2.esb"}, dependsOnMethods = {"testCreateTokenForCardWithMandatoryParameter"}, description = "Stripe {createCustomer} integration test with mandatory parameters.")
    public void testCreateANewCustomerWithMandatoryParameters() throws IOException, JSONException {

        esbRequestHeadersMap.put("Action", "urn:createCustomer");
        RestResponse< JSONObject > esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "createCustomer_Mandatory.json");

        String customerId = esbRestResponse.getBody().getString("id");
        connectorProperties.put("customerId", customerId);
        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/" + connectorProperties.getProperty("apiVersion") + "/customers/" + customerId;
        RestResponse< JSONObject > apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);

        Assert.assertEquals(esbRestResponse.getBody().toString(), apiRestResponse.getBody().toString());
    }

    /**
     *
     *  Positive test case for createCustomer method with optional parameters.
     */
    @Test(groups = {"wso2.esb"}, description = "Stripe {createCustomer} integration test with optional parameters.")
    public void testCreateANewCustomerWithOptionalParameters() throws IOException, JSONException {

        esbRequestHeadersMap.put("Action", "urn:createCustomer");
        RestResponse< JSONObject > esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "createCustomer_Optional.json");

        String optionalCustomerId = esbRestResponse.getBody().getString("id");
        connectorProperties.put("optionalCustomerId", optionalCustomerId);
        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/" + connectorProperties.getProperty("apiVersion") + "/customers/" + optionalCustomerId;
        RestResponse< JSONObject > apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);

        Assert.assertEquals(esbRestResponse.getBody().toString(), apiRestResponse.getBody().toString());
    }

    /**
     *
     * Negative test case for createCustomer method.
     */
    @Test(groups = {"wso2.esb"}, description = "Stripe {createCustomer} integration test with negative test cases.")
    public void testCreateANewCustomerWithNegativeTestCase() throws IOException, JSONException {

        esbRequestHeadersMap.put("Action", "urn:createCustomer");
        RestResponse< JSONObject > esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "createCustomer_Negative.json");

        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 402);
        Assert.assertEquals(esbRestResponse.getBody().getJSONObject("error").get("message"), "Your card number is incorrect.");
    }

    /**
     *
     *  Positive test case for retrieveCustomer method.
     */
    @Test(groups = {"wso2.esb"}, dependsOnMethods = {"testCreateANewCustomerWithOptionalParameters"},description = "Stripe {retrieveCustomer} integration test with positive case.")
    public void testRetrieveAnExistingCustomerPositiveTestCase() throws IOException, JSONException {
        esbRequestHeadersMap.put("Action", "urn:retrieveCustomer");
        RestResponse< JSONObject > esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "retrieveCustomer_Positive.json");

        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/" + connectorProperties.getProperty("apiVersion") + "/customers/" + connectorProperties.getProperty("optionalCustomerId");
        RestResponse< JSONObject > apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);

        Assert.assertEquals(esbRestResponse.getBody().toString(), apiRestResponse.getBody().toString());
    }

    /**
     *
     * Negative test case for retrieveCustomer method.
     */
    @Test(groups = {"wso2.esb"}, dependsOnMethods = {"testRetrieveAnExistingCustomerPositiveTestCase"},description = "Stripe {retrieveCustomer} integration test with positive case.")
    public void testRetrieveAnExistingCustomerNegativeTestCase() throws IOException, JSONException {

        esbRequestHeadersMap.put("Action", "urn:retrieveCustomer");
        RestResponse< JSONObject > esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "retrieveCustomer_Negative.json");

        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/" + connectorProperties.getProperty("apiVersion") + "/customers/" + invalidId;
        RestResponse< JSONObject > apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);

        Assert.assertEquals(esbRestResponse.getBody().toString(), apiRestResponse.getBody().toString());
    }

    /**
     *
     * Positive test case for retrieveAccountDetails method parameters.
     */
    @Test(groups = {"wso2.esb"}, description = "Stripe {retrieveAccountDetails} integration test with optional parameters.")
    public void testRetrieveAccountDetails() throws IOException, JSONException {

        esbRequestHeadersMap.put("Action", "urn:retrieveAccountDetails");
        RestResponse< JSONObject > esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "retrieveAccountDetails.json");

        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/" + connectorProperties.getProperty("apiVersion") + "/account" ;
        RestResponse< JSONObject > apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);

        Assert.assertEquals(esbRestResponse.getBody().toString(), apiRestResponse.getBody().toString());
    }

    /**
     *
     * Positive test case for getAllCustomers with mandatory parameters.
     **/
    @Test(groups = {"wso2.esb"},description = "Stripe {retrieveCustomer} integration test with positive case.")
    public void testGetAListOfAllCustomers() throws IOException, JSONException {
        esbRequestHeadersMap.put("Action", "urn:getAllCustomers");
        RestResponse< JSONObject > esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "getAllCustomers.json");

        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/" + connectorProperties.getProperty("apiVersion") + "/customers" ;
        RestResponse< JSONObject > apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);

        Assert.assertEquals(esbRestResponse.getBody().toString(), apiRestResponse.getBody().toString());
    }

    /**
     *
     * Positive test case for createANewCardForACustomer.
     **/
    @Test(groups = {"wso2.esb"},dependsOnMethods = {"testCreateANewCustomerWithOptionalParameters","testCreateTokenForCardWithMandatoryParameters"},description = "Stripe {createANewCardForACustomer} integration test with positive case.")
    public void testCreateANewCardForACustomer() throws IOException, JSONException {
        esbRequestHeadersMap.put("Action", "urn:createCardForCustomer");
        RestResponse< JSONObject > esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "createCardForACustomer.json");

        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/" + connectorProperties.getProperty("apiVersion") + "/customers/"+ connectorProperties.getProperty("optionalCustomerId")+"/sources?source="+ connectorProperties.getProperty("tokenId") ;
        RestResponse< JSONObject > apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);

        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
    }
    /**
     *
     * Positive test case for deleteCustomer.
     **/
    @Test(groups = {"wso2.esb"},dependsOnMethods = {"testGetAListOfAllCards"},description = "Stripe {deleteCustomer} integration test with positive case.")
    public void testDeleteAnExistingCustomer() throws IOException, JSONException {
        esbRequestHeadersMap.put("Action", "urn:deleteCustomer");
        RestResponse< JSONObject > esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "deleteCustomer.json");

        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
    }

    /**
     *
     * Positive test case for retrieveBalanceTransaction.
     **/
    @Test(groups = {"wso2.esb"},dependsOnMethods = {"testGetListOfBalanceHistoryWithMandatoryParameters"},description = "Stripe {getCurrentAccountBalance} integration test with positive case.")
    public void testRetrieveABalanceTransaction() throws IOException, JSONException {
        esbRequestHeadersMap.put("Action", "urn:retrieveBalanceTransaction");
        RestResponse< JSONObject > esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "retrieveBalanceTransaction.json");
        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/" + connectorProperties.getProperty("apiVersion") + "/balance/history/"+ connectorProperties.getProperty("transactionId") ;
        RestResponse< JSONObject > apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);

        Assert.assertEquals(esbRestResponse.getBody().toString(), apiRestResponse.getBody().toString());
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), apiRestResponse.getHttpStatusCode());
    }

    /**
     *
     * Positive test case for deleteCustomer with negative case.
     **/
    @Test(groups = {"wso2.esb"},description = "Stripe {deleteCustomer} integration test with negative case.")
    public void testDeleteAnExistingCustomerWithNegativeParameter() throws IOException, JSONException {
        esbRequestHeadersMap.put("Action", "urn:deleteCustomer");
        RestResponse< JSONObject > esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "deleteCustomer_Negative.json");

        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/" + connectorProperties.getProperty("apiVersion") + "/customers/"+ connectorProperties.getProperty("invalidCustomerId") ;
        RestResponse< JSONObject > apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);

        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 404);
    }

    /**
     *
     *  Positive test case for getCurrentAccountBalance.
     **/
    @Test(groups = {"wso2.esb"},description = "Stripe {getCurrentAccountBalance} integration test with positive case.")
    public void testGetCurrentAccountBalance() throws IOException, JSONException {
        esbRequestHeadersMap.put("Action", "urn:getCurrentAccountBalance");
        RestResponse< JSONObject > esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "getCurrentAccountBalance.json");

        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/" + connectorProperties.getProperty("apiVersion") + "/balance" ;
        RestResponse< JSONObject > apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);

        Assert.assertEquals(esbRestResponse.getBody().toString(), apiRestResponse.getBody().toString());
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), apiRestResponse.getHttpStatusCode());
    }

    /**
     *
     * Positive test case for getListOfBalanceHistory.
     **/
    @Test(groups = {"wso2.esb"},description = "Stripe {getCurrentAccountBalance} integration test with positive case.")
    public void testGetListOfBalanceHistoryWithMandatoryParameters() throws IOException, JSONException {
        esbRequestHeadersMap.put("Action", "urn:getListOfBalanceHistory");
        RestResponse< JSONObject > esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "getListOfBalanceHistory.json");

        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/" + connectorProperties.getProperty("apiVersion") + "/balance/history" ;
        RestResponse< JSONObject > apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);

        Assert.assertEquals(esbRestResponse.getBody().toString(), apiRestResponse.getBody().toString());
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), apiRestResponse.getHttpStatusCode());

        String transactionId = esbRestResponse.getBody().getJSONArray("data").getJSONObject(0).get("id").toString();
        connectorProperties.put("transactionId", transactionId);
    }

    /**
     *
     * Positive test case for getListOfBalanceHistory with optional parameters.
     **/
    @Test(groups = {"wso2.esb"},description = "Stripe {getListOfBalanceHistory} integration test with optional positive case.")
    public void testGetListOfBalanceHistoryWithOptionalParameters() throws IOException, JSONException {
        esbRequestHeadersMap.put("Action", "urn:getListOfBalanceHistory");
        RestResponse< JSONObject > esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "getListOfBalanceHistoryOptional.json");

        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/" + connectorProperties.getProperty("apiVersion") + "/balance/history?limit=2&type=charge" ;
        RestResponse< JSONObject > apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);

        Assert.assertEquals(esbRestResponse.getBody().toString(), apiRestResponse.getBody().toString());
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), apiRestResponse.getHttpStatusCode());
    }

    /**
     *
     * Positive test case for retrieveBalanceTransaction NegativeTestCase.
     **/
    @Test(groups = {"wso2.esb"},description = "Stripe {retrieveBalanceTransaction} integration test with Negative case.")
    public void testRetrieveABalanceTransactionNegativeTestCase() throws IOException, JSONException {
        esbRequestHeadersMap.put("Action", "urn:retrieveBalanceTransaction");
        RestResponse< JSONObject > esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "retrieveBalanceTransaction_Negative.json");
        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/" + connectorProperties.getProperty("apiVersion") + "/balance/history/"+ connectorProperties.getProperty("invalidTransactionId") ;
        RestResponse< JSONObject > apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);

        Assert.assertEquals(esbRestResponse.getBody().toString(), apiRestResponse.getBody().toString());
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), apiRestResponse.getHttpStatusCode());
    }

    /**
     *
     *  Positive test case for getTransfers with mandatory parameters.
     **/
    @Test(groups = {"wso2.esb"},description = "Stripe {getTransfers} integration test with positive case.")
    public void testGetAListOfAllTransfers() throws IOException, JSONException {
        esbRequestHeadersMap.put("Action", "urn:getTransfers");
        RestResponse< JSONObject > esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "getTransfers_Mandatory.json");
        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/" + connectorProperties.getProperty("apiVersion") + "/transfers?" ;
        RestResponse< JSONObject > apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);

        Assert.assertEquals(esbRestResponse.getBody().toString(), apiRestResponse.getBody().toString());
        String transferId = esbRestResponse.getBody().getJSONArray("data").getJSONObject(0).get("id").toString();
        connectorProperties.put("transferId", transferId);
    }

    /**
     *
     *  Positive test case for getTransfers with optional parameters.
     **/
    @Test(groups = {"wso2.esb"},description = "Stripe {getTransfers} integration test with positive optional case.")
    public void testGetAListOfAllTransfersWithOptionalParameters() throws IOException, JSONException {
        esbRequestHeadersMap.put("Action", "urn:getTransfers");
        RestResponse< JSONObject > esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "getTransfers_Optional.json");

        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/" + connectorProperties.getProperty("apiVersion") + "/transfers?created[lt]=1435036660" ;
        RestResponse< JSONObject > apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);

        Assert.assertEquals(esbRestResponse.getBody().toString(), apiRestResponse.getBody().toString());
    }

    /**
     *
     *  Positive test case for getAllCards with mandatory parameters.
     **/
    @Test(groups = {"wso2.esb"},dependsOnMethods = {"testCreateANewCustomerWithOptionalParameters"},description = "Stripe {getAllCards} integration test with positive case.")
    public void testGetAListOfAllCards() throws IOException, JSONException {
        esbRequestHeadersMap.put("Action", "urn:getAllCards");
        RestResponse< JSONObject > esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "getAllCards.json");

        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/" + connectorProperties.getProperty("apiVersion") + "/customers/"+connectorProperties.getProperty("optionalCustomerId") +"/sources?";
        RestResponse< JSONObject > apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);

        Assert.assertEquals(esbRestResponse.getBody().toString(), apiRestResponse.getBody().toString());
        String cardId = esbRestResponse.getBody().getJSONArray("data").getJSONObject(0).get("id").toString();
        String cusId = esbRestResponse.getBody().getJSONArray("data").getJSONObject(0).get("customer").toString();

        connectorProperties.put("cardId", cardId);
        connectorProperties.put("cusId", cusId);
    }

    /**
     *
     *  Negative test case for getAllCards with Optional parameters.
     **/
    @Test(groups = {"wso2.esb"},dependsOnMethods = {"testGetAListOfAllCards"},description = "Stripe {getAllRefunds} integration test with Optional case.")
    public void testGetAListOfAllRefundsWithOptionalParameters() throws IOException, JSONException {
        esbRequestHeadersMap.put("Action", "urn:getAllRefunds");
        RestResponse< JSONObject > esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "getAllRefunds_Optional.json");

        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/" + connectorProperties.getProperty("apiVersion") + "/refunds?limit=1";
        RestResponse< JSONObject > apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);

        Assert.assertEquals(esbRestResponse.getBody().toString(), apiRestResponse.getBody().toString());
    }

    /**
     *
     *  Positive test case for getAllCards with optional parameters.
     **/
    @Test(groups = {"wso2.esb"},dependsOnMethods = {"testCreateANewCustomerWithOptionalParameters"},description = "Stripe {getAllCards} integration test with positive case.")
    public void testGetAListOfAllCardsWithOptionalParameters() throws IOException, JSONException {
        esbRequestHeadersMap.put("Action", "urn:getAllCards");
        RestResponse< JSONObject > esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "getAllCards_Optional.json");

        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/" + connectorProperties.getProperty("apiVersion") + "/customers/"+connectorProperties.getProperty("cusId") +"/sources?limit=1";
        RestResponse< JSONObject > apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);

        Assert.assertEquals(esbRestResponse.getBody().toString(), apiRestResponse.getBody().toString());
    }

    /**
     * * Negative test case for getAllCards with negative parameters.
     **/
    @Test(groups = {"wso2.esb"},description = "Stripe {testRetrieveAnExistingTransfer} integration test with negative case.")
    public void testGetAListOfAllCardsWithNegativeParameters() throws IOException, JSONException {
        esbRequestHeadersMap.put("Action", "urn:getAllCards");
        RestResponse< JSONObject > esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "getAllCards_Negative.json");

        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/" + connectorProperties.getProperty("apiVersion") + "/customers/invalid/sources?" ;
        RestResponse< JSONObject > apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);

        Assert.assertEquals(esbRestResponse.getBody().toString(), apiRestResponse.getBody().toString());
    }

    /**
     *
     *  Positive test case for retrieveCard with mandatory parameters.
     **/
    @Test(groups = {"wso2.esb"},dependsOnMethods = {"testGetAListOfAllCards"},description = "Stripe {retrieveCard} integration test with positive case.")
    public void testRetrieveAnExistingCard() throws IOException, JSONException {
        esbRequestHeadersMap.put("Action", "urn:retrieveCard");
        RestResponse< JSONObject > esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "retrieveCard.json");

        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/" + connectorProperties.getProperty("apiVersion") + "/customers/"+connectorProperties.getProperty("cusId") +"/sources/"+connectorProperties.getProperty("cardId");
        RestResponse< JSONObject > apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);

        Assert.assertEquals(esbRestResponse.getBody().toString(), apiRestResponse.getBody().toString());
    }

    /**
     * * Negative test case for getAllCards with negative parameters.
     **/
    @Test(groups = {"wso2.esb"},dependsOnMethods = {"testGetAListOfAllCards"},description = "Stripe {retrieveCard} integration test with negative case.")
    public void testRetrieveAnExistingCardWithNegativeParameters() throws IOException, JSONException {
        esbRequestHeadersMap.put("Action", "urn:retrieveCard");
        RestResponse< JSONObject > esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "retrieveCard_Negative.json");

        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/" + connectorProperties.getProperty("apiVersion") + "/customers/"+connectorProperties.getProperty("cusId") +"/sources/"+ connectorProperties.getProperty("invalidCardId");
        RestResponse< JSONObject > apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);

        Assert.assertEquals(esbRestResponse.getBody().toString(), apiRestResponse.getBody().toString());
    }

    /**
     * Positive test case for getAllCharges with mandatory parameters.
     */
    @Test(groups = {"wso2.esb"}, description = "Stripe {getAllCards} integration test with positive case.")
    public void testGetAListOfAllCharges() throws IOException, JSONException {
        esbRequestHeadersMap.put("Action", "urn:getAllCharges");
        RestResponse<JSONObject> esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "getAllCharges.json");

        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/" + connectorProperties.getProperty("apiVersion") + "/charges";
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);

        Assert.assertEquals(esbRestResponse.getBody().toString(), apiRestResponse.getBody().toString());
        String chargeId = esbRestResponse.getBody().getJSONArray("data").getJSONObject(0).get("id").toString();
        connectorProperties.put("chargeId", chargeId);
    }

    /**
     * Positive test case for getAllCharges with optional parameters.
     */
    @Test(groups = {"wso2.esb"}, description = "Stripe {getAllCards} integration test with positive case.")
    public void testGetAListOfAllChargesWithOptionalParameters() throws IOException, JSONException {
        esbRequestHeadersMap.put("Action", "urn:getAllCharges");
        RestResponse<JSONObject> esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "getAllCharges_Optional.json");

        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/" + connectorProperties.getProperty("apiVersion") + "/charges?limit=1";
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);

        Assert.assertEquals(esbRestResponse.getBody().toString(), apiRestResponse.getBody().toString());
    }

    /**
     * Positive test case for retrieveCharge with mandatory parameters.
     */
    @Test(groups = {"wso2.esb"}, dependsOnMethods = {"testGetAListOfAllCharges"}, description = "Stripe {getAllCards} integration test with positive case.")
    public void testRetrieveAnExistingCharge() throws IOException, JSONException {
        esbRequestHeadersMap.put("Action", "urn:retrieveCharge");
        RestResponse<JSONObject> esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "retrieveCharge.json");

        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/" + connectorProperties.getProperty("apiVersion") + "/charges/" + connectorProperties.getProperty("chargeId");
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);

        Assert.assertEquals(esbRestResponse.getBody().toString(), apiRestResponse.getBody().toString());
    }

    /**
     * Positive test case for retrieveCharge with negative parameters.
     */
    @Test(groups = {"wso2.esb"}, description = "Stripe {getAllCards} integration test with positive case.")
    public void testRetrieveAnExistingChargeWithNegativeParameters() throws IOException, JSONException {
        esbRequestHeadersMap.put("Action", "urn:retrieveCharge");
        RestResponse<JSONObject> esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "retrieveCharge_Negative.json");

        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/" + connectorProperties.getProperty("apiVersion") + "/charges/invalid";
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);

        Assert.assertEquals(esbRestResponse.getBody().toString(), apiRestResponse.getBody().toString());
    }

    /**
     * Positive test case for createCharge with mandatory parameters.
     */
    @Test(groups = {"wso2.esb"},dependsOnMethods = {"testCreateTokenForCardMandatoryParameters"}, description = "Stripe {createCharge} integration test with positive case.")
    public void testCreateANewCharge() throws IOException, JSONException {
        esbRequestHeadersMap.put("Action", "urn:createCharge");
        RestResponse<JSONObject> esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "createCharge.json");

        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/" + connectorProperties.getProperty("apiVersion") + "/charges/";
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);

        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
    }
    /**
     *
     *  Positive test case for getAllRefunds with mandatory parameters.
     **/
    @Test(groups = {"wso2.esb"},description = "Stripe {getAllRefunds} integration test with positive case.")
    public void testGetAListOfAllRefunds() throws IOException, JSONException {
        esbRequestHeadersMap.put("Action", "urn:getAllRefunds");
        RestResponse< JSONObject > esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "getAllRefunds.json");

        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/" + connectorProperties.getProperty("apiVersion") + "/refunds?";
        RestResponse< JSONObject > apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);

        Assert.assertEquals(esbRestResponse.getBody().toString(), apiRestResponse.getBody().toString());
    }

    /**
     * Positive test case for getAllInvoices with mandatory parameters.
     */
    @Test(groups = {"wso2.esb"}, description = "Stripe {getAllInvoices} integration test with positive case.")
    public void testGetAListOfInvoices() throws IOException, JSONException {
        esbRequestHeadersMap.put("Action", "urn:getAllInvoices");
        RestResponse<JSONObject> esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "getAllInvoices.json");

        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/" + connectorProperties.getProperty("apiVersion") + "/invoices?" ;
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);

        Assert.assertEquals(esbRestResponse.getBody().toString(), apiRestResponse.getBody().toString());
        String invoiceId = esbRestResponse.getBody().getJSONArray("data").getJSONObject(0).get("id").toString();
        connectorProperties.put("invoiceId", invoiceId);
    }

    /**
     * Positive test case for getAllInvoices with optional parameters.
     */
    @Test(groups = {"wso2.esb"}, description = "Stripe {getAllInvoices} integration test with positive case.")
    public void testGetAListOfInvoicesWithOptionalParameters() throws IOException, JSONException {
        esbRequestHeadersMap.put("Action", "urn:getAllInvoices");
        RestResponse<JSONObject> esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "getAllInvoices_Optional.json");

        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/" + connectorProperties.getProperty("apiVersion") + "/invoices?limit=1" ;
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);

        Assert.assertEquals(esbRestResponse.getBody().toString(), apiRestResponse.getBody().toString());
    }
    /**
     * Positive test case for retrieveInvoice with mandatory parameters.
     */
    @Test(groups = {"wso2.esb"},dependsOnMethods = "testGetAListOfInvoices",description = "Stripe {retrieveInvoice} integration test with positive case.")
    public void testRetrieveAnExistingInvoice() throws IOException, JSONException {
        esbRequestHeadersMap.put("Action", "urn:retrieveInvoice");
        RestResponse<JSONObject> esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "retrieveInvoice.json");

        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/" + connectorProperties.getProperty("apiVersion") + "/invoices/"+ connectorProperties.getProperty("invoiceId") ;
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);

        Assert.assertEquals(esbRestResponse.getBody().toString(), apiRestResponse.getBody().toString());
    }

    /**
     * Positive test case for retrieveInvoice with negative parameters.
     */
    @Test(groups = {"wso2.esb"},description = "Stripe {retrieveInvoice} integration test with positive case.")
    public void testRetrieveAnExistingInvoiceWithNegativeParameters() throws IOException, JSONException {
        esbRequestHeadersMap.put("Action", "urn:retrieveInvoice");
        RestResponse<JSONObject> esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "retrieveInvoice_Negative.json");

        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/" + connectorProperties.getProperty("apiVersion") + "/invoices/invalid" ;
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);

        Assert.assertEquals(esbRestResponse.getBody().toString(), apiRestResponse.getBody().toString());
    }

     /**
     * Positive test case for retrieveInvoicesLineItems with mandatory parameters.
     */
    @Test(groups = {"wso2.esb"},dependsOnMethods = "testGetAListOfInvoices",description = "Stripe {retrieveInvoicesLineItems} integration test with positive case.")
    public void testRetrieveAnInvoicesLineItems() throws IOException, JSONException {
        esbRequestHeadersMap.put("Action", "urn:retrieveInvoicesLineItems");
        RestResponse<JSONObject> esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "retrieveInvoicesLineItems.json");

        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/" + connectorProperties.getProperty("apiVersion") + "/invoices/"+ connectorProperties.getProperty("invoiceId")+"/lines?" ;
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);

        Assert.assertEquals(esbRestResponse.getBody().toString(), apiRestResponse.getBody().toString());
    }

    /**
     * Positive test case for retrieveInvoicesLineItems with optional parameters.
     */
    @Test(groups = {"wso2.esb"},dependsOnMethods = "testGetAListOfInvoices",description = "Stripe {retrieveInvoicesLineItems} integration test with positive case.")
    public void testRetrieveAnInvoicesLineItemsWithOptionalParameter() throws IOException, JSONException {
        esbRequestHeadersMap.put("Action", "urn:retrieveInvoicesLineItems");
        RestResponse<JSONObject> esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "retrieveInvoicesLineItems_Optional.json");

        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/" + connectorProperties.getProperty("apiVersion") + "/invoices/"+ connectorProperties.getProperty("invoiceId")+"/lines?limit=1" ;
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);

        Assert.assertEquals(esbRestResponse.getBody().toString(), apiRestResponse.getBody().toString());
    }

    /**
     * Positive test case for retrieveInvoicesLineItems with negative parameters.
     */
    @Test(groups = {"wso2.esb"},description = "Stripe {retrieveInvoicesLineItems} integration test with positive case.")
    public void testRetrieveAnInvoicesLineItemsWithNegativeParameter() throws IOException, JSONException {
        esbRequestHeadersMap.put("Action", "urn:retrieveInvoicesLineItems");
        RestResponse<JSONObject> esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "retrieveInvoicesLineItems_Negative.json");

        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/" + connectorProperties.getProperty("apiVersion") + "/invoices/invalid/lines?" ;
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);

        Assert.assertEquals(esbRestResponse.getBody().toString(), apiRestResponse.getBody().toString());
    }

    /**
     * Positive test case for createInvoice with mandatory parameters.
     */
    @Test(groups = {"wso2.esb"}, description = "Stripe {createCharge} integration test with positive case.")
    public void testCreateAnInvoice() throws IOException, JSONException {
        esbRequestHeadersMap.put("Action", "urn:createInvoice");
        RestResponse<JSONObject> esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "createInvoice.json");

        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        String invoiceId = esbRestResponse.getBody().getString("id");
        connectorProperties.put("invoiceIds", invoiceId);

        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/" + connectorProperties.getProperty("apiVersion") + "/invoices/" +connectorProperties.getProperty("invoiceIds");
        RestResponse< JSONObject > apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);
        Assert.assertEquals(200, apiRestResponse.getHttpStatusCode());
    }

    /**
     * Positive test case for payInvoice with mandatory parameters.
     */
    @Test(groups = {"wso2.esb"},dependsOnMethods = {"testCreateAnInvoice"},description = "Stripe {createCharge} integration test with positive case.")
    public void testPayAnInvoice() throws IOException, JSONException {
        esbRequestHeadersMap.put("Action", "urn:payInvoice");
        RestResponse<JSONObject> esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "payInvoice.json");

        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
    }

}
