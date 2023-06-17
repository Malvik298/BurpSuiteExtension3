
package BurpSuiteExtension3;

import burp.api.montoya.*;
import burp.api.montoya.logging.Logging;
import burp.api.montoya.proxy.http.InterceptedResponse;
import burp.api.montoya.proxy.http.*;


public class HttpProxyResp implements ProxyResponseHandler {

    MontoyaApi api ;
    Logging logging ;
    
    public HttpProxyResp(MontoyaApi api){
    this.api = api ;
    this.logging = api.logging();
    }
    
    @Override
    public ProxyResponseReceivedAction handleResponseReceived(InterceptedResponse ir) {
    logging.logToOutput(this.getClass().getName() + ": handleResponseReceived: 5 : " + ir.destinationIpAddress().toString()); 
    return ProxyResponseReceivedAction.continueWith(ir);
    }

    @Override
    public ProxyResponseToBeSentAction handleResponseToBeSent(InterceptedResponse ir) {
        logging.logToOutput(this.getClass().getName() + ": handleResponseToBeSent: 6 : " + ir.destinationIpAddress().toString()); 
        return ProxyResponseToBeSentAction.continueWith(ir);
    }
    
}
