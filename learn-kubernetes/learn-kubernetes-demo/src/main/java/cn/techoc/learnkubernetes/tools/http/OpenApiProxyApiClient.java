package cn.techoc.learnkubernetes.tools.http;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@Component
public class OpenApiProxyApiClient {
    private static final Integer DEFAULT_MAX_CACHE_SIZE = 256;

    @Setter
    private Integer maxCacheSize = DEFAULT_MAX_CACHE_SIZE;

    private Map<String, KubernetesClient> clientMap;


    private synchronized KubernetesClient getClient(Integer clusterId) {
        String currentUserToken = "";
        if (clientMap == null) {
            initClientMap();
        }
        KubernetesClient client = clientMap.get(clientMapKey(clusterId));
        if (client != null) {
            client.getConfiguration().setOauthToken(currentUserToken);
        } else {
//            String masterUrl = endWithSlash(openapiAddress + openapiProxyPrefix) + clusterId;
//            client = createClient(masterUrl);
            clientMap.put(clientMapKey(clusterId), client);
            log.info("Create KubernetesClient for cluster/{}, tenant/{} Successfully.", clusterId, "test");
        }
        return client;
    }

    public KubernetesClient createClient(String url) {
        Config config = new ConfigBuilder().withMasterUrl(url).build();
        config.setTrustCerts(true);
        config.setConnectionTimeout(60000);
        config.setRequestTimeout(60000);
        //排除fabric8从环境变量或部署环境中获取的默认的ns配置
        config.setNamespace(null);
//        config.setOauthToken(currentUserToken);
//        config.getAutoOAuthToken()
        return new KubernetesClientBuilder().withConfig(config).build();
    }

    private void initClientMap() {
        clientMap = new LinkedHashMap<String, KubernetesClient>() {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, KubernetesClient> eldest) {
                return size() > maxCacheSize;
            }
        };
    }

    private String clientMapKey(Integer clusterId) {
        return "test" + clusterId;
    }

    private String endWithSlash(String source) {
        return source.endsWith("/") ? source : source + "/";
    }
}
