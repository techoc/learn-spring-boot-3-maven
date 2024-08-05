package cn.techoc.learnkubernetes;

import cn.techoc.learnkubernetes.tools.http.OpenApiProxyApiClient;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.client.KubernetesClient;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LearnKubernetesApplicationTests {

    @Resource
    private OpenApiProxyApiClient openApiProxyApiClient;

    @Test
    void contextLoads() {
        KubernetesClient client = openApiProxyApiClient.createClient("https://192.168.142.128:8443");
        PodList keda = client.pods().inNamespace("keda").list();
        System.out.println(keda.getItems().get(0).getMetadata().getName());
    }

}
