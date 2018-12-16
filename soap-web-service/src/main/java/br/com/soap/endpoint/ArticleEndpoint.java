package br.com.soap.endpoint;

import com.concretepage.gs_ws.AddArticleRequest;
import com.concretepage.gs_ws.AddArticleResponse;
import com.concretepage.gs_ws.ArticleInfo;
import com.concretepage.gs_ws.DeleteArticleRequest;
import com.concretepage.gs_ws.DeleteArticleResponse;
import com.concretepage.gs_ws.GetAllArticlesResponse;
import com.concretepage.gs_ws.GetArticleByIdRequest;
import com.concretepage.gs_ws.GetArticleByIdResponse;
import com.concretepage.gs_ws.ServiceStatus;
import com.concretepage.gs_ws.UpdateArticleRequest;
import com.concretepage.gs_ws.UpdateArticleResponse;
import java.util.ArrayList;
import java.util.List;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ArticleEndpoint {

    
    //http://localhost:8080/application/soapws/articles.wsdl
    
    private static final String NAMESPACE_URI = "http://www.concretepage.com/article-ws";
    

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getArticleByIdRequest")
    @ResponsePayload
    public GetArticleByIdResponse getArticle(@RequestPayload GetArticleByIdRequest request) {
        GetArticleByIdResponse response = new GetArticleByIdResponse();
        ArticleInfo articleInfo = new ArticleInfo();

        response.setArticleInfo(articleInfo);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllArticlesRequest")
    @ResponsePayload
    public GetAllArticlesResponse getAllArticles() {
        GetAllArticlesResponse response = new GetAllArticlesResponse();
        List<ArticleInfo> articleInfoList = new ArrayList<>();

        response.getArticleInfo().addAll(articleInfoList);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addArticleRequest")
    @ResponsePayload
    public AddArticleResponse addArticle(@RequestPayload AddArticleRequest request) {
        AddArticleResponse response = new AddArticleResponse();
        ServiceStatus serviceStatus = new ServiceStatus();

        ArticleInfo articleInfo = new ArticleInfo();

        response.setArticleInfo(articleInfo);
        serviceStatus.setStatusCode("SUCCESS");
        serviceStatus.setMessage("Content Added Successfully");
        response.setServiceStatus(serviceStatus);

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateArticleRequest")
    @ResponsePayload
    public UpdateArticleResponse updateArticle(@RequestPayload UpdateArticleRequest request) {


        ServiceStatus serviceStatus = new ServiceStatus();
        serviceStatus.setStatusCode("SUCCESS");
        serviceStatus.setMessage("Content Updated Successfully");
        UpdateArticleResponse response = new UpdateArticleResponse();
        response.setServiceStatus(serviceStatus);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteArticleRequest")
    @ResponsePayload
    public DeleteArticleResponse deleteArticle(@RequestPayload DeleteArticleRequest request) {

        ServiceStatus serviceStatus = new ServiceStatus();

        serviceStatus.setStatusCode("SUCCESS");
        serviceStatus.setMessage("Content Deleted Successfully");

        DeleteArticleResponse response = new DeleteArticleResponse();
        response.setServiceStatus(serviceStatus);
        return response;
    }
}
