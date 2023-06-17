/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BurpSuiteExtension3;

import burp.api.montoya.MontoyaApi;
import burp.api.montoya.core.Annotations;
import burp.api.montoya.core.HighlightColor;
import burp.api.montoya.http.handler.*;
import burp.api.montoya.http.message.requests.HttpRequest;
import burp.api.montoya.http.message.responses.HttpResponse;
import burp.api.montoya.logging.Logging;

/**
 *
 * @author TD050
 */
public class HttpReqRes implements HttpHandler {

    MontoyaApi api ;
    Logging logging ;
    String url ; 
    
    public HttpReqRes(MontoyaApi api){
        this.api = api;
        this.logging = api.logging();
    }
    
    @Override
    public RequestToBeSentAction handleHttpRequestToBeSent(HttpRequestToBeSent hrtbs) {
       
        Annotations annotation = hrtbs.annotations();
        
        // We will add a new header in the request.
        HttpRequest httpRequest = hrtbs.withAddedHeader("Custom-Header", "Header Added");
        logging.logToOutput(this.getClass().getName() + ": handleHttpRequestToBeSent: 1 : " + hrtbs.url().toString());
        this.url = hrtbs.url().toString();
        return RequestToBeSentAction.continueWith(httpRequest, annotation);
    }

    @Override
    public ResponseReceivedAction handleHttpResponseReceived(HttpResponseReceived hrr) {
        
        Annotations annotations = hrr.annotations();
        
        HttpResponse httpResponse = hrr.withAddedHeader("Custom-Header-Response", "Header Added") ;
        
        // lets highlight the response 
        annotations.setHighlightColor(HighlightColor.GREEN);
        logging.logToOutput(this.getClass().getName() + ": handleHttpResponseReceived: 2 " + this.url);
        return ResponseReceivedAction.continueWith(httpResponse, annotations);
    }
    
}
