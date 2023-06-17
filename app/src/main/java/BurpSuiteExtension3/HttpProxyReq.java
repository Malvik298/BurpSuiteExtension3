/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BurpSuiteExtension3;

import burp.api.montoya.MontoyaApi;
import burp.api.montoya.logging.Logging;
import burp.api.montoya.proxy.Proxy;
import burp.api.montoya.proxy.http.InterceptedRequest;
import burp.api.montoya.proxy.http.ProxyRequestHandler;
import burp.api.montoya.proxy.http.ProxyRequestReceivedAction;
import burp.api.montoya.proxy.http.ProxyRequestToBeSentAction;

/**
 *
 * @author TD050
 */
public class HttpProxyReq implements ProxyRequestHandler {
    
    MontoyaApi api ;
    Logging logging ;
    
    public HttpProxyReq(MontoyaApi api){
    this.api = api ;
    this.logging = api.logging();
    }

    @Override
    public ProxyRequestReceivedAction handleRequestReceived(InterceptedRequest ir) {
        
        logging.logToOutput(this.getClass().getName() + ": handleRequestReceived: 3 : " + ir.url().toString());
        return ProxyRequestReceivedAction.intercept(ir);
    }

    @Override
    public ProxyRequestToBeSentAction handleRequestToBeSent(InterceptedRequest ir) {
        logging.logToOutput(this.getClass().getName() + ": handleRequestToBeSent: 4 : " + ir.url().toString());
        return ProxyRequestToBeSentAction.continueWith(ir);
    }
    
}
