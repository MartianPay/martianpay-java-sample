package com.martianpay.sdk;

import com.martianpay.developer.PaymentIntentCreateRequest;
import com.martianpay.developer.PaymentIntentCreateResp;
import com.martianpay.developer.PaymentIntentUpdateRequest;
import com.martianpay.developer.PaymentIntentUpdateResp;
import com.martianpay.developer.PaymentIntentGetResp;
import com.martianpay.developer.PaymentIntentListRequest;
import com.martianpay.developer.PaymentIntentListResponse;
import com.martianpay.developer.PaymentIntentCancelRequest;
import com.martianpay.developer.PaymentIntentLinkCreateRequest;
import com.martianpay.developer.PaymentIntentLinkCreateResp;
import com.martianpay.developer.PaymentIntentLinkUpdateRequest;
import com.martianpay.developer.PaymentIntentInvoiceCreateRequest;
import com.martianpay.developer.PaymentIntentInvoiceCreateResponse;

import java.io.IOException;

/**
 * PaymentIntentService provides methods for managing payment intents
 */
public class PaymentIntentService extends MartianPayClient {

    public PaymentIntentService(String apiKey) {
        super(apiKey);
    }

    public PaymentIntentService(String apiKey, String baseUrl) {
        super(apiKey, baseUrl);
    }

    /**
     * Creates a new payment intent
     *
     * @param request Payment intent creation parameters
     * @return Payment intent creation response
     * @throws IOException if request fails
     */
    public PaymentIntentCreateResp createPaymentIntent(PaymentIntentCreateRequest request) throws IOException {
        return sendRequest("POST", "/v1/payment_intents", request, PaymentIntentCreateResp.class);
    }

    /**
     * Updates a payment intent
     *
     * @param id Payment intent ID
     * @param request Payment intent update parameters
     * @return Payment intent update response
     * @throws IOException if request fails
     */
    public PaymentIntentUpdateResp updatePaymentIntent(String id, PaymentIntentUpdateRequest request) throws IOException {
        String path = String.format("/v1/payment_intents/%s", id);
        return sendRequest("POST", path, request, PaymentIntentUpdateResp.class);
    }

    /**
     * Retrieves a specific payment intent by ID
     *
     * @param id Payment intent ID
     * @return Payment intent get response
     * @throws IOException if request fails
     */
    public PaymentIntentGetResp getPaymentIntent(String id) throws IOException {
        String path = String.format("/v1/payment_intents/%s", id);
        return sendRequest("GET", path, null, PaymentIntentGetResp.class);
    }

    /**
     * Retrieves a list of payment intents based on the provided parameters
     *
     * @param request List parameters
     * @return Payment intent list response
     * @throws IOException if request fails
     */
    public PaymentIntentListResponse listPaymentIntents(PaymentIntentListRequest request) throws IOException {
        return sendRequestWithQuery("GET", "/v1/payment_intents", request, PaymentIntentListResponse.class);
    }

    /**
     * Cancels a payment intent
     *
     * @param id Payment intent ID
     * @param request Cancel request parameters
     * @return Payment intent update response
     * @throws IOException if request fails
     */
    public PaymentIntentUpdateResp cancelPaymentIntent(String id, PaymentIntentCancelRequest request) throws IOException {
        String path = String.format("/v1/payment_intents/%s/cancel", id);
        return sendRequest("POST", path, request, PaymentIntentUpdateResp.class);
    }

    /**
     * Creates a payment intent with payment link
     *
     * @param request Payment intent link creation parameters
     * @return Payment intent link creation response
     * @throws IOException if request fails
     */
    public PaymentIntentLinkCreateResp createPaymentIntentLink(PaymentIntentLinkCreateRequest request) throws IOException {
        return sendRequest("POST", "/v1/payment_intents/link", request, PaymentIntentLinkCreateResp.class);
    }

    /**
     * Updates a payment intent link
     *
     * @param id Payment intent ID
     * @param request Payment intent link update parameters
     * @return Payment intent update response
     * @throws IOException if request fails
     */
    public PaymentIntentUpdateResp updatePaymentIntentLink(String id, PaymentIntentLinkUpdateRequest request) throws IOException {
        String path = String.format("/v1/payment_intents/%s/link", id);
        return sendRequest("POST", path, request, PaymentIntentUpdateResp.class);
    }

    /**
     * Creates a payment intent with invoice
     *
     * @param request Payment intent invoice creation parameters
     * @return Payment intent invoice creation response
     * @throws IOException if request fails
     */
    public PaymentIntentInvoiceCreateResponse createPaymentIntentInvoice(PaymentIntentInvoiceCreateRequest request) throws IOException {
        return sendRequest("POST", "/v1/payment_intents/invoice", request, PaymentIntentInvoiceCreateResponse.class);
    }
}
